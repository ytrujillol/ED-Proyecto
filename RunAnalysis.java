import data_structures.*;
import modules.*;
import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class RunAnalysis {

    private static List<String[]> tutorias;     // CSV split lines
    private static List<String[]> estudiantes;
    private static List<String[]> tutores;

    // Load all CSVs once
    private static void loadCSVs() {
        tutorias = loadCSV("analysis/tutorias.csv");
        estudiantes = loadCSV("analysis/estudiantes.csv");
        tutores = loadCSV("analysis/tutores.csv");
    }

    private static List<String[]> loadCSV(String path) {
        List<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line.split(","));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return result;
    }

    // Create a fresh GestorTutorias instance
    private static GestorTutorias createGestor() {

        data_structures.HashMap<String, Estudiante> est = new data_structures.HashMap<>();
        data_structures.HashMap<String, ListaEnlazada<Tutoria>> porEst = new data_structures.HashMap<>();
        data_structures.HashMap<String, ArrayMaxHeap> porTutor = new data_structures.HashMap<>();
        data_structures.HashMap<String, ListaEnlazada<Tutoria>> historial = new data_structures.HashMap<>();
        data_structures.HashMap<String, Tutor[]> porAsignatura = new data_structures.HashMap<>();

        // fill estudiantes
        for (String[] e : estudiantes) {
            est.put(e[0], new Estudiante(e[0], e[1], e[2], Integer.parseInt(e[3])));
        }

        // fill tutores
        for (String[] t : tutores) {
            String id = t[0];
            Tutor tutor = new Tutor(id, t[1], t[2]);

            String asig1 = t[3];
            porAsignatura.put(asig1, new Tutor[]{ tutor });

            if (t.length > 4) {
                String asig2 = t[4];
                porAsignatura.put(asig2, new Tutor[]{ tutor });
            }
        }

        return new GestorTutorias(est, porEst, porTutor, historial, porAsignatura);
    }

    // Convert CSV tutoría into values required by solicitarTutoria
    private static void insertarTutoriaCSV(GestorTutorias g, String[] t) {
        String idEst = t[0];
        String idTutor = t[1];
        String asignatura = t[2];
        String horario = t[3];
        int prioridad = Integer.parseInt(t[4]);

        g.solicitarTutoria(idTutor, idEst, asignatura, horario, prioridad);
    }

    // Run the timing experiment for one operation
    private static double medirOperacion(Runnable op) {
        long start = System.nanoTime();
        op.run();
        long end = System.nanoTime();
        return (end - start) / 1e6; // ms
    }

    // MAIN ENTRY
    public static void start() {
        loadCSVs();
        int[] puntos = generarPuntosLog(20, 100, 1_000_000);

        medirFinalizar(puntos);
        medirSolicitar(puntos);
        medirCancelar(puntos);
    }

    private static int[] generarPuntosLog(int count, int min, int max) {
        int[] v = new int[count];

        double logMin = Math.log10(min);
        double logMax = Math.log10(max);
        double step = (logMax - logMin) / (count - 1);

        for (int i = 0; i < count; i++) {
            v[i] = (int) Math.pow(10, logMin + step * i);
        }

        return v;
    }
    private static void medirFinalizar(int[] puntos) {
        try (FileWriter writer = new FileWriter("analysis/resultados_finalizar.csv")) {
            writer.write("n,avg_ms\n");

            for (int n : puntos) {

                GestorTutorias g = createGestor();

                // Insert first n tutorias
                for (int i = 0; i < n && i < tutorias.size(); i++) {
                    insertarTutoriaCSV(g, tutorias.get(i));
                }

                double total = 0;

                // Measure finalizar 100 times
                for (int k = 0; k < 100; k++) {
                    total += medirOperacion(() -> {
                        g.finalizar("10010222000");
                    });
                }

                double avg = total / 100;
                writer.write(n + "," + avg + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void medirSolicitar(int[] puntos) {
        try (FileWriter writer = new FileWriter("analysis/resultados_solicitar.csv")) {
            writer.write("n,avg_ms\n");

            for (int n : puntos) {

                GestorTutorias g = createGestor();

                // First n tutorias inserted to create the base heap
                for (int i = 0; i < n && i < tutorias.size(); i++) {
                    insertarTutoriaCSV(g, tutorias.get(i));
                }

                // Next 100 tutorias for timing
                double total = 0;

                for (int k = 0; k < 100; k++) {
                    int idx = n + k;
                    if (idx >= tutorias.size()) break;

                    String[] t = tutorias.get(idx);

                    total += medirOperacion(() -> insertarTutoriaCSV(g, t));
                }

                double avg = total / 100;
                writer.write(n + "," + avg + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void medirCancelar(int[] puntos) {
        try (FileWriter writer = new FileWriter("analysis/resultados_cancelar.csv")) {
            writer.write("n,avg_ms\n");

            for (int n : puntos) {

                GestorTutorias g = createGestor();

                // Insert n tutorias to create the initial state
                ArrayList<Tutoria> primeras100 = new ArrayList<>();

                for (int i = 0; i < n && i < tutorias.size(); i++) {
                    insertarTutoriaCSV(g, tutorias.get(i));

                    // Save first 100 objects
                    if (i < 100) {
                        // Create tutoria objects identical to inserted ones
                        primeras100.add(crearTutoriaObjeto(tutorias.get(i)));
                    }
                }

                // Now measure cancelar
                double total = 0;

                for (Tutoria t : primeras100) {
                    total += medirOperacion(() -> g.cancelarTutoria(t));
                }

                double avg = total / primeras100.size();
                writer.write(n + "," + avg + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Tutoria crearTutoriaObjeto(String[] t) {
        String idEst = t[0];
        String idTutor = t[1];
        String asignatura = t[2];
        String horario = t[3];
        int prioridad = Integer.parseInt(t[4]);

        return new Tutoria(idEst, idTutor, asignatura, horario, prioridad, LocalDate.now());
    }
}