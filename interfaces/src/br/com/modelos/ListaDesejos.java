package br.com.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ListaDesejos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_lista;
    @OneToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private List<Produto> produto;

    public ListaDesejos() {
    }   
    
    public Long getId() {
        return id_lista;
    }

    public void setId(Long id) {
        this.id_lista = id;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
        

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_lista != null ? id_lista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaDesejos)) {
            return false;
        }
        ListaDesejos other = (ListaDesejos) object;
        if ((this.id_lista == null && other.id_lista != null) || (this.id_lista != null && !this.id_lista.equals(other.id_lista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.modelos.ListaDesejos[ id=" + id_lista + " ]";
    }
    
}
