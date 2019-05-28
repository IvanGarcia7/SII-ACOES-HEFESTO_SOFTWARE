/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Paquete;
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
@Named(value = "vistaPaquetes")
@ViewScoped
public class VistaPaquetes implements Serializable {

    private List<Paquete> paquetes;

   
    @EJB
    private NegocioAdmin negocioAdmin;
    @Inject
    private ServicioPaquetes servicio;
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {

        if (ctrl.getEmpleado() != null) {
            paquetes = negocioAdmin.obtenerPaquetes();
        }

    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

   

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }

}
