/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;


import br.com.interfaces.EstoqueConsolacaoRemote;
import br.com.modelos.EstoqueConsolacao;
import br.com.modelos.Produto;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class EstoqueConsolacaoController {

    @EJB
    private EstoqueConsolacaoRemote produtoFacade;

    public EstoqueConsolacaoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (EstoqueConsolacaoRemote) ctx.lookup("ejb/CadastroEstoqueConsolacaoBean");
    }

    public void create(EstoqueConsolacao entity) {
        produtoFacade.create(entity);
    }

    public void edit(EstoqueConsolacao entity) {
        produtoFacade.edit(entity);
    }
    
    public void remove(EstoqueConsolacao entity) {
        produtoFacade.remove(entity);
    }
    
    public List<EstoqueConsolacao> findAll() {
        return (produtoFacade.findAll());
    }
    
    public EstoqueConsolacao find(Object id) {
        return (produtoFacade.find(id));
    }

}
