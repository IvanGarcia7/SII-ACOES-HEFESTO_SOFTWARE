/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Paquete;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Antonio Manuel
 */
@Named(value = "servicioPaquetes")
@SessionScoped
public class ServicioPaquetes implements Serializable {

    private List<Paquete> paquetes;

    public ServicioPaquetes() {
        paquetes = new ArrayList<>();
        paquetes.add(new Paquete(new Long(1), "Medicamentos varios", "2018-04-29", "Aceptado"));
        paquetes.add(new Paquete(new Long(2), "Latas de comida", "2018-02-05", "Aceptado"));
        paquetes.add(new Paquete(new Long(3), "Tiritas", "2018-08-11", "Aceptado"));
        paquetes.add(new Paquete(new Long(4), "Herramientas enfermería", "2018-11-11", "Aceptado"));
    }

    public List<Paquete> obtenerHistorial(String usuario) {
        List<Paquete> historial = new ArrayList<>();
        for (Paquete p : paquetes) {
            if (usuario.equals(p.getEmpleado())) {
                historial.add(p);
            }
        }
        return historial;
    }

    public void añadirPaquete(Paquete p) {
        paquetes.add(p);
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
}
