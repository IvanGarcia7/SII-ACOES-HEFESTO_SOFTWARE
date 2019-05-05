/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.HistorialPadrinos;
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
@Named(value = "vistaApadrinamientos")
@ViewScoped
public class VistaApadrinamientos implements Serializable {

    private List<HistorialPadrinos> apadrinamientos;

    @Inject
    private ServicioPadrinos servicio;
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {

        if (ctrl.getEmpleado() != null) {
            apadrinamientos = servicio.getApadrinamientos();
        }

    }

    public List<HistorialPadrinos> getApadrinamientos() {
        return apadrinamientos;
    }

    public void setApadrinamientos(List<HistorialPadrinos> apadrinamientos) {
        this.apadrinamientos = apadrinamientos;
    }

    public ServicioPadrinos getServicio() {
        return servicio;
    }

    public void setServicio(ServicioPadrinos servicio) {
        this.servicio = servicio;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
}
