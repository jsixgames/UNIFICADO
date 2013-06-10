/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tabelas;

/**
 *
 * @author jeckson
 */

import br.com.modelos.Pedido;
import javax.swing.table.AbstractTableModel;
import java.util.List;


public class TabelaPedido extends AbstractTableModel {   
    private static final int COD_PED = 0;   
    private static final int DATA_PED = 1;
    private static final int FORMA_PED = 2;
    private static final int PRAZO_PED = 3;
    private static final int STATUS_PED = 4;
    private static final int TOTAL_PED = 5;
    
  
    private List<Pedido> valores;         
  
    //Esse é um construtor, que recebe a nossa lista de livros   
    public TabelaPedido(List<Pedido> valores) {
          this.valores = valores;   
    }   
  
    @Override
    public int getRowCount() {   
        //Quantas linhas tem sua tabela? Uma para cada item da lista.   
        return valores.size();   
    }   
  
    @Override
    public int getColumnCount() {   
        //Quantas colunas tem a tabela? Nesse exemplo, só 2.   
        return 6;   
    }   
  
    
    @Override
    public String getColumnName(int column) {   
        //Qual é o nome das nossas colunas?   
        if (column == COD_PED) 
            return "codigo";   
        if (column == DATA_PED) 
            return "Data";
        if (column == FORMA_PED) 
            return "Forma";
        if (column == PRAZO_PED) 
            return "Prazo";
        if (column == STATUS_PED) 
            return "Status";
        if (column == TOTAL_PED) 
            return "Total";
        return ""; //Nunca deve ocorrer   
    }   
  
    @Override
    public Object getValueAt(int row, int column) {   
        //Precisamos retornar o valor da coluna column e da linha row.   
        Pedido titulo = valores.get(row);   
        if (column == COD_PED) 
            return titulo.getId();   
        else if (column == DATA_PED) 
            return titulo.getData_pedido(); 
        else if (column == FORMA_PED) 
            return titulo.getForma_pagamento(); 
        else if (column == PRAZO_PED) 
            return titulo.getPrazo_entrega(); 
        else if (column == STATUS_PED) 
            return titulo.getStatus_pedido(); 
        else if (column == TOTAL_PED) 
            return titulo.getTotal_pedido(); 
        return ""; //Nunca deve ocorrer   
    }   
  
    public void setValueAt(Pedido aValue, int rowIndex, int columnIndex) {   
        Pedido titulo = valores.get(rowIndex);   
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.   
        //Note que vc poderia alterar 2 campos ao invés de um só.   
        if (columnIndex== COD_PED) 
            titulo.setId(aValue.getId());   
        else if (columnIndex== DATA_PED) 
            titulo.setData_pedido(aValue.getData_pedido());   
        else if (columnIndex== FORMA_PED) 
            titulo.setForma_pagamento(aValue.getForma_pagamento());   
        else if (columnIndex== PRAZO_PED) 
            titulo.setPrazo_entrega(aValue.getPrazo_entrega());
        else if (columnIndex== STATUS_PED) 
            titulo.setStatus_pedido(aValue.getStatus_pedido());   
        else if (columnIndex== TOTAL_PED) 
            titulo.setTotal_pedido(aValue.getTotal_pedido());   
       
    }   
  
    @Override
    public Class<?> getColumnClass(int columnIndex) {   
        //Qual a classe das nossas colunas? Como estamos exibindo texto, é string.   
        return String.class;   
    }   
       
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {   
        //Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda é.   
        return true;   
    }   
    //Já que esse tableModel é de livros, vamos fazer um get que retorne um livro inteiro.   
    //Isso elimina a necessidade de chamar o getValueAt() nas telas.   
    public Pedido get(int row) {   
        return valores.get(row);   
    }   
    
    
}  
