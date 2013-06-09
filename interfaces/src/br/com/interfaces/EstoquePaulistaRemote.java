/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.modelos.EstoquePaulista;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface EstoquePaulistaRemote {

    void create(EstoquePaulista produto);

    void edit(EstoquePaulista produto);

    void remove(EstoquePaulista produto);

    EstoquePaulista find(Object id);

    List<EstoquePaulista> findAll();

    List<EstoquePaulista> findRange(int[] range);

    int count();

    
    
}
