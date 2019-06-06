/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesEJB;

import Entidades.TipoDeporte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ealonso
 */
@Local
public interface TipoDeporteFacadeLocal {

    void create(TipoDeporte tipoDeporte);

    void edit(TipoDeporte tipoDeporte);

    void remove(TipoDeporte tipoDeporte);

    TipoDeporte find(Object id);

    List<TipoDeporte> findAll();

    List<TipoDeporte> findRange(int[] range);

    int count();
    
}
