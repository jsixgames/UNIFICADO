/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.interfaces.EstoquePaulistaRemote;
import br.com.modelos.EstoquePaulista;
import br.com.modelos.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CollectionJoin;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateless(mappedName = "ejb/CadastroEstoquePaulistaBean")
public class CadastroEstoquePaulistaBean extends AbstractFacade<EstoquePaulista> implements EstoquePaulistaRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void create(EstoquePaulista entity) {
        getEntityManager().persist(entity);
    }

    public CadastroEstoquePaulistaBean() {
        super(EstoquePaulista.class);
    }

    @Override
        public EstoquePaulista find(Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EstoquePaulista> c = cb.createQuery(EstoquePaulista.class);
        Root<EstoquePaulista> venda = c.from(EstoquePaulista.class);
        c.where(cb.equal(venda.get("id"), cb.parameter(String.class, "id")));
        TypedQuery q = getEntityManager().createQuery(c);
        q.setParameter("id", id);
        return (EstoquePaulista) q.getSingleResult();
    }


}
