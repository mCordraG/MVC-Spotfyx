/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author CordraG
 */
public class UsuarioDAO {

    public boolean ingresarUsuario(String nombre, String correo, String pass) {  //Este método recibe el pojo preparado
        Usuario user = new Usuario(nombre, correo, pass);
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = NewHibernateUtil.getSessionFactory(); //obtener acceso  a la factoría de  sesiones
            sesion = sf.openSession(); // iniciar la sesión
            tx = sesion.beginTransaction(); //iniciar una transacción
            sesion.save(user); //para guardar la transacción
            tx.commit();//confinar los cambios que se hacen en la base de datos
            sesion.close(); //para cerrar la sesión 
            return true;
        } catch (Exception ex) {
            tx.rollback(); //volver un paso atrás
            throw new RuntimeException("No se pudo guardar el Usuario");
        }
    }

    public Usuario consultarUsuario(String user) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();//obtener acceso  a la factorÃ­a de  sesiones 
        Session sesion = sf.openSession();// iniciar la sesiÃ³n
        Usuario u = (Usuario) sesion.get(Usuario.class, user);/*instanciamos p, el metodo sesion.get           
         obtiene un poducto de la tabla Producto y el campo que corresponde a su clave primaria que es codigo
         ,  debemos fozar a que el objeto obtenido sea de tipo Producto.*/

        sesion.close();
        if (u != null) {
            return u;
        } else {
            return null;
        }
    }
    public String[] consultarDatosUsuario(String user) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();//obtener acceso  a la factorÃ­a de  sesiones 
        Session sesion = sf.openSession();// iniciar la sesiÃ³n
        Usuario u = (Usuario) sesion.get(Usuario.class, user);/*instanciamos p, el metodo sesion.get           
         obtiene un poducto de la tabla Producto y el campo que corresponde a su clave primaria que es codigo
         ,  debemos fozar a que el objeto obtenido sea de tipo Producto.*/
        String[] datos = null;
        sesion.close();
        if (u != null) {
            datos[0] = u.getNombre();
            datos[1] = u.getCorreo();
            datos[2] = u.getPassword();
            return datos;
        } else {
            return null;
        }
    }

    public List<Usuario> verUsuarios() {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();//obtener acceso  a la factorÃ­a de  sesiones
        Session sesion = sf.openSession();// iniciar la sesiÃ³n
        Query query = sesion.createQuery("from Usuario");//definimos una query y una consulta, esta consulta es en base al pojo por eso con mayÃºscula, luego hibÃ©rnate mapea a la tabla
        List<Usuario> lista = query.list();//en  una lista se rescata los objetos por medio de objeto c/u de las tuplas. Cada una de los tuplas se guarda como objeto en una lista
        sesion.close();
        return lista;
    }

    public boolean editarUsuario(String nameus, String newmail, String newpass) {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        boolean flag = true;
        Usuario us = this.consultarUsuario(nameus);
        try {
            sf = NewHibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Usuario user = (Usuario) sesion.get(Usuario.class, us.getNombre());
            if (user != null) {
                user.setNombre(us.getNombre());
                user.setCorreo(newmail);
                user.setPassword(newpass);
            }
            sesion.update(user);
            tx.commit();
            sesion.close();
        } catch (Exception ex) {
            tx.rollback();
            flag = false;
            throw new RuntimeException("No se pudo guardar la edicion del usuario");
        }
        return flag;
    }

    public boolean eliminarUsuario(Usuario user) {  //Este método recibe el pojo preparado
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf = NewHibernateUtil.getSessionFactory(); //obtener acceso  a la factoría de  sesiones
            sesion = sf.openSession(); // iniciar la sesión
            tx = sesion.beginTransaction(); //iniciar una transacción
            sesion.delete(user); //para guardar la transacción
            tx.commit();//confinar los cambios que se hacen en la base de datos
            sesion.close(); //para cerrar la sesión 
            return true;
        } catch (Exception ex) {
            tx.rollback(); //volver un paso atrás
            throw new RuntimeException("No se pudo eliminar el Usuario");
        }
    }
}
