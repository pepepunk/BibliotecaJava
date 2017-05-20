/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controlador.HibernateLibrosDAO;
import controlador.LibroDAO;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Libros;

/**
 *
 * @author PPK
 */

@ManagedBean
@ApplicationScoped 
public class LibrosBean implements java.io.Serializable{
    
    private List<Libros> libros;
    private Libros libro;

    public LibrosBean() {
        libro= new Libros();
    }

    public LibrosBean(List<Libros> libros, Libros libro) {
        this.libros = libros;
        this.libro = libro;
    }
    

    public LibrosBean(Libros libro) {
        this.libro = libro;
        
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }
    
   
   public List<Libros> getLibros(){
       LibroDAO librosDAO = new HibernateLibrosDAO();
       libros= librosDAO.getLibros();
       return libros;
   }
   
   public void insertarLibro(){
      HibernateLibrosDAO librosDAO = new HibernateLibrosDAO(); 
      librosDAO.insertarLibro(libro);
      libro= new Libros();
   }

   
   public void editarLibro(){
      LibroDAO librosDAO = new HibernateLibrosDAO();
      librosDAO.updateLibro(libro);
      
      
   }
   
   public void eliminarLibro(){
      LibroDAO librosDAO = new HibernateLibrosDAO(); 
      librosDAO.deleteLibro(libro);
      libro= new Libros();
   }
    
}
