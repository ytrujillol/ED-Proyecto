// Interfaz para la lógica de la vista del estudiante.
// Se encarga de orquestar las opciones: solicitar tutoría,
// cancelar tutoría y ver historial, según el diagrama de flujo.
public interface ControladorEstudiante {

    /**
     * Punto de entrada para la vista del estudiante.
     * Muestra el menú principal del estudiante y
     * dirige a la opción seleccionada.
     */
    void mostrarMenuEstudiante();

    /**
     * Flujo completo para solicitar una tutoría:
     * - Seleccionar asignatura.
     * - Buscar tutores y horarios disponibles.
     * - Elegir prioridad.
     * - Confirmar y registrar la tutoría.
     */
    void solicitarTutoria();

    /**
     * Flujo para cancelar una tutoría:
     * - Mostrar tutorías vigentes del estudiante.
     * - Seleccionar tutoría a cancelar.
     * - Confirmar cancelación.
     */
    void cancelarTutoria();

    /**
     * Flujo para consultar el historial de tutorías del estudiante:
     * - Mostrar tutorías realizadas y su información básica.
     */
    void verHistorial();
}
