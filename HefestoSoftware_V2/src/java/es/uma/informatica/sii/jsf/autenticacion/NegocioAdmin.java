
package es.uma.informatica.sii.jsf.autenticacion;


import es.uma.informatica.sii.jsf.autenticacion.modelo.Empleado;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import javax.ejb.Local;


@Local
public interface NegocioAdmin {

    public void compruebaLoginEmpleado(Empleado empleado) throws AcoesException;;
    
}

