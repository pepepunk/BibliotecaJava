/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuarios;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateSession;

/**
 *
 * @author PPK
 */
public class HibernateLoginDAO{
    private Session session;
    
   public Usuarios verificarDatos(Usuarios usuario) throws Exception{
       Usuarios us= null;
       
       try{ 
           session= HibernateSession.getSession();
           String hql= "FROM Usuarios WHERE usuario='"+usuario.getUsuario()
                   +"' AND contrasena='"+usuario.getContrasena()+"'";
           Query query = session.createQuery(hql);
           
           if(!query.list().isEmpty()){
               us=(Usuarios) query.list().get(0);
           }
               
       }
       catch(Exception e){
           throw e;
       }
       return us;
   }

}
