/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vendas;

import br.com.modelos.ItensVendaPaulista;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeckson Sacramento Bernardino
 */
public class ListaDeItensVenda {
    
    private static List<ItensVendaPaulista> listaItensVenda = new ArrayList<ItensVendaPaulista>();
    
    private ListaDeItensVenda(){
        
    
    
    }
    
    public static void insereLista(ItensVendaPaulista item){
        listaItensVenda.add(item);
    }
    
    public static void removeLista(int item){
        listaItensVenda.remove(item);
    }
    
    public static List<ItensVendaPaulista> getListaItensVenda(){
        List<ItensVendaPaulista> lista = listaItensVenda;
        return lista;
    }
    
    public static void iniciaLista(){
        listaItensVenda = new ArrayList<ItensVendaPaulista>();
    }
    
}
