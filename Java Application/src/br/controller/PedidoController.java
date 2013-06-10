/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.com.interfaces.PedidoRemote;
import br.com.modelos.Pedido;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PedidoController {

    @EJB
    private PedidoRemote produtoFacade;

    public PedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (PedidoRemote) ctx.lookup("ejb/PedidoBean");
    }

    public void create(Pedido entity) {
        produtoFacade.create(entity);
    }

    public void edit(Pedido entity) {
        produtoFacade.edit(entity);
    }
    
    public void remove(Pedido entity) {
        produtoFacade.remove(entity);
    }
    
    public List<Pedido> findAll() {
        return (produtoFacade.findAll());
    }
    
        public Pedido find(Object id) {
        return (produtoFacade.find(id));
    }
        
}
