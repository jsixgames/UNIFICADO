/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tabelas;

/**
 *
 * @author jeckson
 */

import br.com.modelos.Produto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;


public class TabelaProduto extends AbstractTableModel {   
    private static final int COD_PROD = 0;   
    private static final int NOME_PROD = 1;
    private static final int PRECO_PROD = 2;
    private static final int CATEG_PROD = 3;
    
  
    private List<Produto> valores;         
  
    //Esse é um construtor, que recebe a nossa lista de livros   
    public TabelaProduto(List<Produto> valores) {
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
        return 4;   
    }   
  
    
    @Override
    public String getColumnName(int column) {   
        //Qual é o nome das nossas colunas?   
        if (column == COD_PROD) 
            return "codigo";   
        if (column == NOME_PROD) 
            return "Nome";
        if (column == PRECO_PROD) 
            return "Preco";
        if (column == CATEG_PROD) 
            return "Categoria";
        return ""; //Nunca deve ocorrer   
    }   
  
    @Override
    public Object getValueAt(int row, int column) {   
        //Precisamos retornar o valor da coluna column e da linha row.   
        Produto titulo = valores.get(row);   
        if (column == COD_PROD) 
            return titulo.getId_prod();   
        else if (column == NOME_PROD) 
            return titulo.getNome(); 
        else if (column == PRECO_PROD) 
            return titulo.getPreco(); 
        else if (column == CATEG_PROD) 
            return titulo.getDepto(); 
        return ""; //Nunca deve ocorrer   
    }   
  
    public void setValueAt(Produto aValue, int rowIndex, int columnIndex) {   
        Produto titulo = valores.get(rowIndex);   
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.   
        //Note que vc poderia alterar 2 campos ao invés de um só.   
        if (columnIndex== COD_PROD) 
            titulo.setId_prod(aValue.getId_prod());   
        else if (columnIndex== NOME_PROD) 
            titulo.setNome(aValue.getNome());   
        else if (columnIndex== PRECO_PROD) 
            titulo.setPreco(aValue.getPreco());   
        else if (columnIndex== CATEG_PROD) 
            titulo.setDepto(aValue.getDepto());   
       
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
    public Produto get(int row) {   
        return valores.get(row);   
    }   
    
    
}  
