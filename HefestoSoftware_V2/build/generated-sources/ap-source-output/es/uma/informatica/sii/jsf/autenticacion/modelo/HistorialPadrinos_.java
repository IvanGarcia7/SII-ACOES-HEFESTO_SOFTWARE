package es.uma.informatica.sii.jsf.autenticacion.modelo;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Niño;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-23T10:20:03")
@StaticMetamodel(HistorialPadrinos.class)
public class HistorialPadrinos_ { 

    public static volatile SingularAttribute<HistorialPadrinos, Date> fechaCancelacion;
    public static volatile SingularAttribute<HistorialPadrinos, String> descripcion;
    public static volatile SingularAttribute<HistorialPadrinos, Date> fechaApadrinamiento;
    public static volatile SingularAttribute<HistorialPadrinos, Niño> niño;
    public static volatile SingularAttribute<HistorialPadrinos, Usuario> usuario;
    public static volatile SingularAttribute<HistorialPadrinos, Long> id;

}