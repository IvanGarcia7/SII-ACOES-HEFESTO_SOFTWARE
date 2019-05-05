/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

@Named(value = "controlAutorizacionAdministracion")
@SessionScoped
public class ControlAutorizacionAdministracion implements Serializable {

    private Empleado usuario;

    public void setEmpleado(Empleado usuario) {
        this.usuario = usuario;
    }

    public Empleado getEmpleado() {
        return usuario;
    }

    public String home() {
        String paginaAdireccionar = "errorAutorizacion.xhtml";
        if (usuario == null) {
            paginaAdireccionar = "login.xhtml";
        } else if (usuario.getRol() == Empleado.Rol.ADMINISTRADOR) {
            paginaAdireccionar = "admin.xhtml";
        } 
        return paginaAdireccionar;
    }

    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    public String registro() {
        return "Registro.xhtml";
    }

    public String error() {
        return "errorAutorizacion.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacionAdministracion() {
    }
}
