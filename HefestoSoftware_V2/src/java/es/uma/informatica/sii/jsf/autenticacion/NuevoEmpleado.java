/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import java.util.Calendar;
import java.util.Date;
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
    private Date fechaNacimiento;

    @EJB
    private NegocioAdmin negocio;

    public NuevoEmpleado() {
        empleado = new Empleado();
    }

    public String validarEmpleado() {
        try {
            empleado.setFechaAlta(new java.sql.Date(new Date().getTime()));
            negocio.añadirEmpleado(empleado);
            return "crudEmpleados.xhtml";
        } catch (Exception e) {
            return null;
        }
    }

    public Date fechaNacimientoMinima() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -18);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    public Date fechaNacimientoMaxima() {
        return new Date();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado niño) {
        this.empleado = empleado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public NegocioAdmin getNegocio() {
        return negocio;
    }

    public void setNegocio(NegocioAdmin negocio) {
        this.negocio = negocio;
    }

}
