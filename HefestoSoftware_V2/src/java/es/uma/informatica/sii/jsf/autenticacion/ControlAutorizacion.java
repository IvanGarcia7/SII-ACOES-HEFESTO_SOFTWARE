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

@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;
    private Empleado empleado;
    private boolean logeado;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    public String home() {
        if (!logeado) {
            return "login.xhtml";
        } else if (usuario != null) {
            return "normal.xhtml";
        } else if (empleado != null) {
            return "admin.xhtml";
        }
        return null;
    }

    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        empleado = null;
        logeado = false;
        
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
    public ControlAutorizacion() {
    }
}
