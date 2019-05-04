/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.HistorialPadrinos;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;


/**
 *
 * @author Antonio Manuel
 */
@Named(value="vistaSolicitudes")
@ViewScoped
public class VistaSolicitudes implements Serializable{
    private List<HistorialPadrinos> solicitudes;
    
    @Inject
    private ServicioSolicitudes servicio;
    @Inject
    private ControlAutorizacion ctrl;
    
    
    @PostConstruct
    public void init(){
        if(ctrl.getUsuario().getRol()==Rol.NORMAL){
            solicitudes = servicio.obtenerHistorial(ctrl.getUsuario().getUsuario());
        }else if(ctrl.getUsuario().getRol()==Rol.ADMINISTRADOR){
            solicitudes = servicio.getSolicitudes();
        }
    }

    public List<HistorialPadrinos> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<HistorialPadrinos> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public ServicioSolicitudes getServicio() {
        return servicio;
    }

    public void setServicio(ServicioSolicitudes servicio) {
        this.servicio = servicio;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
}