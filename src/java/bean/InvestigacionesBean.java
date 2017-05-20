/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controlador.HibernateTesisDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import modelo.Tesis;

/**
 *
 * @author PPK
 */
@ManagedBean
public class InvestigacionesBean {
     private List<Tesis> tesis= null;
   
   public List<Tesis> getTesis(){
       HibernateTesisDAO tesisDAO = new HibernateTesisDAO();
       tesis= tesisDAO.getTesis();
       return tesis;
   }
    
}
