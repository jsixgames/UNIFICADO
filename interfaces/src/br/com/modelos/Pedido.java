package br.com.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double total_pedido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_pedido;
    private String status_pedido;
    private int prazo_entrega;
    private String forma_pagamento;
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinTable(name = "Pedidos_Items",joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))  
    private List<Item_Pedido> item = new ArrayList<>();
    

    public Pedido() {
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }        

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(String status_pedido) {
        this.status_pedido = status_pedido;
    }

    public int getPrazo_entrega() {
        return prazo_entrega;
    }

    public void setPrazo_entrega(int prazo_entrega) {
        this.prazo_entrega = prazo_entrega;
    }        

    public List<Item_Pedido> getItem() {
        return item;
    }

    public void setItem(List<Item_Pedido> item) {
        this.item = item;
    }        

    public double getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(double total_pedido) {
        this.total_pedido = total_pedido;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.modelos.Pedido[ id=" + id + " ]";
    }
    
}
