package modelo;
// Generated 08-may-2015 6:32:48 by Hibernate Tools 4.3.1



/**
 * Lista generated by hbm2java
 */
public class Lista  implements java.io.Serializable {


     private int idlista;
     private String nombre;
     private String usuario;

    public Lista() {
    }

    public Lista(int idlista, String nombre, String usuario) {
       this.idlista = idlista;
       this.nombre = nombre;
       this.usuario = usuario;
    }
   
    public int getIdlista() {
        return this.idlista;
    }
    
    public void setIdlista(int idlista) {
        this.idlista = idlista;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }




}

