package br.com.interfaces;

import br.com.modelos.Endereco;
import java.util.List;
import javax.ejb.Remote; 

@Remote
public interface EnderecoRemote {

    void create(Endereco endereco);

    void edit(Endereco endereco);

    void remove(Endereco endereco);

    Endereco find(Object id);

    public List<Endereco> findAll();

    List<Endereco> findRange(int[] range);

    int count();    
}