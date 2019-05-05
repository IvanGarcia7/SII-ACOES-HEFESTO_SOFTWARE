/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion.modelo;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

/**
 *
 * @author Antonio Manuel
 */
@Entity
public class Peticion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 500)
    private String descripcion;
    @Column(name = "numero_niños", nullable = false)
    private Integer numeroNiños;
    @Column(nullable = false)
    private Boolean tipo;
    @ManyToOne
    private Usuario usuario;
    private Date fechaPeticion;

    public Peticion(Usuario usuario, Integer numeroNiños, Long id, String fechaPeticion){
        this.usuario = usuario;
        this.numeroNiños = numeroNiños;
        this.id = id;
        this.fechaPeticion = Date.valueOf(fechaPeticion);
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumeroNiños() {
        return numeroNiños;
    }

    public void setNumeroNiños(Integer numeroNiños) {
        this.numeroNiños = numeroNiños;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFechaPeticion() {
        return fechaPeticion;
    }

    public void setFechaPeticion(String fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Peticion)) {
            return false;
        }
        Peticion other = (Peticion) object;
        return this.id != null && other.id != null && this.id != null && this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "hefestosoftware.Peticion[ id=" + id + " ]";
    }
    
}
