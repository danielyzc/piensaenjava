/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import clases.PersonaReporte;
import entidades.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Usuario
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "smartHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
   
 @Override
    public List<PersonaReporte> listaPersonas() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PersonaReporte> cq = cb.createQuery(PersonaReporte.class);
        CriteriaQuery<Persona> cq2 = cb.createQuery(Persona.class);
        Root<Persona> registro = cq2.from(Persona.class);
        cq.multiselect(registro,cb.countDistinct(registro));
        cq.groupBy(registro.get("apePat"));
        cq.orderBy(cb.desc(cb.countDistinct(registro)));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }
}
