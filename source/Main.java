import java.time.LocalDate;
import data_structures.*;
import modules.*;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        Estudiante e1 = new Estudiante("1001022001", "Carlos Peréz","cperez@unal.edu.co", 2);
        Estudiante e2 = new Estudiante("1001022002", "Alejandra Gonzalez", "agonzalez@unal.edu.co", 7);
        Estudiante e3 = new Estudiante("1001022003", "John Carreño", "jcarreno@unal.edu.co", 5);
        Estudiante e4 = new Estudiante("1001022004", "Samuel Flores", "sflores@unal.edu.co", 1);
        Estudiante e5 = new Estudiante("1001022005", "Allison Cortés", "acortes@unal.edu.co", 3);
        Estudiante e6 = new Estudiante("1001022006", "Fernando Martínez", "fmartinez@unal.edu.co", 2);
        Estudiante e7 = new Estudiante("1001022007", "Santiago Monroy", "smonroy@unal.edu.co", 4);
        Estudiante e8 = new Estudiante("1001022008", "Paola Guzman", "pguzman@unal.edu.co", 8);
        Estudiante e9 = new Estudiante("1001022009", "David Contreras", "dcontreras@unal.edu.co", 6);
        Estudiante e10 = new Estudiante("1001022010", "Sara Villamil", "svillamil@unal.edu.co", 2);
        Estudiante e11 = new Estudiante("1001022011", "Jose Castro", "jcastro@unal.edu.co", 1);
        Estudiante e12 = new Estudiante("1001022012", "Daniela Forero", "dforero@unal.edu.co", 3);
        Estudiante e13 = new Estudiante("1001022013", "Marta Quiroga", "mquiroga@unal.edu.co", 4);
        Estudiante e14 = new Estudiante("1001022014", "Felipe Gamboa", "fgamboa@unal.edu.co", 9);
        Estudiante e15 = new Estudiante("1001022015", "Luisa Castillo", "lcastillo@unal.edu.co", 2);
        Estudiante e16 = new Estudiante("1001022016", "Sofia Mendez", "smendez@unal.edu.co", 4);
        Estudiante e17 = new Estudiante("1001022017", "Sebastian Jimenez", "sjimenez@unal.edu.co", 5);
        Estudiante e18 = new Estudiante("1001022018", "Sofia Cortés", "scortes@unal.edu.co", 10);
        Estudiante e19 = new Estudiante("1001022019", "Dylan Gutierrez", "dgutierrez@unal.edu.co", 1);
        Estudiante e20 = new Estudiante("1001022020", "Alejandro Campos", "acampos@unal.edu.co", 1);
        Estudiante e21 = new Estudiante("1001022021", "Martin Casas", "mcasas@unal.edu.co", 3);
        Estudiante e22 = new Estudiante("1001022022", "Luna Sierra", "lsierra@unal.edu.co", 4);
        Estudiante e23 = new Estudiante("1001022023", "Juliana Lopez", "jlopez@unal.edu.co", 7);
        Estudiante e24 = new Estudiante("1001022024", "Cesar Rivera", "crivera@unal.edu.co", 6);

        Tutor tut1 = new Tutor("1001022025", "Omar Rincon", "orincon@unal.edu.co");
        tut1.agregarAsignatura("Cálculo Diferencial");
        tut1.agregarAsignatura("Álgebra Lineal");

        Tutor tut2 = new Tutor("1001022026", "Isabela Rodriguez", "irodriguez@unal.edu.co");
        tut2.agregarAsignatura("Cálculo Diferencial");
        tut2.agregarAsignatura("Álgebra Lineal");

        Tutor tut3 = new Tutor("1001022027", "Liseth Ramirez", "lramirez@unal.edu.co");
        tut3.agregarAsignatura("Programación Básica");
        tut3.agregarAsignatura("Programación Avanzada");

        Tutor tut4 = new Tutor("1001022028", "Daniel Zamudio", "dzamudio@unal.edu.co");
        tut4.agregarAsignatura("Programación Básica");
        tut4.agregarAsignatura("Programación Avanzada");

        Tutor tut5 = new Tutor("1001022029", "Jeison Rojas", "jrojas@unal.edu.co");
        tut5.agregarAsignatura("Física I");
        tut5.agregarAsignatura("Física II");

        Tutor tut6 = new Tutor("1001022030", "Paula Gomez", "pgomez@unal.edu.co");
        tut6.agregarAsignatura("Física I");
        tut6.agregarAsignatura("Física II");

        Tutoria t1 = new Tutoria("1001022001", "1001022025", "Cálculo Diferencial", "11:00 am - 1:00 pm", 3, LocalDate.of(2024,11,23));
        t1.setEstado("Finalizada");
        Tutoria t2 = new Tutoria("1001022002", "1001022026", "Cálculo Diferencial", "9:00 am - 11:00 am", 4, LocalDate.of(2025,9,3));
        t2.setEstado("Activa");
        Tutoria t3 = new Tutoria("1001022003", "1001022027", "Programación Básica", "2:00 pm - 4:00 pm", 1, LocalDate.of(2024,10,11));
        t3.setEstado("Finalizada");
        Tutoria t4 = new Tutoria("1001022004", "1001022028", "Programación Avanzada", "11:00 am - 1:00 pm", 3, LocalDate.of(2025,12,4));
        t4.setEstado("Activa");
        Tutoria t5 = new Tutoria("1001022005", "1001022029", "Física I", "7:00 am - 9:00 am", 2, LocalDate.of(2025,11,29));
        t5.setEstado("Activa");
        Tutoria t6 = new Tutoria("1001022006", "1001022030", "Física II", "2:00 pm - 4:00 pm", 5, LocalDate.of(2025,10,31));
        t6.setEstado("Activa");
        Tutoria t7 = new Tutoria("1001022007", "1001022025", "Álgebra Lineal", "9:00 am - 11:00 am", 2, LocalDate.of(2025,12,10));
        t7.setEstado("Activa");
        Tutoria t8 = new Tutoria("1001022008", "1001022025", "Álgebra Lineal", "9:00 am - 11:00 am", 3, LocalDate.of(2025,11,7));
        t8.setEstado("Activa");
        Tutoria t9 = new Tutoria("1001022009", "1001022026", "Cálculo Diferencial", "7:00 am - 9:00 am", 1, LocalDate.of(2025,11,13));
        t9.setEstado("Activa");
        Tutoria t10 = new Tutoria("1001022010", "1001022027", "Programación Básica", "11:00 am - 1:00 pm", 1, LocalDate.of(2025,10,24));
        t10.setEstado("Activa");

        Tutor[] arrayTutores = {tut1, tut2, tut3, tut4, tut5, tut6};
        Estudiante[] arrayEstudiantes = {e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,e23,e24};
        Tutoria[] arrayTutorias = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10};

        HashMap<String, Estudiante> estudiantesPorDocumento = new HashMap<>();
        for (Estudiante e: arrayEstudiantes){
            estudiantesPorDocumento.put(e.getDocumento(), e);
        }

        HashMap<String, Tutor[]> tutoresPorAsignatura = new HashMap<>();
        tutoresPorAsignatura.put("Cálculo Diferencial", new Tutor[]{tut1, tut2});
        tutoresPorAsignatura.put("Álgebra Lineal", new Tutor[]{tut1, tut2});
        tutoresPorAsignatura.put("Programación Básica", new Tutor[]{tut3, tut4});
        tutoresPorAsignatura.put("Programación Avanzada", new Tutor[]{tut3, tut4});
        tutoresPorAsignatura.put("Física I", new Tutor[]{tut5, tut6});
        tutoresPorAsignatura.put("Física II", new Tutor[]{tut5, tut6});

        HashMap<String, ListaEnlazada<Tutoria>> tutoriasEstudiante = new HashMap<>();
        for (Tutoria t : arrayTutorias){
            String id = t.getIdEstudiante();
            if ("Activa".equals(t.getEstado())){
                if(!tutoriasEstudiante.find(id)){
                    tutoriasEstudiante.put(id, new ListaEnlazada<>());
                }
                tutoriasEstudiante.get(id).insert(t);
            }
        }

        HashMap<String, ListaEnlazada<Tutoria>> historicoEstudiante = new HashMap<>();
        for (Tutoria t : arrayTutorias){
            String id = t.getIdEstudiante();
            if ("Finalizada".equals(t.getEstado())){
                if(!historicoEstudiante.find(id)){
                    historicoEstudiante.put(id, new ListaEnlazada<>());
                }
                historicoEstudiante.get(id).insert(t);
            }
        }

        HashMap<String, ArrayMaxHeap> tutoriasPendientes = new HashMap<>();
        for (Tutoria t: arrayTutorias){
            if ("Activa".equals(t.getEstado())){
                if(!tutoriasPendientes.find(t.getIdTutor())){
                    tutoriasPendientes.put(t.getIdTutor(),new ArrayMaxHeap());
                }
                tutoriasPendientes.get(t.getIdTutor()).insert(t);
            }
        }

        GestorTutorias gestor = new GestorTutorias(
                estudiantesPorDocumento,
                tutoriasEstudiante,
                tutoriasPendientes,
                historicoEstudiante,
                tutoresPorAsignatura
        );

        String idEstudianteActual = "1001022001";

        SwingUtilities.invokeLater(() -> {
            Interfaz ventana = new Interfaz(
                    gestor,
                    idEstudianteActual,
                    tutoriasEstudiante,
                    tutoresPorAsignatura
            );
            ventana.setVisible(true);
        });
    }
}