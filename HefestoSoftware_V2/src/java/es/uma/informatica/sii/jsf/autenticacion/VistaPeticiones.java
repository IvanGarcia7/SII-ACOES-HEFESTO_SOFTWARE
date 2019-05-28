/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Peticion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Antonio Manuel
 */
@Named(value = "vistaPeticiones")
@ViewScoped
public class VistaPeticiones implements Serializable {

    private List<Peticion> peticiones;

    @EJB
    private NegocioAdmin negocioAdmin;
    
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {

        if (ctrl.getUsuario() == null) {
            if (ctrl.getEmpleado() != null) {
                peticiones = negocioAdmin.obtenerPeticiones("");
            }
        } else {
            peticiones = negocioAdmin.obtenerPeticiones(ctrl.getUsuario().getUsuario());
        }

    }

    public List<Peticion> getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(List<Peticion> peticiones) {
        this.peticiones = peticiones;
    }

   

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
}

