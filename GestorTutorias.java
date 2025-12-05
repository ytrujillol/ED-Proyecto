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
    private ListaEnlazada<Tutoria> historicoTutorias; // historial general o por estudiante
    private HashMap<String, Tutor[]> tutoresPorAsignatura; // clave: asignatura

    // Constructor. En una siguiente iteración se pueden recibir estas estructuras por parámetros.
    public GestorTutorias() {
        // TODO: inicializar estructuras o recibirlas por parámetros.

    }

    @Override
    public void solicitarTutoria(Tutor tutor, Estudiante estudiante) {

    }

    @Override
    public void cancelarTutoria(Estudiante estudiante, Tutoria  tutoria) {
        // TODO:
        // 1. Obtener la lista de tutorías vigentes del estudiante
        //    desde tutoriasPorEstudiante.
        // 2. Si la lista está vacía, mostrar "No hay tutorías agendadas"
        //    y volver al menú.
        //
        // 3. Mostrar las tutorías vigentes en pantalla.
        // 4. Permitir seleccionar una tutoría a cancelar.
        // 5. Mostrar mensaje de advertencia / confirmación.
        // 6. Si se confirma la cancelación:
        //    - Eliminar la tutoría de tutoriasPendientesPorTutor.
        //    - Eliminarla de tutoriasPorEstudiante.
        //    - (Opcional) registrar la cancelación en historicoTutorias si así se define.
        //    - Mostrar mensaje de confirmación.
        // 7. Volver al menú.
    }

    @Override
    public void verHistorial(Estudiante estudiante) {
        // TODO:
        // 1. Obtener el historial de tutorías del estudiante
        //    (desde historicoTutorias o una estructura similar).
        // 2. Si el historial está vacío, mostrar mensaje y volver al menú.
        // 3. Mostrar las tutorías realizadas (asignatura, tutor, fecha, etc.).
        // 4. Preguntar si desea regresar al menú principal y hacerlo.
    }

    // Métodos auxiliares (a definir en futuras iteraciones), por ejemplo:
    //
    // private String leerOpcionMenu() { ... }
    // private String leerAsignatura() { ... }
    // private int leerPrioridad() { ... }
    // private void mostrarMensaje(String mensaje) { ... }
    // etc.
}
