/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Libros;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateSession;

/**
 *
 * @author PPK
 */
@ManagedBean
public class HibernateLibrosDAO implements LibroDAO {

    private Session session = null;
    private Libros libro = new Libros();
    private List<Libros> libros = null;

    public List<Libros> getLibros() {
        try {
            session = HibernateSession.getSession();
            Query q = session.createQuery("FROM Libros");
            libros = (List<Libros>) q.list();
        } catch (HibernateException e) {
            
        }
        return libros;
    }

    public void insertarLibro(Libros libro) {
        
        try {
            session = HibernateSession.getSession();
            session.beginTransaction();
            session.save(libro);
            session.getTransaction().commit();
            System.out.println("!!!!!!!!!!!!!!!!!!" + "SImon ya se pudo" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (HibernateException e) {
            System.out.println("!!!!!!!!!!!!!!!!!!" + e.getMessage() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            session.getTransaction().rollback();
        } 
    }

    public void updateLibro(Libros libro) {
        session = HibernateSession.getSession();
        session.beginTransaction();
        session.update(libro);
        session.getTransaction().commit();

    }

    public void deleteLibro(Libros libro) {
        session = HibernateSession.getSession();
        session.beginTransaction();
        session.delete(libro);
        session.getTransaction().commit();

    }

}
