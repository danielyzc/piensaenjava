/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import entidades.Servicio;
import entidades.Servicio_;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author Usuario
 */
@Stateless
public class ServicioFacade extends AbstractFacade<Servicio> implements ServicioFacadeLocal {

    @PersistenceContext(unitName = "smartHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
        super(Servicio.class);
    }
    
    @Override
    public List<Servicio> lista_activos_fecha(String parametro, int tipo_orden,Date inicio_, Date final_) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Servicio> rt = cq.from(Servicio.class);
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        if(tipo_orden ==0){
        cq.orderBy(cb.asc(rt.get(parametro)));
        }else{
        cq.orderBy(cb.desc(rt.get(parametro)));
        }
        
        cq.where(
                getEntityManager().getCriteriaBuilder().equal(rt.get(Servicio_.estado), 1),
                getEntityManager().getCriteriaBuilder().between(rt.get(Servicio_.fecCreacion),inicio_,final_)
        );
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.setMaxResults(2).getResultList();
    }
   }
