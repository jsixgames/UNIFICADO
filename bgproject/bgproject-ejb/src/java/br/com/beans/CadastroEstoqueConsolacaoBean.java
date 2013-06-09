/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.interfaces.EstoqueConsolacaoRemote;
import br.com.modelos.EstoqueConsolacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateless(mappedName = "ejb/CadastroEstoqueConsolacaoBean")
public class CadastroEstoqueConsolacaoBean extends AbstractFacade<EstoqueConsolacao> implements EstoqueConsolacaoRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void create(EstoqueConsolacao entity) {
        getEntityManager().persist(entity);
    }

    public CadastroEstoqueConsolacaoBean() {
        super(EstoqueConsolacao.class);
    }

    @Override
        public EstoqueConsolacao find(Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EstoqueConsolacao> c = cb.createQuery(EstoqueConsolacao.class);
        Root<EstoqueConsolacao> venda = c.from(EstoqueConsolacao.class);
        c.where(cb.equal(venda.get("id"), cb.parameter(String.class, "id")));
        TypedQuery q = getEntityManager().createQuery(c);
        q.setParameter("id", id);
        return (EstoqueConsolacao) q.getSingleResult();
    }


}
