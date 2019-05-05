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

    private List<Empleado> usuarios;

    public ServicioAdministrador() {
        usuarios = new ArrayList<>();

        usuarios.add(new Empleado("manolo", "qwer", "Adela", "Ramírez Rueda", "adelarr@gmail.com", Empleado.Rol.ADMINISTRADOR));
        usuarios.add(new Empleado("amaia", "qwer", "Alfonso", "Pérez Romero", "alfonsopr@gmail.com", Empleado.Rol.ADMINISTRADOR));
        usuarios.add(new Empleado("pedro", "qwer", "Manolo", "Bonilla", "manolopicacabras@yahoo.com", Empleado.Rol.ADMINISTRADOR));
        usuarios.add(new Empleado("saul", "asdf", "Pepe", "Molina", "pepe@yahoo.com", Empleado.Rol.ADMINISTRADOR));
        usuarios.add(new Empleado("ivan", "qwer", "Angel", "Villalobos", "angelysaras@yahoo.com", Empleado.Rol.ADMINISTRADOR));

    }

    public Empleado obtenerAdministrador(String usuario) {
        for (Empleado u : usuarios) {
            if (usuario.equals(u.getUsuario())) {
                return u;
            }
        }
        return null;
    }

    public void añadirAdministrador(Empleado usuario) {
        usuarios.add(usuario);
    }

    public boolean correoDisponible(String correo) {
        for (Empleado u : usuarios) {
            if (correo.equals(u.getCorreoElectronico())) {
                return false;
            }
        }
        return true;
    }

    public List<Empleado> getEmpleados() {
        return usuarios;
    }

    public void setEmpleados(List<Empleado> usuarios) {
        this.usuarios = usuarios;
    }

}
