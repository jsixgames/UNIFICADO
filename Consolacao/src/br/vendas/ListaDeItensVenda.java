/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vendas;

import br.com.modelos.ItensVendaConsolacao;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeckson Sacramento Bernardino
 */
public class ListaDeItensVenda {
    
    private static List<ItensVendaConsolacao> listaItensVenda = new ArrayList<ItensVendaConsolacao>();
    
    private ListaDeItensVenda(){
        
    
    
    }
    
    public static void insereLista(ItensVendaConsolacao item){
        listaItensVenda.add(item);
    }
    
    public static void removeLista(int item){
        listaItensVenda.remove(item);
    }
    
    public static List<ItensVendaConsolacao> getListaItensVenda(){
        List<ItensVendaConsolacao> lista = listaItensVenda;
        return lista;
    }
    
    public static void iniciaLista(){
        listaItensVenda = new ArrayList<ItensVendaConsolacao>();
    }
    
}
