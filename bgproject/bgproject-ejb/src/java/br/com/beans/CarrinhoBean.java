package br.com.beans;

import br.com.interfaces.CarrinhoRemote;
import br.com.modelos.Item_Pedido;
import br.com.modelos.Produto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful(mappedName="ejb/Cart")
public class CarrinhoBean implements CarrinhoRemote {    
    
    private List<Produto> items;

    @PostConstruct
    public void initialize() {
        items = new ArrayList<Produto>();
    }

    @Override
    public void addItem(Produto item) {
        items.add(item);
    }

    @Override
    public void removeItem(Produto item) {
        items.remove(item);       
    }

    @Override
    public List<Produto> getItems() {        
        return items;
    }
    
    @Override
    public int qtde(){        
        return items.size();
    }
}
