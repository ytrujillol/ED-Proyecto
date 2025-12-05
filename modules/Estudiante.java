package modules;

class Estudiante {
    private String documento;
    private String nombre;
    private String correoInstitucional;
    private int semestre;
    
    public Estudiante(String documento, String nombre, String correoInstitucional, int semestre){
        this.documento = documento;
        this.nombre = nombre;
        this.correoInstitucional = correoInstitucional;
        this.semestre = semestre;
    }
    
    //---------------------Getters------------------
    public String getNombre(){
        return nombre;
    }
    public String getDocumento(){
        return documento;
    }
    public String getCorreoInstitucional(){
        return correoInstitucional;
    }
    public int getSemestre(){
        return semestre;
    }
    //------------------Setters----------------------
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setSemestre(int semestre){
        this.semestre = semestre;
    }
    //Metodos de validacion estudiante---------------
    
    
    
    
    
}