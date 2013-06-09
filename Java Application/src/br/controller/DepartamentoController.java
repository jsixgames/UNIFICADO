/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.com.interfaces.DepartamentoRemote;
import br.com.modelos.Departamento;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class DepartamentoController {
     
    @EJB 
    private DepartamentoRemote consoleFacade;

    public DepartamentoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext();
        consoleFacade = (DepartamentoRemote) ctx.lookup("ejb/CadastroDepartamentoBean");
    }

    public void create(Departamento entity) {
        consoleFacade.create(entity);
    }

    public void edit(Departamento entity) {
        consoleFacade.edit(entity);
    }
    
    public void remove(Departamento entity) {
        consoleFacade.remove(entity);
    }
    
    public List<Departamento> findAll() {
        return (consoleFacade.findAll());
    }
    
    public Departamento find(Object id) {
        return (consoleFacade.find(id));
    }
    
}
