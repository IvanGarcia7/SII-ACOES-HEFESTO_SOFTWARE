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
        apadrinamientos.add(new HistorialPadrinos(n1, u1));
        apadrinamientos.add(new HistorialPadrinos(n2, u1));
        apadrinamientos.add(new HistorialPadrinos(n3, u1));
        apadrinamientos.add(new HistorialPadrinos(n4, u1));
        apadrinamientos.add(new HistorialPadrinos(n4, u2));
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
