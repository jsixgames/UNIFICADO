package br.com.interfaces;

import br.com.modelos.Cliente;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ClienteRemote {

    public void create(Cliente cliente);

    public void edit(Cliente cliente);

    public void remove(Cliente cliente);

    public Cliente find(Object cliente);       
    
    public Cliente login(String email, String senha);

    public List<Cliente> findAll();

    public List<Cliente> findRange(int[] range);

    public int count();
}