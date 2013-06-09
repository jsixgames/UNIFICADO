/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;


import br.com.interfaces.EstoquePaulistaRemote;
import br.com.modelos.EstoquePaulista;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class EstoquePaulistaController {

    @EJB
    private EstoquePaulistaRemote produtoFacade;

    public EstoquePaulistaController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (EstoquePaulistaRemote) ctx.lookup("ejb/CadastroEstoquePaulistaBean");
    }

    public void create(EstoquePaulista entity) {
        produtoFacade.create(entity);
    }

    public void edit(EstoquePaulista entity) {
        produtoFacade.edit(entity);
    }
    
    public void remove(EstoquePaulista entity) {
        produtoFacade.remove(entity);
    }
    
    public List<EstoquePaulista> findAll() {
        return (produtoFacade.findAll());
    }
    
    public EstoquePaulista find(Object id) {
        return (produtoFacade.find(id));
    }

}
