/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import es.uma.informatica.sii.jsf.autenticacion.modelo.HistorialPadrinos;
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
@Named(value = "vistaSolicitudes")
@ViewScoped
public class VistaSolicitudes implements Serializable {

    private List<HistorialPadrinos> solicitudes;

    @Inject
    private ServicioSolicitudes servicio;
    @Inject
    private ControlAutorizacion ctrl;

    @Inject
    private ControlAutorizacionAdministracion ctrl1;

    
    @PostConstruct
    public void init() {
        
        if(ctrl.getUsuario()==null){
            if (ctrl1.getEmpleado().getRol() == Empleado.Rol.ADMINISTRADOR) {
            solicitudes = servicio.getSolicitudes();
            }
        }else{
            if (ctrl.getUsuario().getRol() == Rol.NORMAL) {
            solicitudes = servicio.obtenerHistorial(ctrl.getUsuario().getUsuario());
            } 
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
