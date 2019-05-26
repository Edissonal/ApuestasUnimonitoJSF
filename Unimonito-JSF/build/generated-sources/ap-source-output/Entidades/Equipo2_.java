package Entidades;

import Entidades.Partido;
import Entidades.TipoDeporte;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-25T20:43:49")
@StaticMetamodel(Equipo2.class)
public class Equipo2_ { 

    public static volatile SingularAttribute<Equipo2, Integer> idEquipo2;
    public static volatile ListAttribute<Equipo2, Partido> partidoList;
    public static volatile SingularAttribute<Equipo2, String> nombEquipo2;
    public static volatile SingularAttribute<Equipo2, TipoDeporte> idTipoDeporte;

}