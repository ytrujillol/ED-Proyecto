import data_structures.*;
import modules.*;

// Implementación del controlador de la vista del estudiante.
// Orquesta las operaciones de solicitud, cancelación y consulta
// de historial de tutorías, según el flujo definido para el sistema.
public class GestorTutorias implements ControladorEstudiante {

    // Estructuras principales que usa el controlador.
    // Se asume que estas estructuras son provistas por otras partes del sistema.
    private HashMap<String, Estudiante> estudiantes; // clave: idEstudiante
    private HashMap<String, ListaEnlazada<Tutoria>> tutoriasPorEstudiante; // clave: idEstudiante
    private HashMap<String, MaxHeap<Tutoria>> tutoriasPendientesPorTutor; // clave: idTutor
    private HashMap<String, ListaEnlazada<Tutoria>> historicoTutorias; // clave: idEstudiante historial general o por estudiante
    private HashMap<String, Tutor[]> tutoresPorAsignatura; // clave: asignatura

    // Constructor. En una siguiente iteración se pueden recibir estas estructuras por parámetros.
    public GestorTutorias(
            HashMap<String, Estudiante> estudiantes,
            HashMap<String, ListaEnlazada<Tutoria>> tutoriasPorEstudiante,
            HashMap<String, MaxHeap<Tutoria>> tutoriasPendientesPorTutor,
            HashMap<String, ListaEnlazada<Tutoria>> historicoTutorias,
            HashMap<String, Tutor[]> tutoresPorAsignatura
            ) {
        // TODO: inicializar estructuras o recibirlas por parámetros.
        /**
         * Inicializacion de estructuras previamente definidas
         * dadas a través de los parámetros
         */

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
        tutoriasPorEstudiante.get(idEstudiante).insert(newtutoria);

        // Se agrega la tutoría al montículo de tutorias del tutor, segun prioridad
        tutoriasPendientesPorTutor.get(idTutor).insert(newtutoria);
    }

    @Override
    public void cancelarTutoria(String idEstudiante, Tutoria tutoria) {


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
    public void finalizar(String idEstudiante, Tutoria tutoria) {
        
    }
}
