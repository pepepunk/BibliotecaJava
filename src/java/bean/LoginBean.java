/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controlador.HibernateLoginDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Usuarios;

/**
 *
 * @author PPK
 */
@ManagedBean
public class LoginBean {

    Usuarios usuario = new Usuarios();

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String verificarDatos() throws Exception {
        HibernateLoginDAO loginDAO = new HibernateLoginDAO();
        Usuarios us;
        String resultado;

        try {
            us = loginDAO.verificarDatos(this.usuario);
            if (us != null) {
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", us);
                resultado = "admin?faces-redirect=true";
            } else {
                resultado = "login?faces-redirect=true";
            }
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    public boolean verificarSesion(){
        boolean estado;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario")==null){
            estado= false;
        } else{
            estado=true;
        }
        return estado;
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

}
