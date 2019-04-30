/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named(value = "cartas")
@SessionScoped
public class Cartas implements Serializable{

    private List<Carta1> cartas;

    public Cartas() {
        cartas = new ArrayList<Carta1>();
        cartas.add(new Carta1("asunto1", "mensaje1", "Jose Manuel", "pepe", 1, "01/01/2018"));
        cartas.add(new Carta1("asunto2", "mensaje2", "Ana Maria Jimenez", "pepe", 2, "02/03/2018"));
        cartas.add(new Carta1("asunto3", "mensaje3", "Jose Alberto Victoria", "pepe", 3, "03/07/2018"));
        cartas.add(new Carta1("asunto4", "mensaje4", "Patricia Rodriguez", "pepe", 4, "05/09/2018"));
        cartas.add(new Carta1("asunto5", "mensaje5", "Patricia Rodriguez", "antonio", 5, "06/09/2018"));
    }

    public List<Carta1> obtenerHistorial() {
        String usuario = "pepe";
        List<Carta1> historial = new ArrayList<>();
        for (Carta1 c : cartas) {
            if (usuario.equals(c.getUsuario())) {
                historial.add(c);
            }
        }
        return historial;
    }

    public List<Carta1> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta1> cartas) {
        this.cartas = cartas;
    }

}
