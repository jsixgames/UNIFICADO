/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tabelas;

/**
 *
 * @author jeckson
 */
import br.com.modelos.ItensVendaPaulista;
import java.text.DecimalFormat;
import javax.swing.table.AbstractTableModel;
import java.util.List;


public class TabelaItensVendas extends AbstractTableModel {   
    private static final int COD_PROD = 0;   
    private static final int NOME_PROD = 1;
    private static final int PRECO_PROD = 2;
    private static final int QTD_PROD = 3;
    private static final int P_FINAL_PROD = 4;
    private static final int DATAVENDA = 5;
    
  
    private List<ItensVendaPaulista> valores;         
  
    //Esse é um construtor, que recebe a nossa lista de livros   
    public TabelaItensVendas(List<ItensVendaPaulista> valores) {
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
        if (column == COD_PROD) 
            return "codigo";   
        if (column == NOME_PROD) 
            return "Nome";
        if (column == PRECO_PROD) 
            return "Preco";
        if (column == P_FINAL_PROD) 
            return "Preço final";
        if (column == QTD_PROD) 
            return "Quantidade";
        if (column == DATAVENDA) 
            return "Data Venda";
        return ""; //Nunca deve ocorrer   
    }   
  
    @Override
    public Object getValueAt(int row, int column) {   
        //Precisamos retornar o valor da coluna column e da linha row.   
        ItensVendaPaulista titulo = valores.get(row);   
        if (column == COD_PROD) 
            return titulo.getId();   
        else if (column == NOME_PROD) 
            return titulo.getNomeProd(); 
        else if (column == PRECO_PROD) 
            return titulo.getPrecoProd(); 
        else if (column == P_FINAL_PROD) 
            return titulo.getPrecoPinal(); 
        else if (column == QTD_PROD) 
            return titulo.getQtd(); 
        else if (column == DATAVENDA) 
            return titulo.getDataVenda(); 
        return ""; //Nunca deve ocorrer   
    }   
  
    public void setValueAt(ItensVendaPaulista aValue, int rowIndex, int columnIndex) {   
        ItensVendaPaulista titulo = valores.get(rowIndex);
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.   
        //Note que vc poderia alterar 2 campos ao invés de um só.   
        if (columnIndex== COD_PROD) 
            titulo.setId(aValue.getId());   
        else if (columnIndex== NOME_PROD) 
            titulo.setNomeProd(aValue.getNomeProd());   
        else if (columnIndex== PRECO_PROD) 
            titulo.setPrecoProd(aValue.getPrecoProd());   
        else if (columnIndex== P_FINAL_PROD)
            titulo.setPrecoPinal(aValue.getPrecoPinal());
        else if (columnIndex== QTD_PROD) 
            titulo.setQtd(aValue.getQtd());  
        else if (columnIndex== QTD_PROD) 
            titulo.setDataVenda(aValue.getDataVenda());  
       
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
    public ItensVendaPaulista get(int row) {   
        return valores.get(row);   
    }   
    
    
}  
