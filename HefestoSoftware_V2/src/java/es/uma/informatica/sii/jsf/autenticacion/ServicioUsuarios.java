/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author yo
 */
@Named(value = "servicioUsuarios")
@SessionScoped
public class ServicioUsuarios implements Serializable {

    private List<Usuario> usuarios;

    public ServicioUsuarios() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("manolo", "qwer", "manolopicacabras@yahoo.com", Rol.ADMINISTRADOR));
        usuarios.add(new Usuario("pepe", "asdf", "pepe@yahoo.com", Rol.NORMAL));
        usuarios.add(new Usuario("angel", "qwer", "angelysaras@yahoo.com", Rol.NORMAL));
    }

    public Usuario obtenerUsuario(String usuario) {
        for (Usuario u : usuarios) {
            if (usuario.equals(u.getUsuario())) {
                return u;
            }
        }
        return null;
    }

    public void añadirUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean correoDisponible(String correo) {
        for (Usuario u : usuarios) {
            if (correo.equals(u.getCorreoElectronico())) {
                return false;
            }
        }
        return true;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
