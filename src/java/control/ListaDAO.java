/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import modelo.Lista;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos
 */
public class ListaDAO {

    public boolean ingresarLista(Lista list) {  //Este método recibe el pojo preparado
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = NewHibernateUtil.getSessionFactory(); //obtener acceso  a la factoría de  sesiones
            sesion = sf.openSession(); // iniciar la sesión
            tx = sesion.beginTransaction(); //iniciar una transacción
            sesion.save(list); //para guardar la transacción
            tx.commit();//confinar los cambios que se hacen en la base de datos
            sesion.close(); //para cerrar la sesión 
            return true;
        } catch (Exception ex) {
            tx.rollback(); //volver un paso atrás
            throw new RuntimeException("No se pudo guardar la Lista");
        }
    }

    public Lista consultarLista(String list) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();//obtener acceso  a la factorÃ­a de  sesiones 
        Session sesion = sf.openSession();// iniciar la sesiÃ³n
        Lista l = (Lista) sesion.get(Lista.class, list);/*instanciamos p, el metodo sesion.get           
         obtiene un poducto de la tabla Producto y el campo que corresponde a su clave primaria que es codigo
         ,  debemos fozar a que el objeto obtenido sea de tipo Producto.*/

        sesion.close();
        if (l != null) {
            return l;
        } else {
            return null;
        }
    }

    public List<Lista> verListas() {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();//obtener acceso  a la factorÃ­a de  sesiones
        Session sesion = sf.openSession();// iniciar la sesiÃ³n
        Query query = sesion.createQuery("from Lista");//definimos una query y una consulta, esta consulta es en base al pojo por eso con mayÃºscula, luego hibÃ©rnate mapea a la tabla
        List<Lista> lista = query.list();//en  una lista se rescata los objetos por medio de objeto c/u de las tuplas. Cada una de los tuplas se guarda como objeto en una lista
        sesion.close();
        return lista;
    }

    public String[] verListasUsuario(String nameus) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();//obtener acceso  a la factorÃ­a de  sesiones
        Session sesion = sf.openSession();// iniciar la sesiÃ³n
        Query query = sesion.createQuery("from Lista");//definimos una query y una consulta, esta consulta es en base al pojo por eso con mayÃºscula, luego hibÃ©rnate mapea a la tabla
        List<Lista> lista = query.list();
        int j = 0;
        String[] nombres = null;
        for (int i = 0; i < lista.size(); i++) {
            Lista l = lista.get(i);
            if (l.getNombre() == nameus) {
                nombres[j] = l.getNombre();
                j++;
            }
        }
        //en  una lista se rescata los objetos por medio de objeto c/u de las tuplas. Cada una de los tuplas se guarda como objeto en una lista
        sesion.close();
        if (nombres == null) {
            return null;
        } else {
            return nombres;
        }
    }

    public boolean editarLista(Lista list) {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        boolean flag = true;
        try {
            sf = NewHibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Lista lista = (Lista) sesion.get(Lista.class, list.getIdlista());
            if (lista != null) {
                lista.setUsuario(list.getUsuario());
                lista.setNombre(list.getNombre());
            }
            sesion.update(list);
            tx.commit();
            sesion.close();
        } catch (Exception ex) {
            tx.rollback();
            flag = false;
            throw new RuntimeException("No se pudo guardar la edicion de la Lista");
        }
        return flag;
    }

    public boolean eliminarLista(Lista list) {  //Este método recibe el pojo preparado
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = NewHibernateUtil.getSessionFactory(); //obtener acceso  a la factoría de  sesiones
            sesion = sf.openSession(); // iniciar la sesión
            tx = sesion.beginTransaction(); //iniciar una transacción
            sesion.delete(list); //para guardar la transacción
            tx.commit();//confinar los cambios que se hacen en la base de datos
            sesion.close(); //para cerrar la sesión 
            return true;
        } catch (Exception ex) {
            tx.rollback(); //volver un paso atrás
            throw new RuntimeException("No se pudo eliminar la Lista");
        }
    }
}
