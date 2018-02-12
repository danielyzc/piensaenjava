/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import clases.PersonaReporte;
import entidades.Persona;
import entidades.Persona_;
import entidades.Usuario;
import entidades.Usuario_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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
    
    // Video Control accesos 01
    @Override
    public Object buscar_login(String usuario_) {
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<Persona> registro = cq.from(Persona.class);
            CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
            Join<Persona, Usuario> join_usuario = registro.join(Persona_.usuario);
            cq.where(
                    getEntityManager().getCriteriaBuilder().and(
                            cb.equal(join_usuario.get(Usuario_.username), usuario_)
                    )
            );
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
