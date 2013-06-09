/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.com.interfaces.ItensVendaPaulistaRemote;
import br.com.modelos.ItensVendaPaulista;
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
    private ItensVendaPaulistaRemote produtoFacade;

    public ItensVendaController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (ItensVendaPaulistaRemote) ctx.lookup("ejb/CadastroItensVendaPaulistaBean");
    }

    public void create(ItensVendaPaulista entity) {
        produtoFacade.create(entity);
    }

    public void edit(ItensVendaPaulista entity) {
        produtoFacade.edit(entity);
    }
    
    public void remove(ItensVendaPaulista entity) {
        produtoFacade.remove(entity);
    }
    
    public List<ItensVendaPaulista> findAll() {
        return (produtoFacade.findAll());
    }
    
        public ItensVendaPaulista find(Object id) {
        return (produtoFacade.find(id));
    }
}
