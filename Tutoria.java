import java.time.LocalDate;

class Tutoria() implements Comparable<Tutoria>{
    private int idTutoria = 0;
    
    private String asignatura, horario;
    private int idEstudiante, idTutor;
    private int prioridad;
    private String estado;
    private LocalDate fecha;
    
    public Tutoria(int idEstudiante, int idTutor, String asignatura, String horario, int prioridad, LocalDate fecha){
        this.idTutoria++; //La primera tutoría inicia con ID 1 y va aumentando
        this.idEstudiante = idEstudiante;
        this.idTutor = idTutor;
        this.asignatura = asignatura;
        this.horario = horario;
        this.prioridad = prioridad;
        this.fecha = fecha;
    }
    
    public int compareTo (Tutoria otra){ //Compara las tutorías por prioridad asignada
        return Integer.compare(this.prioridad, otra.prioridad);
    }
    
    //---------------getters---------------------------
    public String getAsignatura(){
        return asignatura;
    }
    public String getHorario(){
        return horario;
    }
    public String getEstado(){
        return estado;
    }
    public int getIdTutoria(){
        return idTutoria;
    }
    public int getIdEstudiante(){
        return idEstudiante;
    }
    public getIdTutor(){
        return idTutor;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    //-----------setters-------------------------------
    // public void setPrioridad(int prioridad){    Por implementar
    //      this.prioridad = prioridad;
    // }
    public void setEstado(String estado){
        this.estado = estado
    }
    
}