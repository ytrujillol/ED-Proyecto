import data_structures.*;
import modules.*;

// Implementación del controlador de la vista del estudiante.
// Orquesta las operaciones de solicitud, cancelación y consulta
// de historial de tutorías, según el flujo definido para el sistema.
public class GestorTutorias implements ControladorEstudiante {

    // Estructuras principales que usa el controlador.
    // Se asume que estas estructuras son provistas por otras partes del sistema.
    private final HashMap<String, Estudiante> estudiantes; // clave: idEstudiante
    private final HashMap<String, ListaEnlazada<Tutoria>> tutoriasPorEstudiante; // clave: idEstudiante
    private final HashMap<String, MaxHeap<Tutoria>> tutoriasPendientesPorTutor; // clave: idTutor
    private final HashMap<String, ListaEnlazada<Tutoria>> historicoTutorias; // clave: idEstudiante historial general o por estudiante
    private final HashMap<String, Tutor[]> tutoresPorAsignatura; // clave: asignatura

    // Constructor. En una siguiente iteración se pueden recibir estas estructuras por parámetros.
    public GestorTutorias(
            HashMap<String, Estudiante> estudiantes,
            HashMap<String, ListaEnlazada<Tutoria>> tutoriasPorEstudiante,
            HashMap<String, MaxHeap<Tutoria>> tutoriasPendientesPorTutor,
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

        // Se crea la nueva tutoria
        Tutoria newtutoria = new Tutoria(idEstudiante, idTutor, asignatura, horario, prioridad);

        // Se añade la tutoría a la lista de tutorías asignada al estudiante.
        // Se comprueba si ya existe la clave del estudiante en las tutorías
        // Si no es así, se crea la nueva clave con una nueva lista.
        if (!tutoriasPorEstudiante.find(idEstudiante)) {
            tutoriasPorEstudiante.put(idEstudiante, new ListaEnlazada<>());
        }
        tutoriasPorEstudiante.get(idEstudiante).insert(newtutoria);

        // Se agrega la tutoría al montículo de tutorias del tutor, segun prioridad
        // De igual manera, se crea nuevo el monticulo si no está
        // Se añade la tutoria al monticulo ya existente.
        if (!tutoriasPendientesPorTutor.find(idTutor)) {
            tutoriasPendientesPorTutor.put(idTutor, new ArrayMaxHeap<>());
        }
        tutoriasPendientesPorTutor.get(idTutor).insert(newtutoria);
    }

    @Override
    public void cancelarTutoria(Tutoria tutoria) {
        // Obtenemos la información de la tutoría
        String idEstudiante =  tutoria.getIdEstudiante();

        // Eliminamos la tutoría de la lista de tutorias del estudiante
        if (tutoriasPorEstudiante.find(idEstudiante)) tutoriasPorEstudiante.get(idEstudiante).delete(tutoria);

        // Eliminamos la tutoria del monticulo de tutorias del tutor

    }

    @Override
    public ListaEnlazada<Tutoria> verHistorial(String idEstudiante) {
        // Se comprueba si tenemos la clave o no.
        if (!historicoTutorias.find(idEstudiante)) return null;

        // se retorna la lista de tutorías pasadas.
        ListaEnlazada<Tutoria> tutorias;

        // Se busca y guarda la lista de tutorías completadas del estudiante
        tutorias = historicoTutorias.get(idEstudiante);

        // se retorna la lista obtenida; será manejada por la interfaz a la hora de mostrar.
        return tutorias;
    }

    @Override
    public void finalizar(Tutoria tutoria) {
        // Obtenemos informacion de la tutoria: idEstudiante e idTutor
        String idEstudiante = tutoria.getIdEstudiante();
        String idTutor = tutoria.getIdTutor();

        // Eliminamos la tutoría del montículo de tutorías.
        if (tutoriasPendientesPorTutor.find(idTutor)) tutoriasPendientesPorTutor.get(idTutor).extractMax();

        // Eliminamos la tutoría en las tutorias pendientes del estudiante
        if (tutoriasPorEstudiante.find(idEstudiante)) tutoriasPorEstudiante.get(idEstudiante).delete(tutoria);

        // Se añade la tutoría al histórico de tutorías.
        if (historicoTutorias.find(idEstudiante)) historicoTutorias.get(idEstudiante).insert(tutoria);
    }
}
