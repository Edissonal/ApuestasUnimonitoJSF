package Entidades;

import Entidades.Apuesta;
import Entidades.Rifa;
import Entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-26T10:33:41")
@StaticMetamodel(Boleteria.class)
public class Boleteria_ { 

    public static volatile SingularAttribute<Boleteria, Integer> precio;
    public static volatile SingularAttribute<Boleteria, Integer> idBoleteria;
    public static volatile SingularAttribute<Boleteria, Integer> cantidad;
    public static volatile ListAttribute<Boleteria, Rifa> rifaList;
    public static volatile SingularAttribute<Boleteria, Usuarios> idUsuarios;
    public static volatile ListAttribute<Boleteria, Apuesta> apuestaList;

}