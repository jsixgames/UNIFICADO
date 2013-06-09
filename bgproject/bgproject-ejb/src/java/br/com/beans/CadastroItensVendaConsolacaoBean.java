/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;


import br.com.interfaces.ItensVendaConsolacaoRemote;
import br.com.modelos.ItensVendaConsolacao;
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
@Stateless(mappedName = "ejb/CadastroItensVendaConcolacaoBean")
public class CadastroItensVendaConsolacaoBean extends AbstractFacade<ItensVendaConsolacao> implements ItensVendaConsolacaoRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void create(ItensVendaConsolacao entity) {
        getEntityManager().persist(entity);
    }

    public CadastroItensVendaConsolacaoBean() {
        super(ItensVendaConsolacao.class);
    }

    @Override
        public ItensVendaConsolacao find(Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ItensVendaConsolacao> c = cb.createQuery(ItensVendaConsolacao.class);
        Root<ItensVendaConsolacao> venda = c.from(ItensVendaConsolacao.class);
        c.where(cb.equal(venda.get("id"), cb.parameter(String.class, "id")));
        TypedQuery q = getEntityManager().createQuery(c);
        q.setParameter("id", id);
        return (ItensVendaConsolacao) q.getSingleResult();
    }


}
