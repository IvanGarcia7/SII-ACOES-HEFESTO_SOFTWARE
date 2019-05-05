/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

@Named(value = "controlAutorizacionAdministracion")
@SessionScoped
public class ControlAutorizacionAdministracion implements Serializable {

    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String home() {
        if (empleado == null) {
            return "login.xhtml";
        } else {
            return "admin.xhtml";
        } 
    }

    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        empleado = null;
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
