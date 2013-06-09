package br.com.beans;

import br.com.interfaces.DepartamentoRemote;
import br.com.modelos.Departamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Stateless(mappedName = "ejb/CadastroDepartamentoBean")
public class CadastroDepartamentoBean extends AbstractFacade<Departamento> implements DepartamentoRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadastroDepartamentoBean() {
        super(Departamento.class);
    }
    
    @Override
        public Departamento find(Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Departamento> c = cb.createQuery(Departamento.class);
        Root<Departamento> venda = c.from(Departamento.class);
        c.where(cb.equal(venda.get("id"), cb.parameter(String.class, "id")));
        TypedQuery q = getEntityManager().createQuery(c);
        q.setParameter("id", id);
        return (Departamento) q.getSingleResult();
    }
    
}
