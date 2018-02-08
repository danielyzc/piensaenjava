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
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Usuario
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<T> lista_activos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        cq.orderBy(cb.asc(rt.get("pkId")));
        cq.where(
                getEntityManager().getCriteriaBuilder().equal(rt.get("estado"), 1)
        );
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }
    public List<Object[]> lista_categoria(){
    String consulta = "select r.Monto,r.NumMes,s.descripcion,\n" +
"case when r.Monto >=0 and r.Monto <=100\n" +
"then 'BAJA'\n" +
"when r.Monto >=101 and r.Monto <=300\n" +
"then 'MEDIA'\n" +
"when r.Monto >=301 \n" +
"then 'ALTA'\n" +
"else 'ERROR' end  AS CATEGORIA \n" +
"from recibo r inner join servicio s on\n" +
"r.fk_servicio=s.pk_id";
    Query q = getEntityManager().createNativeQuery(consulta);
 return   q.getResultList();
    }
    
    public List<T> lista_filtrada(String elemento, String parametro) {
        
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        
        cq.orderBy(cb.asc(rt.get("pkId")));
        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                getEntityManager().getCriteriaBuilder().equal(rt.get("estado"), 1),
                getEntityManager().getCriteriaBuilder().like(rt.<String>get(elemento), "%"+parametro.toUpperCase()+"%")
                )
                
                
        );
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }
}
