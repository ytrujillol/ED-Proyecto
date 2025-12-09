package analysis;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class MockDataGenerator {
    private static final Random rand = new Random(42);

    // Fixed data pools
    private static final String[] FIRST_NAMES = {"Carlos", "Alejandra", "John", "Samuel", "Allison", "Fernando",
            "Santiago", "Paola", "David", "Sara", "Jose", "Daniela", "Marta", "Felipe", "Luisa", "Sofia",
            "Sebastian", "Dylan", "Alejandro", "Martin", "Luna", "Juliana", "Cesar", "Ana", "Maria", "Luis"};

    private static final String[] LAST_NAMES = {"Pérez", "González", "Carreño", "Flores", "Cortés", "Martínez",
            "Monroy", "Guzmán", "Contreras", "Villamil", "Castro", "Forero", "Quiroga", "Gamboa", "Castillo",
            "Méndez", "Jiménez", "Gutiérrez", "Campos", "Casas", "Sierra", "López", "Rivera", "Rodriguez", "Ramirez"};

    private static final String[] SUBJECTS = {"Cálculo Diferencial", "Álgebra Lineal", "Programación Básica",
            "Programación Avanzada", "Física I", "Física II"};

    private static final String[] HORARIOS = {"7:00 am - 9:00 am", "9:00 am - 11:00 am", "11:00 am - 1:00 pm",
            "2:00 pm - 4:00 pm", "4:00 pm - 6:00 pm"};

    // Generate ALL CSV files for GestorTutorias constructor
    public static void generarDatosCompletos(int numEstudiantes, int numTutores, int numTutorias) {
        generarEstudiantesCSV(numEstudiantes);
        generarTutoresCSV(numTutores);
        generarTutoriasCSV(numTutorias);
        System.out.println("✅ Generated CSV files:");
        System.out.println("   - estudiantes.csv (" + numEstudiantes + ")");
        System.out.println("   - tutores.csv (" + numTutores + ")");
        System.out.println("   - tutorias.csv (" + numTutorias + ")");
    }

    // 1. ESTUDIANTES CSV: documento,nombre,correo,semestre
    public static void generarEstudiantesCSV(int cantidad) {
        try (FileWriter writer = new FileWriter("analysis/estudiantes.csv")) {
            writer.write("documento,nombre,correo,semestre\n");
            for (int i = 0; i < cantidad; i++) {
                String documento = String.format("1001022%04d", 1000 + i);
                String nombre = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)] + " " +
                        LAST_NAMES[rand.nextInt(LAST_NAMES.length)];
                String correo = nombre.replace(" ", "").toLowerCase() + "@unal.edu.co";
                int semestre = rand.nextInt(10) + 1;
                writer.write(String.format("%s,%s,%s,%d\n", documento, nombre, correo, semestre));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. TUTORES CSV: documento,nombre,correo,asignatura1,asignatura2
    public static void generarTutoresCSV(int cantidad) {
        try (FileWriter writer = new FileWriter("analysis/tutores.csv")) {
            writer.write("documento,nombre,correo,asignatura1,asignatura2\n");
            for (int i = 0; i < cantidad; i++) {
                String documento = String.format("1001022%04d", 2000 + i);
                String nombre = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)] + " " +
                        LAST_NAMES[rand.nextInt(LAST_NAMES.length)];
                String correo = nombre.replace(" ", "").toLowerCase() + "@unal.edu.co";
                String asignatura1 = SUBJECTS[rand.nextInt(SUBJECTS.length)];
                String asignatura2 = SUBJECTS[rand.nextInt(SUBJECTS.length)];
                writer.write(String.format("%s,%s,%s,%s,%s\n", documento, nombre, correo, asignatura1, asignatura2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. TUTORIAS CSV (CONTROLLED SIZE): idEstudiante,idTutor,asignatura,horario,prioridad,fecha,estado
    public static void generarTutoriasCSV(int cantidad) {

        // Load existing estudiantes and tutores rows
        List<String[]> tutRows = CSVUtils.readRows("analysis/tutores.csv");
        List<String> estIds = CSVUtils.readFirstColumn("analysis/estudiantes.csv");

        try (FileWriter writer = new FileWriter("analysis/tutorias.csv")) {

            writer.write("idEstudiante,idTutor,asignatura,horario,prioridad,fecha,estado\n");

            for (int i = 0; i < cantidad; i++) {

                // Pick a student
                String idEstudiante = estIds.get(rand.nextInt(estIds.size()));

                // Pick a tutor (full row)
                String[] tutorRow = tutRows.get(1 + rand.nextInt(tutRows.size() - 1));
                String idTutor = tutorRow[0];

                // Get subjects from that tutor
                String asig1 = tutorRow[3];
                String asig2 = tutorRow.length > 4 ? tutorRow[4] : null;

                // Pick a subject the tutor actually teaches
                String asignatura = (asig2 == null)
                        ? asig1
                        : (rand.nextBoolean() ? asig1 : asig2);

                String horario = HORARIOS[rand.nextInt(HORARIOS.length)];
                int prioridad = rand.nextInt(5) + 1;
                LocalDate fecha = LocalDate.now().plusDays(rand.nextInt(365));
                String estado = rand.nextBoolean() ? "Activa" : "Finalizada";

                writer.write(String.format("%s,%s,%s,%s,%d,%s,%s\n",
                        idEstudiante, idTutor, asignatura, horario, prioridad, fecha, estado));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Convenience method: Generate for different TUTORIA sizes (keeping estudiantes/tutores fixed)
    public static void generarEscenariosPrueba() {
        // Fixed base data
        generarEstudiantesCSV(200);
        generarTutoresCSV(10);

        // Different TUTORIA sizes for testing
        int[] tamTutorias = {10, 50, 100, 500, 1000, 5000, 10000};
        for (int n : tamTutorias) {
            generarTutoriasCSV(n);
        }
        System.out.println("✅ Generated test scenarios for n = " + Arrays.toString(tamTutorias));
    }
}