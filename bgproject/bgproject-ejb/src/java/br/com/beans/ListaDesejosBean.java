package br.com.beans;

import br.com.interfaces.ListaDesejoRemote;
import br.com.modelos.ListaDesejos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/ListaDesejosBean")
public class ListaDesejosBean extends AbstractFacade<ListaDesejos> implements ListaDesejoRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListaDesejosBean() {
        super(ListaDesejos.class);
    }
}
