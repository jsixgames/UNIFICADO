package br.com.modelos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Item_Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int qtd;
    private double preco_unidade;
    private double preco_total;
    @OneToOne(cascade= CascadeType.DETACH,fetch= FetchType.EAGER)    
    private Produto produto;

    public Item_Pedido() {
    }        

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco_unidade() {
        return preco_unidade;
    }

    public void setPreco_unidade(double preco_unidade) {
        this.preco_unidade = preco_unidade;
    }

    public double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item_Pedido)) {
            return false;
        }
        Item_Pedido other = (Item_Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quantidade: " + this.qtd + "<br>" +
               "Nome: " + this.produto.getNome() + "<br>" +
               "preco unitario: " + this.preco_unidade + "<br>" +
               "preco total: " + this.preco_total + "<br>";
    }
    
}
