package es.uma.informatica.sii.hs.entidades;

import es.uma.informatica.sii.hs.entidades.Usuario;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T10:45:38")
@StaticMetamodel(Peticion.class)
public class Peticion_ { 

    public static volatile SingularAttribute<Peticion, String> descripcion;
    public static volatile SingularAttribute<Peticion, Integer> numeroNiños;
    public static volatile SingularAttribute<Peticion, Boolean> tipo;
    public static volatile SingularAttribute<Peticion, Date> fechaPeticion;
    public static volatile SingularAttribute<Peticion, Usuario> usuario;
    public static volatile SingularAttribute<Peticion, Long> id;

}