package br.com.interfaces;

import br.com.modelos.Departamento;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface DepartamentoRemote {

    void create(Departamento console);

    void edit(Departamento console);

    void remove(Departamento console);

    Departamento find(Object id);

    List<Departamento> findAll();

    List<Departamento> findRange(int[] range);

    int count();
    
}
