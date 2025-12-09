import data_structures.*;
import modules.*;
import java.time.LocalDate;

// Implementación del controlador de la vista del estudiante.
// Orquesta las operaciones de solicitud, cancelación y consulta
// de historial de tutorías, según el flujo definido para el sistema.
public class GestorTutorias implements ControladorEstudiante {

    // Estructuras principales que usa el controlador.
    // Se asume que estas estructuras son provistas por otras partes del sistema.
    private final HashMap<String, Estudiante> estudiantes; // clave: idEstudiante
    private final HashMap<String, ListaEnlazada<Tutoria>> tutoriasPorEstudiante; // clave: idEstudiante
    private final HashMap<String, ArrayMaxHeap> tutoriasPendientesPorTutor; // clave: idTutor
    private final HashMap<String, ListaEnlazada<Tutoria>> historicoTutorias; // clave: idEstudiante historial general o por estudiante
    private final HashMap<String, Tutor[]> tutoresPorAsignatura; // clave: asignatura

    // Constructor. En una siguiente iteración se pueden recibir estas estructuras por parámetros.
    public GestorTutorias(
            HashMap<String, Estudiante> estudiantes,
            HashMap<String, ListaEnlazada<Tutoria>> tutoriasPorEstudiante,
            HashMap<String, ArrayMaxHeap> tutoriasPendientesPorTutor,
            HashMap<String, ListaEnlazada<Tutoria>> historicoTutorias,
            HashMap<String, Tutor[]> tutoresPorAsignatura
            ) {

        this.estudiantes = estudiantes;
        this.tutoriasPorEstudiante = tutoriasPorEstudiante;
        this.tutoriasPendientesPorTutor = tutoriasPendientesPorTutor;
        this.historicoTutorias = historicoTutorias;
        this.tutoresPorAsignatura = tutoresPorAsignatura;
    }

    @Override
    public void solicitarTutoria(String idTutor, String idEstudiante, String asignatura, String horario, int prioridad) {

        // Comprueba que exista el estudiante y el tutor.
        if (!estudiantes.find(idEstudiante) || !tutoresPorAsignatura.find(asignatura)) {System.out.println("No Agregada"); return ;}
        
        // Se crea la nueva tutoria
        Tutoria newtutoria = new Tutoria(idEstudiante, idTutor, asignatura, horario, prioridad, LocalDate.now());

        // Se añade la tutoría a la lista de tutorías asignada al estudiante.
        // Se comprueba si ya existe la clave del estudiante en las tutorías
        // Si no es así, se crea la nueva clave con una nueva liusta.
        ListaEnlazada<Tutoria> listaEstudiante = tutoriasPorEstudiante.get(idEstudiante);
        if (listaEstudiante == null) {
            listaEstudiante = new ListaEnlazada<>();
            tutoriasPorEstudiante.put(idEstudiante, listaEstudiante);
        }
        listaEstudiante.insert(newtutoria);
        // Se agrega la tutoría al montículo de tutorias del tutor, segun prioridad
        // De igual manera, se crea nuevo el monticulo si no está
        // Se añade la tutoria al monticulo ya existente.
        ArrayMaxHeap heapTutor = tutoriasPendientesPorTutor.get(idTutor);
        if (heapTutor == null) {
            heapTutor = new ArrayMaxHeap();
            tutoriasPendientesPorTutor.put(idTutor, heapTutor);
        }
        heapTutor.insert(newtutoria);
    }

    @Override
    public void cancelarTutoria(Tutoria tutoria) {
        // Obtenemos la información de la tutoría
        String idEstudiante =  tutoria.getIdEstudiante();
        String idTutor = tutoria.getIdTutor();

        // Comprobamos que la clave el estudiante y el tutor existan; y que no estén vacías la lista y el heap
        if (!tutoriasPorEstudiante.find(idEstudiante) || tutoriasPorEstudiante.get(idEstudiante).isEmpty()) return;
        if (!tutoriasPendientesPorTutor.find(idTutor) || tutoriasPendientesPorTutor.get(idTutor).isEmpty()) return;

        // Eliminamos la tutoría de la lista de tutorias del estudiante
        tutoriasPorEstudiante.get(idEstudiante).delete(tutoria);

        // Eliminamos la tutoria del monticulo de tutorias del tutor
        tutoriasPendientesPorTutor.get(idTutor).remove(tutoria);
    }

    @Override
    public ListaEnlazada<Tutoria> verHistorial(String idEstudiante) {
        // Se comprueba si tenemos la clave o no.
        // Se comprueba si está vacía la lista de tutorias del estudiante.
        if (!historicoTutorias.find(idEstudiante) || historicoTutorias.get(idEstudiante).isEmpty()) return null;

        // se retorna la lista de tutorías pasadas.
        ListaEnlazada<Tutoria> tutorias;

        // Se busca y guarda la lista de tutorías completadas del estudiante.
        tutorias = historicoTutorias.get(idEstudiante);

        // se retorna la lista obtenida; será manejada por la interfaz a la hora de mostrar.
        return tutorias;
    }

    @Override
    public void finalizar(String idTutor) {
        // Eliminamos la tutoría del montículo de tutorías.
        if (!tutoriasPendientesPorTutor.find(idTutor) || tutoriasPendientesPorTutor.get(idTutor).isEmpty()) return;

        Tutoria tutoria = tutoriasPendientesPorTutor.get(idTutor).extractMax();

        // Obtenemos informacion de la tutoria: idEstudiante e idTutor
        String idEstudiante = tutoria.getIdEstudiante();

        // Eliminamos la tutoría en las tutorias pendientes del estudiante
        if (tutoriasPorEstudiante.find(idEstudiante)) tutoriasPorEstudiante.get(idEstudiante).delete(tutoria);
        // Se añade la tutoría al histórico de tutorías.
        ListaEnlazada<Tutoria> historial = historicoTutorias.get(idEstudiante);
        if (historial == null) {
            historial = new ListaEnlazada<>();
            historicoTutorias.put(idEstudiante, historial);
        }
        historial.insert(tutoria);
    }

    public void finalizarEspecifica(Tutoria t){
        // Obtenemos la información de la tutoría
        String idEstudiante =  tutoria.getIdEstudiante();
        String idTutor = tutoria.getIdTutor();
        // Comprobamos que la clave el estudiante y el tutor existan; y que no estén vacías la lista y el heap
        if (!tutoriasPorEstudiante.find(idEstudiante) || tutoriasPorEstudiante.get(idEstudiante).isEmpty()) return;
        if (!tutoriasPendientesPorTutor.find(idTutor) || tutoriasPendientesPorTutor.get(idTutor).isEmpty()) return;

        // Eliminamos la tutoría de la lista de tutorias del estudiante
        tutoriasPorEstudiante.get(idEstudiante).delete(tutoria);
        // Eliminamos la tutoria del monticulo de tutorias del tutor
        tutoriasPendientesPorTutor.get(idTutor).remove(tutoria);

        //Marcamos la tutoría como finalizada
        t.setEstado("Finalizada");

        // Se añade la tutoría a la lista de tutorías historicas del estudiante.
        // Se comprueba si ya existe la clave del estudiante en las tutorías
        // Si no es así, se crea la nueva clave con una nueva liusta.
        ListaEnlazada<Tutoria> listaHistorico = historicoTutorias.get(idEstudiante);
        if (listaHistorico == null) {
            listaHistorico = new ListaEnlazada<>();
            historicoTutorias.put(idEstudiante, listaHistorico);
        }
        listaHistorico.insert(t);
    }
}
