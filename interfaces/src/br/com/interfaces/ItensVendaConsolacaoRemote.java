/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.modelos.ItensVendaConsolacao;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jeckson Sacramento Bernardino
 */
@Remote
public interface ItensVendaConsolacaoRemote {

    void create(ItensVendaConsolacao produto);

    void edit(ItensVendaConsolacao produto);

    void remove(ItensVendaConsolacao produto);

    ItensVendaConsolacao find(Object id);

    List<ItensVendaConsolacao> findAll();

    List<ItensVendaConsolacao> findRange(int[] range);

    int count();

    
    
}
