package br.com.interfaces;

import br.com.modelos.Pedido;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PedidoRemote {
    
    void create(Pedido pedido);

    void edit(Pedido pedido);

    void remove(Pedido pedido);

    Pedido find(Object id);

    public List<Pedido> findAll();

    List<Pedido> findRange(int[] range);

    int count();    
}
