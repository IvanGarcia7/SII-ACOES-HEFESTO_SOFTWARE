/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.HistorialPadrinos;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named(value = "servicioPadrinos")
@SessionScoped
public class ServicioPadrinos implements Serializable {

    private List<HistorialPadrinos> apadrinamientos;

    @Inject
    private ServicioNiños sn;
    @Inject
    private ServicioUsuarios su;

    @PostConstruct
    public void init() {
        apadrinamientos = new ArrayList<>();
        Niño n1 = sn.obtenerNiño("n1");
        Niño n2 = sn.obtenerNiño("n2");
        Niño n3 = sn.obtenerNiño("n3");
        Niño n4 = sn.obtenerNiño("n4");
        Usuario u1 = su.obtenerUsuario("pepe");
        Usuario u2 = su.obtenerUsuario("angel");
        apadrinamientos.add(new HistorialPadrinos(new Long(1),n1, u1,"2018-02-01"));
        apadrinamientos.add(new HistorialPadrinos(new Long(2),n2, u1,"2018-03-11"));
        apadrinamientos.add(new HistorialPadrinos(new Long(3),n3, u1,"2018-05-23"));
        apadrinamientos.add(new HistorialPadrinos(new Long(4),n4, u1,"2018-08-24"));
        apadrinamientos.add(new HistorialPadrinos(new Long(5),n4, u2,"2018-08-27"));
    }

    public List<Niño> obtenerNiñosApadrinados(Usuario usuario) {
        List<Niño> apadrinados = new ArrayList<>();
        for (HistorialPadrinos hp : apadrinamientos) {
            if (hp.getUsuario().getUsuario().equals(usuario.getUsuario()) && hp.getFechaCancelacion() == null) {
                apadrinados.add(hp.getNiño());
            }
        }
        return apadrinados;
    }

    public List<HistorialPadrinos> obtenerHistorial(String usuario) {
        List<HistorialPadrinos> historial = new ArrayList<>();
        for (HistorialPadrinos a : apadrinamientos) {
            if (usuario.equals(a.getUsuario().getUsuario())) {
                historial.add(a);
            }
        }
        return historial;
    }
    
    public List<HistorialPadrinos> getApadrinamientos() {
        return apadrinamientos;
    }

    public void setApadrinamientos(List<HistorialPadrinos> apadrinamientos) {
        this.apadrinamientos = apadrinamientos;
    }

    public ServicioNiños getSn() {
        return sn;
    }

    public void setSn(ServicioNiños sn) {
        this.sn = sn;
    }

    public ServicioUsuarios getSu() {
        return su;
    }

    public void setSu(ServicioUsuarios su) {
        this.su = su;
    }

}
