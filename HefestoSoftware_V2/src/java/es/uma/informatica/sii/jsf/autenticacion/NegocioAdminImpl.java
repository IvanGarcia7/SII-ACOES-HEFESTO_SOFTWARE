/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;


import es.uma.informatica.sii.jsf.autenticacion.modelo.Carta;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import es.uma.informatica.sii.jsf.autenticacion.modelo.HistorialPadrinos;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Paquete;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Peticion;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.sql.Date;
import java.util.LinkedList;
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
    public void añadirCarta(Carta carta) {
        carta.setAutorizado(Boolean.FALSE);
        em.persist(carta);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "admin.xhtml");
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
        return em.find(Niño.class, new Long(niño));
    }

    @Override
    public void añadirNiño(Niño niño) {
        em.persist(niño);
    }
    
    @Override
    public void eliminarNiño(Niño niño) {
        em.remove(em.merge(niño));
    }

    @Override
    public void modificarNiño(Niño niño) {
        em.merge(niño);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return em.createQuery("SELECT u FROM Usuario u").getResultList();
    }
    
    @Override
    public List<Usuario> obtenerUsuariosActivos() {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.fechaBaja IS NULL").getResultList();
    }

    @Override
    public void suspenderUsuario(Usuario usuario) {
        Query query = em.createQuery("UPDATE HistorialPadrinos hp SET hp.fechaCancelacion = CURRENT_DATE WHERE hp.usuario = :usuario AND hp.fechaCancelacion IS NULL");
        query.setParameter("usuario", usuario);
        query.executeUpdate();
        query = em.createQuery("DELETE FROM Peticion p WHERE p.usuario = :usuario");
        query.setParameter("usuario", usuario);
        query.executeUpdate();
        usuario.setFechaBaja(new Date(System.currentTimeMillis()));
        em.merge(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void escribirPaquete(Paquete paquete) {
        em.persist(paquete);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "admin.xhtml");

    }
    

    @Override
    public List<Paquete> obtenerPaquetes() {

        Query query = em.createQuery("SELECT c FROM Paquete c");

        return query.getResultList();

    }

     @Override
    public List<Peticion> obtenerPeticiones(String usuario) {
         Query query;
        if(usuario == null || usuario.equals("")){
            query = em.createQuery("SELECT c FROM Peticion c ");
        }else{
            Usuario objetoUsuario = em.find(Usuario.class, usuario);
            query = em.createQuery("SELECT c FROM Peticion c where c.usuario = :fname ");
            query.setParameter("fname", objetoUsuario);
        }
        return query.getResultList();
        
    
    }

    @Override
    public List<HistorialPadrinos> obtenerApadrinamientos(long niño) {
        Query query;
        if (niño == 0) {
            query = em.createQuery("SELECT c FROM HistorialPadrinos c where c.fechaCancelacion > CURRENT_DATE");
        } else {
            Niño objetoNiño = em.find(Niño.class, niño);
            query = em.createQuery("SELECT c FROM HistorialPadrinos c where c.niño = :fname and c.fechaCancelacion > CURRENT_DATE");
            query.setParameter("fname", objetoNiño);
        }
        return query.getResultList();
    }

    @Override
    public boolean esPadrino(Niño niño,Usuario usuario){
        Query query = em.createQuery("SELECT hp FROM HistorialPadrinos hp WHERE hp.niño = :niño AND hp.usuario = :usuario AND hp.fechaCancelacion IS NULL");
        query.setParameter("niño", niño);
        query.setParameter("usuario", usuario);
        return !query.getResultList().isEmpty();
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public LinkedList<Carta> cartasPorAutorizar() {
        Query query;
        query = em.createQuery("SELECT c FROM Carta c where c.autorizado = false");
        List<Carta> cartas = query.getResultList();
        return new LinkedList<>(cartas);
    }

    @Override
    public void autorizarCarta(Carta carta) {
        em.merge(carta);
    }

    @Override
    public List<Carta> obtenerCartas() {
        Query query = em.createQuery("SELECT c FROM Carta c");

        return query.getResultList();
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        Query query = em.createQuery("SELECT n FROM Empleado n");
        return query.getResultList();
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        em.remove(em.merge(empleado));
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        em.merge(empleado);
    }

    @Override
    public void añadirEmpleado(Empleado empleado) {
        em.persist(empleado);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "crudEmpleados.xhtml");
    }
    
    
    
    

}
