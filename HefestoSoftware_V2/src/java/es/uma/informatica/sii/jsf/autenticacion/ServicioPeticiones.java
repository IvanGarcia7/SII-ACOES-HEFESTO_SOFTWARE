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
import javax.inject.Inject;

/**
 *
 * @author Antonio Manuel
 */
@Named(value = "servicioPeticiones")
@SessionScoped
public class ServicioPeticiones implements Serializable {

    @Inject
    private ServicioUsuarios su;
    
    private List<Peticion> peticiones;

    public ServicioPeticiones() {
        peticiones = new ArrayList<>();
        Usuario u1 = su.obtenerUsuario("adela");
        Usuario u2 = su.obtenerUsuario("alfonso");
        Peticion p1 = new Peticion(u1,new Integer(1),new Long(1),"2018-03-23");
        Peticion p2 = new Peticion(u2,new Integer(1),new Long(2),"2018-06-01");
        Peticion p3 = new Peticion(u1,new Integer(1),new Long(3),"2018-01-12");
        Peticion p4 = new Peticion(u1,new Integer(2),new Long(4),"2018-11-26");
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
