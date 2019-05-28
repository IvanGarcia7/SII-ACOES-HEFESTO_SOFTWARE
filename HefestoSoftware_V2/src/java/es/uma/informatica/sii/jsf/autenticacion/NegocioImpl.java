/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Peticion;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class NegocioImpl implements Negocio {

    @PersistenceContext(unitName = "HefestoBD")
    private EntityManager em;

    @Override
    public void registrarUsuario(Usuario u) throws AcoesException {

        try {

            Usuario user = em.find(Usuario.class, u.getUsuario());
            Usuario user1 = em.find(Usuario.class, u.getDni());
            Usuario user2 = em.find(Usuario.class, u.getCorreoElectronico());

            if (user != null || user1 != null || user2 != null) {

                // El usuario ya existe
                throw new CuentaRepetidaException();
            } else {
                em.persist(u);
            }

        } catch (NullPointerException e) {
            throw new CuentaRepetidaException();
        }

    }

    /**
     *
     * @param u
     * @return
     * @throws AcoesException
     */
    @Override
    public void compruebaLogin(Usuario u) throws AcoesException {
        // TODO

        Usuario busqueda = em.find(Usuario.class, u.getUsuario());
        if (busqueda == null) {
            //El usuario no existe dentro de la base de datos
            throw new CuentaInexistenteException();
        } else if (!u.getContraseña().equals(busqueda.getContraseña())) {
            throw new ContraseniaInvalidaException();

        }

    }

    @Override
    public Usuario refrescarUsuario(Usuario u) throws AcoesException {
        // TODO
        compruebaLogin(u);
        Usuario busquedaUsuario = em.find(Usuario.class, u.getUsuario());
        return busquedaUsuario;
    }

    @Override
    public void añadirCarta(Carta carta) {
        carta.setAutorizado(Boolean.FALSE);
        em.persist(carta);
         FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "normal.xhtml");
    }

    @Override
    public List<Niño> obtenerNiñosApadrinados(Usuario usuario) {
        Query query = em.createQuery("SELECT f.niño from HistorialPadrinos f where f.usuario = :fname");
        query.setParameter("fname", usuario);
        
        
        return query.getResultList();
    }

    
    
    
    
    
    
    @Override
    public List<Carta> obtenerCartasRecibidas(Usuario usuario) {
        Query query = em.createQuery("SELECT c FROM Carta c WHERE c.usuario = :fname AND c.emisor = :emisor");
        query.setParameter("fname", usuario);
        query.setParameter("emisor", false);
        return query.getResultList();
    }

    @Override
    public List<Carta> obtenerCartasEnviadas(Usuario usuario) {
        Query query = em.createQuery("SELECT c FROM Carta c WHERE c.usuario = :fname AND c.emisor = :emisor");
        query.setParameter("fname", usuario);
        query.setParameter("emisor", true);
        return query.getResultList();
    }
    

   
    @Override
    public void enviarPeticion(Peticion peticion){
        em.persist(peticion);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "normal.xhtml");
    }
    
}
