/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import modelo.Cancion;
import modelo.Lista;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos
 */
public class CancionDAO {
   
    public boolean ingresarCancion(Cancion song) {  //Este método recibe el pojo preparado
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = NewHibernateUtil.getSessionFactory(); //obtener acceso  a la factoría de  sesiones
            sesion = sf.openSession(); // iniciar la sesión
            tx = sesion.beginTransaction(); //iniciar una transacción
            sesion.save(song); //para guardar la transacción
            tx.commit();//confinar los cambios que se hacen en la base de datos
            sesion.close(); //para cerrar la sesión 
            return true;
        } catch (Exception ex) {
            tx.rollback(); //volver un paso atrás
            throw new RuntimeException("No se pudo guardar la Cancion");
        }
    }

    public Cancion consultarCancion(String song) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();//obtener acceso  a la factorÃ­a de  sesiones 
        Session sesion = sf.openSession();// iniciar la sesiÃ³n
        Cancion c = (Cancion) sesion.get(Cancion.class, song);/*instanciamos p, el metodo sesion.get           
         obtiene un poducto de la tabla Producto y el campo que corresponde a su clave primaria que es codigo
         ,  debemos fozar a que el objeto obtenido sea de tipo Producto.*/

        sesion.close();
        if (c != null) {
            return c;
        } else {
            return null;
        }
    }

    public List<Cancion> verCanciones() {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();//obtener acceso  a la factorÃ­a de  sesiones
        Session sesion = sf.openSession();// iniciar la sesiÃ³n
        Query query = sesion.createQuery("from Cancion");//definimos una query y una consulta, esta consulta es en base al pojo por eso con mayÃºscula, luego hibÃ©rnate mapea a la tabla
        List<Cancion> song = query.list();//en  una lista se rescata los objetos por medio de objeto c/u de las tuplas. Cada una de los tuplas se guarda como objeto en una lista
        sesion.close();
        return song;
    }
    
    public String[] verCancionesLista(String lista) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();//obtener acceso  a la factorÃ­a de  sesiones
        Session sesion = sf.openSession();// iniciar la sesiÃ³n
        ListaDAO ldao = new ListaDAO();
        Lista l = ldao.consultarLista(lista);
        int id = l.getIdlista();
        Query query = sesion.createQuery("from Lista WHERE idlista="+id);//definimos una query y una consulta, esta consulta es en base al pojo por eso con mayÃºscula, luego hibÃ©rnate mapea a la tabla
        List<Cancion> list = query.list();
        String[] nombres = null;
        int i =0;
        for(Cancion c : list){
            nombres[i] = c.getNombrecancion();
            i++;
        }//en  una lista se rescata los objetos por medio de objeto c/u de las tuplas. Cada una de los tuplas se guarda como objeto en una lista
        sesion.close();
        return nombres;
    }

    public boolean editarCancion(Cancion song) {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        boolean flag = true;
        try {
            sf = NewHibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Cancion cancion = (Cancion) sesion.get(Cancion.class, song.getIdcancion());
            if (cancion != null) {
                cancion.setNombrecancion(song.getNombrecancion());
                cancion.setIdlista(song.getIdlista());
                cancion.setUrl(song.getUrl());
            }
            sesion.update(song);
            tx.commit();
            sesion.close();
        } catch (Exception ex) {
            tx.rollback();
            flag = false;
            throw new RuntimeException("No se pudo guardar la edicion de la Cancion");
        }
        return flag;
    }

    public boolean eliminarCancion(Cancion song) {  //Este método recibe el pojo preparado
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = NewHibernateUtil.getSessionFactory(); //obtener acceso  a la factoría de  sesiones
            sesion = sf.openSession(); // iniciar la sesión
            tx = sesion.beginTransaction(); //iniciar una transacción
            sesion.delete(song); //para guardar la transacción
            tx.commit();//confinar los cambios que se hacen en la base de datos
            sesion.close(); //para cerrar la sesión 
            return true;
        } catch (Exception ex) {
            tx.rollback(); //volver un paso atrás
            throw new RuntimeException("No se pudo eliminar la Cancion");
        }
    }
}
