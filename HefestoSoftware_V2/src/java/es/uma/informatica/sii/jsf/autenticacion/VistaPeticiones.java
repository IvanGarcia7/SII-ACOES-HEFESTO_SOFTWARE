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

    @Inject
    private ServicioPeticiones servicio;
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {

        if (ctrl.getUsuario() == null) {
            if (ctrl.getEmpleado() != null) {
                peticiones = servicio.getPeticiones();
            }
        } else {
            peticiones = servicio.obtenerHistorial(ctrl.getUsuario().getUsuario());
        }

    }

    public List<Peticion> getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(List<Peticion> peticiones) {
        this.peticiones = peticiones;
    }

    public ServicioPeticiones getServicio() {
        return servicio;
    }

    public void setServicio(ServicioPeticiones servicio) {
        this.servicio = servicio;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
}
