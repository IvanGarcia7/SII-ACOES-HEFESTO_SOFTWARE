/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Ivan
 */
@Named(value = "servicioEmpleados")
@SessionScoped
public class ServicioAdministrador implements Serializable {

    private List<Empleado> empleados;

    public ServicioAdministrador() {
        empleados = new ArrayList<>();

        empleados.add(new Empleado("manolo", "qwer", "Adela", "Ramírez Rueda", "adelarr@gmail.com"));
        empleados.add(new Empleado("amaia", "qwer", "Alfonso", "Pérez Romero", "alfonsopr@gmail.com"));
        empleados.add(new Empleado("pedro", "qwer", "Manolo", "Bonilla", "manolopicacabras@yahoo.com"));
        empleados.add(new Empleado("saul", "asdf", "Pepe", "Molina", "pepe@yahoo.com"));
        empleados.add(new Empleado("ivan", "qwer", "Angel", "Villalobos", "angelysaras@yahoo.com"));

    }

    public Empleado obtenerAdministrador(String usuario) {
        for (Empleado e : empleados) {
            if (usuario.equals(e.getUsuario())) {
                return e;
            }
        }
        return null;
    }

    public void añadirAdministrador(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

}
