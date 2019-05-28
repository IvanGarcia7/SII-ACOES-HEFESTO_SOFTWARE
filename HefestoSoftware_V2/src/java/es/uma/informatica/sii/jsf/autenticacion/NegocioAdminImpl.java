/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Paquete;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class NegocioAdminImpl implements NegocioAdmin {

    @PersistenceContext(unitName = "HefestoBD")
    private EntityManager em;

    /**
     *
     * @param empleado
     * @throws AcoesException
     */
    @Override
    public void compruebaLoginEmpleado(Empleado empleado) throws AcoesException {
        Empleado busqueda = em.find(Empleado.class, empleado.getUsuario());
        if (busqueda == null) {
            //El usuario no existe dentro de la base de datos
            throw new CuentaInexistenteException();
        } else if (!empleado.getContraseña().equals(busqueda.getContraseña())) {
            throw new ContraseniaInvalidaException();

        }
    }

    @Override
    public List<Niño> obtenerNiños() {
        Query query = em.createQuery("SELECT n FROM Niño n");
        return query.getResultList();
    }

    @Override
    public Usuario obtenerUsuario(String usuario) {
        return em.find(Usuario.class, usuario);
    }

    @Override
    public Niño obtenerNiño(String niño) {
        return em.find(Niño.class, niño);
    }

    @Override
    public void eliminarNiño(Niño niño) {
        em.remove(em.merge(niño));
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        Query query = em.createQuery("SELECT u FROM Usuario u");
        return query.getResultList();
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }

         @Override
    public void escribirPaquete(Paquete paquete){
        em.persist(paquete);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "normal.xhtml");
        
    }
    
}
