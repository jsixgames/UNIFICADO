package br.com.beans;

import br.com.interfaces.Item_PedidoRemote;
import br.com.modelos.Item_Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/ItemPedidoBean")
public class Item_PedidoBean extends AbstractFacade<Item_Pedido> implements Item_PedidoRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Item_PedidoBean() {
        super(Item_Pedido.class);
    }
}
