/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.HistorialPadrinos;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Antonio Manuel
 */
@Named(value = "servicioSolicitudes")
@SessionScoped
public class ServicioSolicitudes implements Serializable {

    private List<HistorialPadrinos> solicitudes;

    @Inject
    private ServicioUsuarios su;
    
    @PostConstruct
    public void init() {
        solicitudes = new ArrayList<>();
        Usuario u1 = su.obtenerUsuario("adela");
        Usuario u2 = su.obtenerUsuario("alfonso");
        solicitudes.add(new HistorialPadrinos(u1, new Long(1), "2018-02-01"));
        solicitudes.add(new HistorialPadrinos(u1, new Long(2), "2018-03-11"));
        solicitudes.add(new HistorialPadrinos(u2, new Long(3), "2018-05-23"));
        solicitudes.add(new HistorialPadrinos(u2, new Long(4), "2018-08-24"));
    }

    public List<HistorialPadrinos> obtenerHistorial(String usuario) {
        List<HistorialPadrinos> historial = new ArrayList<>();
        for (HistorialPadrinos s : solicitudes) {
            if (usuario.equals(s.getUsuario().getUsuario())) {
                historial.add(s);
            }
        }
        return historial;
    }

    public void añadirSolicitud(HistorialPadrinos s) {
        solicitudes.add(s);
    }

    public List<HistorialPadrinos> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<HistorialPadrinos> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public ServicioUsuarios getSu() {
        return su;
    }

    public void setSu(ServicioUsuarios su) {
        this.su = su;
    }
    
}
