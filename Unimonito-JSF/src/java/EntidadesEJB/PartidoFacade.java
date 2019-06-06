/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesEJB;

import Entidades.Partido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ealonso
 */
@Stateless
public class PartidoFacade extends AbstractFacade<Partido> implements PartidoFacadeLocal {

    @PersistenceContext(unitName = "Unimonito-JSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartidoFacade() {
        super(Partido.class);
    }
    
}
