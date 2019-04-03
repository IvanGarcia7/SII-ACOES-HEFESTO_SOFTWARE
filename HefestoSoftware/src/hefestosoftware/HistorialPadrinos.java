/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hefestosoftware;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;
import javax.persistence.OneToMany;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "historial_padrinos")
public class HistorialPadrinos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "fecha_apadrinamiento", nullable = false)
    private Date fechaApadrinamiento;
    @Column(name = "fecha_cancelacion")
    private Date fechaCancelacion;
    private String descripcion;
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private Set<Niño> niños;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaApadrinamiento() {
        return fechaApadrinamiento;
    }

    public void setFechaApadrinamiento(Date fechaApadrinamiento) {
        this.fechaApadrinamiento = fechaApadrinamiento;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Set<Niño> getNiños() {
        return niños;
    }

    public void setNiños(Set<Niño> niños) {
        this.niños = niños;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialPadrinos)) {
            return false;
        }
        HistorialPadrinos other = (HistorialPadrinos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hefestosoftware.HistorialPadrinos[ id=" + id + " ]";
    }
    
}
