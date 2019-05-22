/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;


import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class NegocioImpl implements Negocio {

    @PersistenceContext(unitName = "HefestoBD")
    private EntityManager em;
    
    

    @Override
    public void registrarUsuario(Usuario u) throws AcoesException {
        
        try{
        
        Usuario user = em.find(Usuario.class, u.getUsuario());
        Usuario user1 = em.find(Usuario.class, u.getDni());
        Usuario user2 = em.find(Usuario.class, u.getCorreoElectronico());
        
        if (user != null || user1.getDni().equals(u.getDni()) || user2.getCorreoElectronico().equals(u.getCorreoElectronico()) ) {
            // El usuario ya existe
            throw new CuentaRepetidaException();
        }else{
            em.persist(u);
        }
        
        }catch(NullPointerException e){
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
    public void compruebaLogin(Usuario u)  throws AcoesException {
        // TODO
        
        Usuario busqueda = em.find(Usuario.class, u.getUsuario());
        if(busqueda==null){
            //El usuario no existe dentro de la base de datos
            throw new CuentaInexistenteException();
        }else if(!u.getContraseña().equals(busqueda.getContraseña())){
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

   


    

}
