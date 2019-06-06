package Entidades;

import Entidades.Equipo;
import Entidades.Equipo2;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-05T22:41:43")
@StaticMetamodel(TipoDeporte.class)
public class TipoDeporte_ { 

    public static volatile ListAttribute<TipoDeporte, Equipo2> equipo2List;
    public static volatile SingularAttribute<TipoDeporte, String> nombDepor;
    public static volatile ListAttribute<TipoDeporte, Equipo> equipoList;
    public static volatile SingularAttribute<TipoDeporte, Integer> idTipoDeporte;

}