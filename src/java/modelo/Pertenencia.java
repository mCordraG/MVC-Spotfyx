package modelo;
// Generated 08-may-2015 6:32:48 by Hibernate Tools 4.3.1



/**
 * Pertenencia generated by hbm2java
 */
public class Pertenencia  implements java.io.Serializable {


     private int idlista;
     private int iduser;

    public Pertenencia() {
    }

    public Pertenencia(int idlista, int iduser) {
       this.idlista = idlista;
       this.iduser = iduser;
    }
   
    public int getIdlista() {
        return this.idlista;
    }
    
    public void setIdlista(int idlista) {
        this.idlista = idlista;
    }
    public int getIduser() {
        return this.iduser;
    }
    
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }




}


