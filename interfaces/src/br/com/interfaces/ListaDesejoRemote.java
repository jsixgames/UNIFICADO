package br.com.interfaces;

import br.com.modelos.ListaDesejos;
import java.util.List;

public interface ListaDesejoRemote {
    
    public void create(ListaDesejos produto);

    public void edit(ListaDesejos produto);

    public void remove(ListaDesejos produto);

    public ListaDesejos find(Object produto);              

    public List<ListaDesejos> findAll();

    public List<ListaDesejos> findRange(int[] range);

    public int count();
    
}
