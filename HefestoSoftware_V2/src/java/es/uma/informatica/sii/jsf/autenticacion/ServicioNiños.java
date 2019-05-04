/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named(value="servicioNiños")
@SessionScoped
public class ServicioNiños implements Serializable {
    private List<Niño> niños;
    
    public ServicioNiños(){
        niños = new ArrayList<>();
        niños.add(new Niño("n1","Jose Manuel","Perez"));
        niños.add(new Niño("n2","Ana Maria","Jimenez"));
        niños.add(new Niño("n3","Jose Alberto","Victoria"));
        niños.add(new Niño("n4","Patricia","Rodriguez"));
        niños.add(new Niño("n5","Alberto","Macias"));
    }
    
    public Niño obtenerNiño(String usuario){
        for(Niño n : niños){
            if(usuario.equals(n.getUsuario())){
                return n;
            }
        }
        return null;
    }
    
    public void delete(String id){
        
    }
    
    public void edit(String id){
        
    }

    public List<Niño> getNiños() {
        return niños;
    }

    public void setNiños(List<Niño> niños) {
        this.niños = niños;
    }
    
}
