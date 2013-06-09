/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.interfaces.ItensVendaPaulistaRemote;
import br.com.modelos.ItensVendaPaulista;

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
@Stateless(mappedName = "ejb/CadastroItensVendaPaulistaBean")
public class CadastroItensVendaPaulistaBean extends AbstractFacade<ItensVendaPaulista> implements ItensVendaPaulistaRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void create(ItensVendaPaulista entity) {
        getEntityManager().persist(entity);
    }

    public CadastroItensVendaPaulistaBean() {
        super(ItensVendaPaulista.class);
    }

    @Override
        public ItensVendaPaulista find(Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ItensVendaPaulista> c = cb.createQuery(ItensVendaPaulista.class);
        Root<ItensVendaPaulista> venda = c.from(ItensVendaPaulista.class);
        c.where(cb.equal(venda.get("id"), cb.parameter(String.class, "id")));
        TypedQuery q = getEntityManager().createQuery(c);
        q.setParameter("id", id);
        return (ItensVendaPaulista) q.getSingleResult();
    }

}
