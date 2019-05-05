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
    private ControlAutorizacion ctrl;
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

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    public ServicioAdministrador getServicio() {
        return servicio;
    }

    public void setServicio(ServicioAdministrador servicio) {
        this.servicio = servicio;
    }

    public String autenticar() {
        Empleado e = servicio.obtenerAdministrador(empleado);
        if (e != null && e.getContraseña().equals(contrasenia)) {
            ctrl.setEmpleado(e);
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