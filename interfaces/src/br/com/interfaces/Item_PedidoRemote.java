package br.com.interfaces;

import br.com.modelos.Item_Pedido;
import java.util.List;

public interface Item_PedidoRemote {
    
    void create(Item_Pedido item);

    void edit(Item_Pedido item);

    void remove(Item_Pedido item);

    Item_Pedido find(Object id);

    public List<Item_Pedido> findAll();

    List<Item_Pedido> findRange(int[] range);

    int count();
    
}
