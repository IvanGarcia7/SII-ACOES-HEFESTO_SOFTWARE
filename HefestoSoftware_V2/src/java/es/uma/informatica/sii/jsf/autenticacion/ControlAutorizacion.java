/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.ADMINISTRADOR;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.NORMAL;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;


@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        String paginaAdireccionar="errorAutorizacion.xhtml";
        if(usuario==null){
            paginaAdireccionar = "login.xhtml";
        }else if(usuario.getRol()==Usuario.Rol.ADMINISTRADOR){
            paginaAdireccionar = "admin.xhtml";
        }else if(usuario.getRol()==Usuario.Rol.NORMAL){
            paginaAdireccionar = "normal.xhtml";
        }
        return paginaAdireccionar;
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
    
    
    public String registro()
    {
        return "Registro.xhtml";
    }
    
    
    
    public String error()
    {
        return "errorAutorizacion.xhtml";
    }
    
    

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
