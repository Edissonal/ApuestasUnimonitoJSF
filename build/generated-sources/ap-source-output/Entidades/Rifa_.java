package Entidades;

import Entidades.Boleteria;
import Entidades.Ganadores;
import Entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-05T22:41:43")
@StaticMetamodel(Rifa.class)
public class Rifa_ { 

    public static volatile ListAttribute<Rifa, Ganadores> ganadoresList;
    public static volatile SingularAttribute<Rifa, String> premio;
    public static volatile SingularAttribute<Rifa, Integer> idRifa;
    public static volatile SingularAttribute<Rifa, Boleteria> idBoleteria;
    public static volatile SingularAttribute<Rifa, Usuarios> idUsuarios;

}