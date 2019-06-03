/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesEJB;

import Entidades.Boleteria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ealonso
 */
@Local
public interface BoleteriaFacadeLocal {

    void create(Boleteria boleteria);

    void edit(Boleteria boleteria);

    void remove(Boleteria boleteria);

    Boleteria find(Object id);

    List<Boleteria> findAll();

    List<Boleteria> findRange(int[] range);

    int count();
    
}
