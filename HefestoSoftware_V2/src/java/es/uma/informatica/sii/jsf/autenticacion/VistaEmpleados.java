/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Miguel
 */
@Named
@ViewScoped
public class VistaEmpleados implements Serializable {

    private List<Empleado> empleados;

    @EJB
    private NegocioAdmin negocio;

    @PostConstruct
    public void init() {
        empleados = negocio.obtenerEmpleados();
    }

    public void eliminar(Empleado empleado) {
        negocio.eliminarEmpleado(empleado);
    }

    public void modificar(RowEditEvent event) {
        negocio.modificarEmpleado((Empleado) event.getObject());
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setNiños(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public NegocioAdmin getNegocio() {
        return negocio;
    }

    public void setNegocio(NegocioAdmin negocio) {
        this.negocio = negocio;
    }
}
