/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Peticion;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Antonio Manuel
 */
@Named(value = "servicioPeticiones")
@SessionScoped
public class ServicioPeticiones implements Serializable {

    private List<Peticion> peticiones;

    public ServicioPeticiones() {
        peticiones = new ArrayList<>();
        Usuario u1 = new Usuario("pepe", "asdf", Usuario.Rol.NORMAL);
        Usuario u2 = new Usuario("manolo", "qwer", Usuario.Rol.ADMINISTRADOR);
        Peticion p1 = new Peticion(u1,new Integer(1),new Long(1),"01/02/2018");
        Peticion p2 = new Peticion(u2,new Integer(1),new Long(2),"11/03/2018");
        Peticion p3 = new Peticion(u1,new Integer(1),new Long(3),"23/05/2018");
        Peticion p4 = new Peticion(u1,new Integer(2),new Long(4),"24/08/2018");
        peticiones.add(p1);
        peticiones.add(p2);
        peticiones.add(p3);
        peticiones.add(p4);
    }

    public List<Peticion> obtenerHistorial(String usuario) {
        List<Peticion> historial = new ArrayList<>();
        for (Peticion p : peticiones) {
            if (usuario.equals(p.getUsuario().getUsuario())) {
                historial.add(p);
            }
        }
        return historial;
    }

    public void añadirPeticion(Peticion p) {
        peticiones.add(p);
    }

    public List<Peticion> getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(List<Peticion> peticiones) {
        this.peticiones = peticiones;
    }
}
