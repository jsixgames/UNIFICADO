package br.com.interfaces;

import br.com.modelos.Item_Pedido;
import br.com.modelos.Produto;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

@Remote
public interface CarrinhoRemote {

    public void addItem(Produto item);

    public void removeItem(Produto item);

    public List<Produto> getItems();
    
    int qtde();
}