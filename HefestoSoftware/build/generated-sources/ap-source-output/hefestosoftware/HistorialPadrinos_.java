package hefestosoftware;

import hefestosoftware.Usuario;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-02T16:36:37")
@StaticMetamodel(HistorialPadrinos.class)
public class HistorialPadrinos_ { 

    public static volatile SingularAttribute<HistorialPadrinos, Date> fechaCancelacion;
    public static volatile SingularAttribute<HistorialPadrinos, String> descripcion;
    public static volatile SingularAttribute<HistorialPadrinos, Date> fechaApadrinamiento;
    public static volatile SingularAttribute<HistorialPadrinos, Usuario> usuario;
    public static volatile SingularAttribute<HistorialPadrinos, Long> id;

}