/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String contrasenia;

    @Inject
    private ControlAutorizacion ctrl;
    @Inject
    private ServicioUsuarios servicio;

    /**
     * Creates a new instance of Login
     */
    public Login() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }

    public ServicioUsuarios getServicio() {
        return servicio;
    }

    public void setServicio(ServicioUsuarios servicio) {
        this.servicio = servicio;
    }

    public String autenticar() {
        Usuario u = servicio.obtenerUsuario(usuario);
        if (u != null && u.getContraseña().equals(contrasenia)) {
            ctrl.setUsuario(u);
            ctrl.setLogeado(true);
            return ctrl.home();
        } else {
            return "error.xhtml";
        }
    }

    public String reinicio() {
        return "login.xhtml";
    }
}
