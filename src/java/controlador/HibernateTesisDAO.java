/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;

import modelo.Tesis;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateSession;

/**
 *
 * @author PPK
 */
public class HibernateTesisDAO {
    
    private Session session= null;
    
    private List<Tesis> tesis= null;
    
    public List<Tesis> getTesis(){
        session=HibernateSession.getSession();
        Transaction tx = session.beginTransaction();
        Query q=session.createQuery("FROM Tesis");
        tesis= (List<Tesis>) q.list();
        tx.commit();
        tx=null;
        return tesis;
    }
}
