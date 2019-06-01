/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.hs.vista;


import es.uma.informatica.sii.hs.entidades.HistorialPadrinos;
import es.uma.informatica.sii.hs.negocio.NegocioAdmin;
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
@Named(value = "vistaApadrinamientos")
@ViewScoped
public class VistaApadrinamientos implements Serializable {

    private List<HistorialPadrinos> apadrinamientos;
    private long filtradoNiño;
    
    
    @EJB
    private NegocioAdmin negocioAdmin;
    
    @Inject
    private ControlAutorizacion ctrl;

    @PostConstruct
    public void init() {

        if (ctrl.getEmpleado() != null) {
            apadrinamientos = negocioAdmin.obtenerApadrinamientos(filtradoNiño);
        }

    }

    public void filtrar(){
        apadrinamientos = negocioAdmin.obtenerApadrinamientos(filtradoNiño);
    }
    
    public long getFiltradoNiño() {
        return filtradoNiño;
    }

    public void setFiltradoNiño(long filtradoNiño) {
        this.filtradoNiño = filtradoNiño;
    }
    
    public List<HistorialPadrinos> getApadrinamientos() {
        return apadrinamientos;
    }

    public void setApadrinamientos(List<HistorialPadrinos> apadrinamientos) {
        this.apadrinamientos = apadrinamientos;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
}

