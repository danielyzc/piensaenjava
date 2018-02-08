/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import entidades.TipoServicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class TipoServicioFacade extends AbstractFacade<TipoServicio> implements TipoServicioFacadeLocal {

    @PersistenceContext(unitName = "smartHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoServicioFacade() {
        super(TipoServicio.class);
    }
    
}
