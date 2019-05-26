package Entidades;

import Entidades.Partido;
import Entidades.TipoDeporte;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-26T14:40:17")
@StaticMetamodel(Equipo.class)
public class Equipo_ { 

    public static volatile SingularAttribute<Equipo, Integer> idEquipo;
    public static volatile ListAttribute<Equipo, Partido> partidoList;
    public static volatile SingularAttribute<Equipo, TipoDeporte> idTipoDeporte;
    public static volatile SingularAttribute<Equipo, String> nombEquipo;

}