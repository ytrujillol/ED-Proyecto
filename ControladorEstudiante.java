import modules.*;

// Interfaz para la lógica de la vista del estudiante.
// Se encarga de orquestar las opciones: solicitar tutoría,
// cancelar tutoría y ver historial, según el diagrama de flujo.
public interface ControladorEstudiante {

    /**
     * Flujo completo para solicitar una tutoría:
     * - Seleccionar asignatura.
     * - Buscar tutores y horarios disponibles.
     * - Elegir prioridad.
     * - Confirmar y registrar la tutoría.
     */
    void solicitarTutoria(String idTutor, String idEstudiante, String asignatura, String horario, int prioridad);

    /**
     * Flujo para cancelar una tutoría:
     * - Mostrar tutorías vigentes del estudiante.
     * - Seleccionar tutoría a cancelar.
     * - Confirmar cancelación.
     */
    void cancelarTutoria(String idEstudiante, Tutoria tutoria);

    /**
     * Flujo para consultar el historial de tutorías del estudiante:
     * - Mostrar tutorías realizadas y su información básica.
     */
    void verHistorial(String idEstudiante);


    /**
     * Flujo para dar por finalizada una tutoría.
     * - Se extraerá del montículo
     * - Se agrega al histórico de tutorías
     * - Se elimina de las tutorías pendientes del estudiante.
     */
    void finalizar(String idEstudiante, Tutoria tutoria);
}
