/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



@Named(value = "registro")
@RequestScoped
public class Registro {
    
    @EJB
    private Negocio negocio;


    private Usuario usuario;
    private String cuenta;
    private String repass;
   

    /**
     * Creates a new instance of Registro
     * @return 
     */

     public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    
    public Registro() {
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String registrarUsuario() throws AcoesException {
       
        try{
            usuario.setFechaAlta(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            negocio.registrarUsuario(usuario);
            return "login.xhtml";
        }catch(CuentaRepetidaException e){
            FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta, dni o correo electrónico.");
            FacesContext.getCurrentInstance().addMessage("registro:user", fm);   
        }
        return null;        
        
    }
     
    public String reinicio() {
        return "login.xhtml";
    }
}
