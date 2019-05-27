/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import java.sql.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named
@RequestScoped
public class NuevoNiño {
        
    private String nombre;
    private String apellidos;
    private String direccion;
    private String poblacion;
    private String fechaNacimiento;
    

    @Inject
    private ServicioNiños servicio;

    public String validarNiño() {
        try{
            Date fn = Date.valueOf(fechaNacimiento);
            servicio.añadirNiño(nombre,apellidos,direccion,poblacion,fn);
            return "crudninos.xhtml";
        }catch(IllegalArgumentException e){
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("form:fecha", new FacesMessage("Introduce fecha en formato yyyy-mm-dd"));
            return null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ServicioNiños getServicio() {
        return servicio;
    }

    public void setServicio(ServicioNiños servicio) {
        this.servicio = servicio;
    }

}
