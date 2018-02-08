/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;
import clases.ReciboSuma;
import entidades.Recibo;
import entidades.Recibo_;
import entidades.Servicio;
import entidades.Servicio_;
import entidades.TipoServicio;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author Usuario
 */
@Stateless
public class ReciboFacade extends AbstractFacade<Recibo> implements ReciboFacadeLocal {

    @PersistenceContext(unitName = "smartHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReciboFacade() {
        super(Recibo.class);
    }
    @Override
    public List<Recibo> lista_tipoServicio(TipoServicio obj_TipoServicio){
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Recibo> cq = getEntityManager().getCriteriaBuilder().createQuery(Recibo.class);
    Root<Recibo> registro = cq.from(Recibo.class);
    Join<Recibo,Servicio> join01 = registro.join(Recibo_.servicio);
    cq.where(
    getEntityManager().getCriteriaBuilder().equal(join01.get(Servicio_.tipoServicio), obj_TipoServicio)
    );
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    return q.getResultList();
    }
    
    @Override
    public List<ReciboSuma> lista_mes(){
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<ReciboSuma> cq=cb.createQuery(ReciboSuma.class);
    CriteriaQuery<Recibo> cq2=cb.createQuery(Recibo.class);
    Root<Recibo> registro = cq2.from(Recibo.class);
    Expression<BigDecimal> suma =cb.sum(registro.<BigDecimal>get("monto"));
    cq.multiselect(registro.get("numMes"),suma);
    cq.groupBy(registro.get("numMes"));
    cq.having(
    cb.and(
    cb.ge(suma, 500),
    cb.le(suma, 5000)
    )
    );
    cq.orderBy(cb.desc(suma));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    return q.getResultList();
    }
       
    }
