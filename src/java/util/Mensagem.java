/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author renato
 */
public class Mensagem {
    public void erro(String sumary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,sumary,null );
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    
    public void erroInserir(String sumary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,sumary,null );
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    
    public void advertencia(String sumary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,sumary,null);
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    
    public void erroAlterar(String sumary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,sumary,null );
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    
    public void erroDeletar(String sumary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,sumary,null );
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    
    public void erroSelecionar(String sumary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,sumary,null);
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
}
