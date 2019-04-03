package hefestosoftware;

import hefestosoftware.Usuario;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T20:35:13")
@StaticMetamodel(HistorialCartas.class)
public class HistorialCartas_ { 

    public static volatile SingularAttribute<HistorialCartas, Boolean> estado;
    public static volatile SingularAttribute<HistorialCartas, Date> fechaEnvio;
    public static volatile SingularAttribute<HistorialCartas, Usuario> usuario;
    public static volatile SingularAttribute<HistorialCartas, Long> id;

}