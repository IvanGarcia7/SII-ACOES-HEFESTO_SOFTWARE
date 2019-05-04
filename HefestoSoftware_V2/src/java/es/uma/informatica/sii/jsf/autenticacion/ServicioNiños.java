/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named
@SessionScoped
public class ServicioNiños implements Serializable {

    private List<Niño> niños;
    private int numeroNiños = 0;

    public ServicioNiños() {
        niños = new ArrayList<>();
        añadirNiño("Jose Manuel", "Perez");
        añadirNiño("Ana Maria", "Jimenez");
        añadirNiño("Jose Alberto", "Victoria");
        añadirNiño("Patricia", "Rodriguez");
        añadirNiño("Alberto", "Macias");
    }

    public Niño obtenerNiño(String usuario) {
        for (Niño n : niños) {
            if (usuario.equals(n.getUsuario())) {
                return n;
            }
        }
        return null;
    }
    
    private void añadirNiño(String nombre,String apellidos){
        niños.add(new Niño("n"+(++numeroNiños),nombre,apellidos));
    }
    
    public void añadirNiño(String nombre,String apellidos,String direccion,String poblacion,Date fechaNacimiento) {
        niños.add(new Niño("n"+(++numeroNiños),nombre,apellidos,direccion,poblacion,fechaNacimiento,new Date(System.currentTimeMillis())));
    }
    
    public void delete(String usuario){
        niños.removeIf(n -> n.getUsuario().equals(usuario));
    }

    public List<Niño> getNiños() {
        return niños;
    }

    public void setNiños(List<Niño> niños) {
        this.niños = niños;
    }

    public int getNumeroNiños() {
        return numeroNiños;
    }

    public void setNumeroNiños(int numeroNiños) {
        this.numeroNiños = numeroNiños;
    }

}
