/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesEJB;

import Entidades.Ganadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ealonso
 */
@Local
public interface GanadoresFacadeLocal {

    void create(Ganadores ganadores);

    void edit(Ganadores ganadores);

    void remove(Ganadores ganadores);

    Ganadores find(Object id);

    List<Ganadores> findAll();

    List<Ganadores> findRange(int[] range);

    int count();
    
}
