import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Instancia de 24 estudiantes         (documento,nombre,correo,semestre)
        Estudiante e1 = new Estudiante  ("1001022001", "Carlos Peréz","cperez@unal.edu.co", 2);
        Estudiante e2 = new Estudiante  ("1001022002", "Alejandra Gonzalez", "agonzalez@unal.edu.co", 7);
        Estudiante e3 = new Estudiante  ("1001022003", "John Carreño", "jcarreno@unal.edu.co", 5);
        Estudiante e4 = new Estudiante  ("1001022004", "Samuel Flores", "sflores@unal.edu.co", 1);
        Estudiante e5 = new Estudiante  ("1001022005", "Allison Cortés", "acortes@unal.edu.co", 3);
        Estudiante e6 = new Estudiante  ("1001022006", "Fernando Martínez", "fmartinez@unal.edu.co", 2);
        Estudiante e7 = new Estudiante  ("1001022007", "Santiago Monroy", "smonroy@unal.edu.co", 4);
        Estudiante e8 = new Estudiante  ("1001022008", "Paola Guzman", "pguzman@unal.edu.co", 8);
        Estudiante e9 = new Estudiante  ("1001022009", "David Contreras", "dcontreras@unal.edu.co", 6);
        Estudiante e10 = new Estudiante ("1001022010", "Sara Villamil", "svillamil@unal.edu.co", 2);
        Estudiante e11 = new Estudiante ("1001022011", "Jose Castro", "jcastro@unal.edu.co", 1);
        Estudiante e12 = new Estudiante ("1001022012", "Daniela Forero", "dforero@unal.edu.co", 3);
        Estudiante e13 = new Estudiante ("1001022013", "Marta Quiroga", "mquiroga@unal.edu.co", 4);
        Estudiante e14 = new Estudiante ("1001022014", "Felipe Gamboa", "fgamboa@unal.edu.co", 9);
        Estudiante e15 = new Estudiante ("1001022015", "Luisa Castillo", "lcastillo@unal.edu.co", 2);
        Estudiante e16 = new Estudiante ("1001022016", "Sofia Mendez", "smendez@unal.edu.co", 4);
        Estudiante e17 = new Estudiante ("1001022017", "Sebastian Jimenez", "sjimenez@unal.edu.co", 5);
        Estudiante e18 = new Estudiante ("1001022018", "Sofia Cortés", "scortes@unal.edu.co", 10);
        Estudiante e19 = new Estudiante ("1001022019", "Dylan Gutierrez", "dgutierrez@unal.edu.co", 1);
        Estudiante e20 = new Estudiante ("1001022020", "Alejandro Campos", "acampos@unal.edu.co", 1);
        Estudiante e21 = new Estudiante ("1001022021", "Martin Casas", "mcasas@unal.edu.co", 3);
        Estudiante e22 = new Estudiante ("1001022022", "Luna Sierra", "lsierra@unal.edu.co", 4);
        Estudiante e23 = new Estudiante ("1001022023", "Juliana Lopez", "jlopez@unal.edu.co", 7);
        Estudiante e24 = new Estudiante ("1001022024", "Cesar Rivera", "crivera@unal.edu.co", 6);
                                              
        //Instancia de 6 tutores       (documento,nombre,correo) 
        Tutor tut1 = new Tutor("1001022025", "Omar Rincon", "orincon@unal.edu.co"); //Calculo Diferencial y Álgebra Lineal
        Tutor tut2 = new Tutor("1001022026", "Isabela Rodriguez", "irodriguez@unal.edu.co"); //Cálculo Diferencial y Cálculo Integral
        Tutor tut3 = new Tutor("1001022027", "Liseth Ramirez", "lramirez@unal.edu.co");//Lectoescritura e Idiomas
        Tutor tut4 = new Tutor("1001022028", "Daniel Zamudio", "dzamudio@unal.edu.co");//Programación Básica y POO
        Tutor tut5 = new Tutor("1001022029", "Jeison Rojas", "jrojas@unal.edu.co");//Circuitos eléctricos y Electrónica Digital
        Tutor tut6 = new Tutor("1001022030", "Paula Gomez", "pgomez@unal.edu.co");//Fisica I y Fisica II
        
        //Instancia de 10 tutorías (idEstudiante, idTutor, asignatura, horario, prioridad, fecha)
        Tutoria t1 = new Tutoria("1001022001", "1001022025", "Cálculo Diferencial", "11:00 am - 1:00 pm", 3, LocalDate.of(2025,11,23));
        Tutoria t2 = new Tutoria("1001022002", "1001022026", "Cálculo Diferencial", "9:00 am - 11:00 am", 4, LocalDate.of(2025,9,3));
        Tutoria t3 = new Tutoria("1001022003", "1001022027", "Idiomas", "2:00 pm - 4:00 pm", 1, LocalDate.of(2025,10,11));
        Tutoria t4 = new Tutoria("1001022004", "1001022028", "Programación Orientada a Objetos", "11:00 am - 1:00 pm", 3, LocalDate.of(2025,12,4));
        Tutoria t5 = new Tutoria("1001022005", "1001022029", "Electrónica Digital", "7:00 am - 9:00 am", 2, LocalDate.of(2025,11,29));
        Tutoria t6 = new Tutoria("1001022006", "1001022030", "Física I", "2:00 pm - 4:00 pm", 5, LocalDate.of(2025,10,31));
        Tutoria t7 = new Tutoria("1001022007", "1001022025", "Cálculo I", "9:00 am - 11:00 am", 2, LocalDate.of(2025,12,10));
        Tutoria t8 = new Tutoria("1001022008", "1001022025", "Cálculo I", "9:00 am - 11:00 am", 3, LocalDate.of(2025,11,7));
        Tutoria t9 = new Tutoria("1001022009", "1001022026", "Cálculo I", "7:00 am - 9:00 am", 1, LocalDate.of(2025,11,13));
        Tutoria t10 = new Tutoria("1001022010", "1001022027", "Cálculo I", "11:00 am - 1:00 pm", 1, LocalDate.of(2025,10,24));
        
    }
  
}
