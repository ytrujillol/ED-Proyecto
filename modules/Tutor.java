package modules;

import jsource.ListaEnlazada;
class Tutor{
  //atributos
  private String documento;
  private String nombre;
  private String correoInstitucional;
  private ListaEnlazada<String> horariosDisponibles;
  private ListaEnlazada<String> asignaturasQueDicta;
  public Tutor(String documento, String nombre, String correoInstitucional){
    this.documento=documento;
    this.nombre=nombre;
    this.correoInstitucional=correoInstitucional;
    this.horariosDisponibles=new ListaEnlazada<>();
    this.asignaturasQueDicta=new ListaEnlazada<>();
  }
  //setters y getters
  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreoInstitucional() {
    return correoInstitucional;
  }

  public void setCorreoInstitucional(String correoInstitucional) {
    this.correoInstitucional = correoInstitucional;
  }
  public ListaEnlazada<String> getHorariosDisponibles() {
    return horariosDisponibles;
  }

  public ListaEnlazada<String> getAsignaturasQueDicta() {
    return asignaturasQueDicta;
  }
//agregar y eliminar en las listas
  public void agregarHorario(String horario){
    horariosDisponibles.insert(horario);
  }
  public void agregarAsignatura(String asignatura){
    asignaturasQueDicta.insert(asignatura);
  }
  public void eliminarHorario(String horario){
    int index=horariosDisponibles.find(horario);
    if(index==-1) return;
    horariosDisponibles.remove(index);
  }
  public void eliminarAsignatura(String asignatura){
    int index =asignaturasQueDicta.find(asignatura);
     if(index==-1) return;
    asignaturasQueDicta.remove(index);
  }
  
}
