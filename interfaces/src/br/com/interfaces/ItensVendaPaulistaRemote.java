/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.modelos.EstoquePaulista;
import br.com.modelos.ItensVendaPaulista;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jeckson Sacramento Bernardino
 */
@Remote
public interface ItensVendaPaulistaRemote {

    void create(ItensVendaPaulista produto);

    void edit(ItensVendaPaulista produto);

    void remove(ItensVendaPaulista produto);

    ItensVendaPaulista find(Object id);

    List<ItensVendaPaulista> findAll();

    List<ItensVendaPaulista> findRange(int[] range);

    int count();

    
    
}
