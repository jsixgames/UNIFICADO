/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.interfaces.ProdutoRemote;
import br.com.modelos.Produto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateless(mappedName = "ejb/CadastroProdutoBean")
public class CadastroProdutoBean extends AbstractFacade<Produto> implements ProdutoRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadastroProdutoBean() {
        super(Produto.class);
    }
}
