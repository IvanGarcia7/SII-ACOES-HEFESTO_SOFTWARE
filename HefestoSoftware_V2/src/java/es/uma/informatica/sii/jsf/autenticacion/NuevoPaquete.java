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
import javax.ejb.EJB;

/**
 *
 *
 */
@Named(value = "nuevoPaquete")
@RequestScoped
public class NuevoPaquete {

    private Paquete paquete;

    @EJB
    private NegocioAdmin negocioAdmin;
    
    @Inject
    private ServicioPaquetes servicio;

    public NuevoPaquete() {
        paquete = new Paquete();
    }

    public void enviarCarta() {
        paquete.setDestino("Honduras");
        paquete.setEstado("Pendiente");
        paquete.setFechaEnvio(new Date(System.currentTimeMillis()));
        servicio.añadirPaquete(paquete);
        negocioAdmin.escribirPaquete(paquete);
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

}
