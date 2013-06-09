package br.com.interfaces;

import br.com.modelos.Produto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ProdutoRemote {

    void create(Produto produto);

    void edit(Produto produto);

    void remove(Produto produto);

    Produto find(Object id);

    List<Produto> findAll();

    List<Produto> findRange(int[] range);

    int count();
    
}