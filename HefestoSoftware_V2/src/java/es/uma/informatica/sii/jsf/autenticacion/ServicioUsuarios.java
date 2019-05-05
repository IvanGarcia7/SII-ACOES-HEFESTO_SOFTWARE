/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.io.Serializable;
import java.sql.Date;
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
        // Usar el usuario "pepe" para probar, que tiene mas datos
        usuarios.add(new Usuario("adela", "qwer", "Adela", "Ramírez Rueda","97819599R","Calle Cadiz 18","Fuengirola",29640,"Malaga","712310162","adelarr@gmail.com",Date.valueOf("2017-01-01")));
        usuarios.add(new Usuario("alfonso", "qwer", "Alfonso", "Pérez Romero","38691438X","Calle Cuenca 14","Fuengirola",29640,"Malaga","629914238" ,"alfonsopr@gmail.com",Date.valueOf("2017-08-21")));
        usuarios.add(new Usuario("pepe", "asdf", "Pepe", "Molina","37439218W","Calle Lentejas 3","Fuengirola",29640,"Malaga","683278566","pepe@yahoo.com",Date.valueOf("2017-07-01")));
        usuarios.add(new Usuario("angel", "qwer", "Angel", "Villalobos", "48807199A","Calle Algarrobas 7","Fuengirola",29640,"Malaga","699174081","angelysaras@yahoo.com",Date.valueOf("2017-07-07")));

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
    
    public void delete(String usuario){
        usuarios.removeIf(u -> u.getUsuario().equals(usuario));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
