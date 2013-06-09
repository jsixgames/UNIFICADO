/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.com.interfaces.ProdutoRemote;
import br.com.modelos.Departamento;
import br.com.modelos.EstoquePaulista;
import br.com.modelos.Produto;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ProdutoController {

    @EJB
    private ProdutoRemote produtoFacade;

    public ProdutoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (ProdutoRemote) ctx.lookup("ejb/CadastroProdutoBean");
    }

    public void create(Produto entity) {
        produtoFacade.create(entity);
    }

    public void edit(Produto entity) {
        produtoFacade.edit(entity);
    }
    
    public void remove(Produto entity) {
        produtoFacade.remove(entity);
    }
    
    public List<Produto> findAll() {
        return (produtoFacade.findAll());
    }
    
        public Produto find(Object id) {
        return (produtoFacade.find(id));
    }
        
}
