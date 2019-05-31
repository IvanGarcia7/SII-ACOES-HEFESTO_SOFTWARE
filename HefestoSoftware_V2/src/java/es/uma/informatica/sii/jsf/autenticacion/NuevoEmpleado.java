/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import java.sql.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named
@RequestScoped
public class NuevoEmpleado {

    private Empleado empleado;

    @EJB
    private NegocioAdmin negocio;

    public NuevoEmpleado() {
        empleado = new Empleado();
    }

    public void validarEmpleado() {
        empleado.setFechaAlta(new Date(System.currentTimeMillis()));
        negocio.añadirEmpleado(empleado);
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public NegocioAdmin getNegocio() {
        return negocio;
    }

    public void setNegocio(NegocioAdmin negocio) {
        this.negocio = negocio;
    }

}
