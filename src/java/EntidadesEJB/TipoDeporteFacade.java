/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesEJB;

import Entidades.TipoDeporte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ealonso
 */
@Stateless
public class TipoDeporteFacade extends AbstractFacade<TipoDeporte> implements TipoDeporteFacadeLocal {

    @PersistenceContext(unitName = "Unimonito-JSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDeporteFacade() {
        super(TipoDeporte.class);
    }
    
}
