/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;


import es.uma.informatica.sii.jsf.autenticacion.modelo.Paquete;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Date;

/**
 *
 * 
 */
@Named(value="nuevoPaquete")
@RequestScoped
public class NuevoPaquete {
    private Paquete paquete;
    
    @Inject
    private ServicioPaquetes servicio;
    @Inject
    private ControlAutorizacionAdministracion ctrl;
    
    public NuevoPaquete(){
        paquete = new Paquete();
    }
    
    public void enviarCarta(){
        paquete.setDestino("Honduras");
        paquete.setEstado("Pendiente");
        paquete.setFechaEnvio(new Date(System.currentTimeMillis()));
        servicio.añadirPaquete(paquete);
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public ServicioPaquetes getServicio() {
        return servicio;
    }

    public void setServicio(ServicioPaquetes servicio) {
        this.servicio = servicio;
    }

    public ControlAutorizacionAdministracion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacionAdministracion ctrl) {
        this.ctrl = ctrl;
    }
    
}
