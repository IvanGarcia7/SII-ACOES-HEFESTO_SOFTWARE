package hefestosoftware;

import hefestosoftware.Niño;
import hefestosoftware.Usuario;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T16:02:21")
@StaticMetamodel(HistorialPadrinos.class)
public class HistorialPadrinos_ { 

    public static volatile SingularAttribute<HistorialPadrinos, Date> fechaCancelacion;
    public static volatile SingularAttribute<HistorialPadrinos, String> descripcion;
    public static volatile SingularAttribute<HistorialPadrinos, Date> fechaApadrinamiento;
    public static volatile SingularAttribute<HistorialPadrinos, Niño> niño;
    public static volatile SingularAttribute<HistorialPadrinos, Usuario> usuario;
    public static volatile SingularAttribute<HistorialPadrinos, Long> id;

}