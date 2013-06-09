/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.com.interfaces.ItensVendaConsolacaoRemote;
import br.com.modelos.ItensVendaConsolacao;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;

/**
 *
 * @author Jeckson Sacramento Bernardino
 */
public class ItensVendaController {

    @EJB
    private ItensVendaConsolacaoRemote produtoFacade;

    public ItensVendaController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (ItensVendaConsolacaoRemote) ctx.lookup("ejb/CadastroItensVendaConcolacaoBean");
    }

    public void create(ItensVendaConsolacao entity) {
        produtoFacade.create(entity);
    }

    public void edit(ItensVendaConsolacao entity) {
        produtoFacade.edit(entity);
    }
    
    public void remove(ItensVendaConsolacao entity) {
        produtoFacade.remove(entity);
    }
    
    public List<ItensVendaConsolacao> findAll() {
        return (produtoFacade.findAll());
    }
    
        public ItensVendaConsolacao find(Object id) {
        return (produtoFacade.find(id));
    }
}
