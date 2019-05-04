/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Paquete;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol;
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
@Named(value = "vistaPaquetes")
@ViewScoped
public class VistaPaquetes implements Serializable {

    private List<Paquete> paquetes;

    @Inject
    private ServicioPaquetes servicio;
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {
        if (ctrl.getUsuario().getRol() == Rol.NORMAL) {
            paquetes = servicio.obtenerHistorial(ctrl.getUsuario().getUsuario());
        } else if (ctrl.getUsuario().getRol() == Rol.ADMINISTRADOR) {
            paquetes = servicio.getPaquetes();
        }
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public ServicioPaquetes getServicio() {
        return servicio;
    }

    public void setServicio(ServicioPaquetes servicio) {
        this.servicio = servicio;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
}
