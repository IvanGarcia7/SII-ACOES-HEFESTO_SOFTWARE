/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;


import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
        if(busqueda==null){
            //El usuario no existe dentro de la base de datos
            throw new CuentaInexistenteException();
        }else if(!empleado.getContraseña().equals(busqueda.getContraseña())){
                throw new ContraseniaInvalidaException();
            
        }
    }
    
    



    

}
