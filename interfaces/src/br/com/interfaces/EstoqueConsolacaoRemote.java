/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.modelos.EstoqueConsolacao;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface EstoqueConsolacaoRemote {

    void create(EstoqueConsolacao produto);

    void edit(EstoqueConsolacao produto);

    void remove(EstoqueConsolacao produto);

    EstoqueConsolacao find(Object id);

    List<EstoqueConsolacao> findAll();

    List<EstoqueConsolacao> findRange(int[] range);

    int count();

    
    
}
