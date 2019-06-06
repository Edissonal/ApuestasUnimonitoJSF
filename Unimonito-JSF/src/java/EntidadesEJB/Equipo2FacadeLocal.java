/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesEJB;

import Entidades.Equipo2;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ealonso
 */
@Local
public interface Equipo2FacadeLocal {

    void create(Equipo2 equipo2);

    void edit(Equipo2 equipo2);

    void remove(Equipo2 equipo2);

    Equipo2 find(Object id);

    List<Equipo2> findAll();

    List<Equipo2> findRange(int[] range);

    int count();
    
}
