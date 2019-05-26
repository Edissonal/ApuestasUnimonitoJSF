package Entidades;

import Entidades.Boleteria;
import Entidades.Ganadores;
import Entidades.Partido;
import Entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-26T10:33:40")
@StaticMetamodel(Apuesta.class)
public class Apuesta_ { 

    public static volatile ListAttribute<Apuesta, Ganadores> ganadoresList;
    public static volatile SingularAttribute<Apuesta, Integer> marcador2;
    public static volatile SingularAttribute<Apuesta, Integer> marcador1;
    public static volatile SingularAttribute<Apuesta, Boleteria> idBoleteria;
    public static volatile SingularAttribute<Apuesta, Partido> idPartido;
    public static volatile SingularAttribute<Apuesta, Integer> idApuesta;
    public static volatile SingularAttribute<Apuesta, Usuarios> idUsuarios;

}