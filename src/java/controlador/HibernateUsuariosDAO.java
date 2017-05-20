/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateSession;

/**
 *
 * @author PPK
 */
public class HibernateUsuariosDAO {
     public Usuarios selectBiID(int id){
        SessionFactory sessionFactory=HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Usuarios usuario = (Usuarios) session.get(Usuarios.class,id);
        session.close();
        return usuario;
    }
    public List<Usuarios> SelectAll(){
        SessionFactory sessionFactory=HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Usuarios> usuario=session.createCriteria(Usuarios.class).list();
        session.close();
        return usuario;
    }
    public void insert(Usuarios usuario){
        SessionFactory sessionFactory=HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id=(int)session.save(usuario);
        usuario.setIdUsuario(id);
        session.getTransaction().commit();
        session.close();
        
    }
    public void update(Usuarios usuario){
        SessionFactory sessionFactory=HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(usuario);
        session.getTransaction().commit();
        session.close();
        
    }
    public void delete(Usuarios usuario){
        SessionFactory sessionFactory=HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();
        session.close();        
    }
}
