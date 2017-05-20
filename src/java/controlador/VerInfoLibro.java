/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import modelo.Libros;

/**
 *
 * @author PPK
 */
@ManagedBean
@SessionScoped
public class VerInfoLibro {

    
    private Libros libro;
    public void VerInformacionLibro(Libros libros) throws Exception {
        if(libros.getAutor()==""){
        libros.setAutor("No hay");
        libros.setNumAdquisicion("No hay");
        libros.setSeccion("No hay");
        libros.setTitulo("No hay");
        }
        try{
            ExternalContext externalContext= FacesContext.getCurrentInstance().getExternalContext();
            libro=libros;
            externalContext.redirect("infoLibro.xhtml");
            
        }
        catch(Exception e){
            throw e;
        }
      
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }
    
}
