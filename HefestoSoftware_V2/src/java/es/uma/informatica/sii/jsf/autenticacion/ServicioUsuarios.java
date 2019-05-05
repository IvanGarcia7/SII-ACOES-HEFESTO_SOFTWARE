/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named(value = "servicioUsuarios")
@SessionScoped
public class ServicioUsuarios implements Serializable {

    private List<Usuario> usuarios;

    public ServicioUsuarios() {
        usuarios = new ArrayList<>();

        usuarios.add(new Usuario("adela", "qwer", "Adela", "Ramírez Rueda", "adelarr@gmail.com"));
        usuarios.add(new Usuario("alfonso", "qwer", "Alfonso", "Pérez Romero", "alfonsopr@gmail.com"));
        usuarios.add(new Usuario("pepe", "asdf", "Pepe", "Molina", "pepe@yahoo.com"));
        usuarios.add(new Usuario("angel", "qwer", "Angel", "Villalobos", "angelysaras@yahoo.com"));

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
