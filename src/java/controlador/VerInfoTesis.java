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

import modelo.Tesis;

/**
 *
 * @author PPK
 */
@ManagedBean
@SessionScoped
public class VerInfoTesis {

    
    private Tesis tesis;
    public void VerInformacionTesis(Tesis tesis) throws Exception {
        
        try{
            ExternalContext externalContext= FacesContext.getCurrentInstance().getExternalContext();
            this.tesis=tesis;
            externalContext.redirect("infoInve.xhtml");
            
        }
        catch(Exception e){
            throw e;
        }
      
    }

    public Tesis getTesis() {
        return tesis;
    }

    public void setTesis(Tesis tesis) {
        this.tesis = tesis;
    }
    
}
