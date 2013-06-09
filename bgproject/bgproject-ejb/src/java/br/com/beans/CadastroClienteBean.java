package br.com.beans;

import br.com.interfaces.ClienteRemote;
import br.com.modelos.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/CadastroClienteBean")
public class CadastroClienteBean extends AbstractFacade<Cliente> implements ClienteRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadastroClienteBean() {
        super(Cliente.class);
    }

    @Override
    public Cliente login(String email, String senha) {        
        Cliente c = null;
        Query query = em.createQuery("select c from Cliente c where c.email='" + email + "'"
                + " and c.senha='" + senha + "'");
        Object result = (Object) query.getSingleResult();
        if (result != null) {
            c = (Cliente) result;
        }
        return c;
    }
}