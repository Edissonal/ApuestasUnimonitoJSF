/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesEJB;

import Entidades.Apuesta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ealonso
 */
@Local
public interface ApuestaFacadeLocal {

    void create(Apuesta apuesta);

    void edit(Apuesta apuesta);

    void remove(Apuesta apuesta);

    Apuesta find(Object id);

    List<Apuesta> findAll();

    List<Apuesta> findRange(int[] range);

    int count();
    
}
