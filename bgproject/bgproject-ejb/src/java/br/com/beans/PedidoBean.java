package br.com.beans;

import br.com.interfaces.PedidoRemote;
import br.com.modelos.Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/PedidoBean")
public class PedidoBean extends AbstractFacade<Pedido> implements PedidoRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoBean() {
        super(Pedido.class);
    }
}
