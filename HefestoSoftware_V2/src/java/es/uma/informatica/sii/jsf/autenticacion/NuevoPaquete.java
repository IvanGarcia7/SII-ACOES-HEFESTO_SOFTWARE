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
    private ControlAutorizacion ctrl;
   

    public NuevoPaquete() {
        paquete = new Paquete();
    }

    public void enviarPaquete() {
        
        paquete.setDestino("Honduras");
        paquete.setEstado("Pendiente");
        paquete.setFechaEnvio(new Date(System.currentTimeMillis()));
        paquete.setEmpleado(ctrl.getEmpleado());
        negocioAdmin.escribirPaquete(paquete);
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    

}
