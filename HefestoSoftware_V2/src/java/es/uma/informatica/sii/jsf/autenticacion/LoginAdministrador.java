/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;


import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "loginadministrador")
@RequestScoped
public class LoginAdministrador {

    private String empleado;
    private String contrasenia;

    @Inject
    private ControlAutorizacionAdministracion ctrl;
    @Inject
    private ServicioAdministrador servicio;

    /**
     * Creates a new instance of Login
     */
    public LoginAdministrador() {

    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String usuario) {
        this.empleado = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ControlAutorizacionAdministracion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacionAdministracion ctrl) {
        this.ctrl = ctrl;
    }

    public ServicioAdministrador getServicio() {
        return servicio;
    }

    public void setServicio(ServicioAdministrador servicio) {
        this.servicio = servicio;
    }

    public String autenticar() {
        Empleado u = servicio.obtenerAdministrador(empleado);
        if (u != null && u.getContraseña().equals(contrasenia)) {
            ctrl.setEmpleado(u);
            return ctrl.home();
        } else {
            return "error.xhtml";
        }
    }

    public String reinicio() {
        return "login.xhtml";
    }
}