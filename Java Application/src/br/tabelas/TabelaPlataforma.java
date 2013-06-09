/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tabelas;

/**
 *
 * @author jeckson
 */

import br.com.modelos.Departamento;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;


public class TabelaPlataforma extends AbstractTableModel {   
    private static final int COD_PLAT = 0;   
    private static final int NOME_PLAT = 1;
  
    private List<Departamento> valores;         
  
    //Esse é um construtor, que recebe a nossa lista de livros   
    public TabelaPlataforma(List<Departamento> valores) {
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
        return 2;   
    }   
  
    
    @Override
    public String getColumnName(int column) {   
        //Qual é o nome das nossas colunas?   
        if (column == COD_PLAT) 
            return "codigo";   
        if (column == NOME_PLAT) 
            return "Plataforma";
        return ""; //Nunca deve ocorrer   
    }   
  
    @Override
    public Object getValueAt(int row, int column) {   
        //Precisamos retornar o valor da coluna column e da linha row.   
        Departamento titulo = valores.get(row);   
        if (column == COD_PLAT) 
            return titulo.getId();   
        else if (column == NOME_PLAT) 
            return titulo.getNome(); 
        return ""; //Nunca deve ocorrer   
    }   
  
    public void setValueAt(Departamento aValue, int rowIndex, int columnIndex) {   
        Departamento titulo = valores.get(rowIndex);   
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.   
        //Note que vc poderia alterar 2 campos ao invés de um só.   
        if (columnIndex== COD_PLAT) 
            titulo.setId(aValue.getId());   
        else if (columnIndex== NOME_PLAT) 
            titulo.setNome(aValue.getNome());   
       
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
    public Departamento get(int row) {   
        return valores.get(row);   
    }   
}  
