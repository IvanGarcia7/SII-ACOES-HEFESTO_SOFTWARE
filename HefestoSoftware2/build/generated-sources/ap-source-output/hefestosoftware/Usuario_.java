package hefestosoftware;

import hefestosoftware.Peticion;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T20:35:13")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, String> descripcion;
    public static volatile SingularAttribute<Usuario, Date> fechaBaja;
    public static volatile SingularAttribute<Usuario, Integer> codigoPostal;
    public static volatile SingularAttribute<Usuario, Date> fechaAlta;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SetAttribute<Usuario, Peticion> Peticiones;
    public static volatile SingularAttribute<Usuario, String> provincia;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile SingularAttribute<Usuario, String> poblacion;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, String> correoElectronico;
    public static volatile SingularAttribute<Usuario, String> dni;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}