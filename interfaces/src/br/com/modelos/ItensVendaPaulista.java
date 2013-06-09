package br.com.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;


@Entity
public class ItensVendaPaulista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idProd;
    private String nomeProd;
    private double precoProd;
    private int qtd;
    private double precoPinal;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataVenda;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public double getPrecoPinal() {
        return precoPinal;
    }

    public void setPrecoPinal(double precoPinal) {
        this.precoPinal = precoPinal;
    }

    public Date getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(Date DataVenda) {
        this.DataVenda = DataVenda;
    }

    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    
    

    public double getPrecoProd() {
        return precoProd;
    }

    public void setPrecoProd(double precoProd) {
        this.precoProd = precoProd;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.idProd);
        hash = 73 * hash + Objects.hashCode(this.nomeProd);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.precoProd) ^ (Double.doubleToLongBits(this.precoProd) >>> 32));
        hash = 73 * hash + this.qtd;
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.precoPinal) ^ (Double.doubleToLongBits(this.precoPinal) >>> 32));
        hash = 73 * hash + Objects.hashCode(this.DataVenda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItensVendaPaulista other = (ItensVendaPaulista) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idProd, other.idProd)) {
            return false;
        }
        if (!Objects.equals(this.nomeProd, other.nomeProd)) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoProd) != Double.doubleToLongBits(other.precoProd)) {
            return false;
        }
        if (this.qtd != other.qtd) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoPinal) != Double.doubleToLongBits(other.precoPinal)) {
            return false;
        }
        if (!Objects.equals(this.DataVenda, other.DataVenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItensVenda{" + "id=" + id + ", idProd=" + idProd + ", nomeProd=" + nomeProd + ", precoProd=" + precoProd + ", qtd=" + qtd + ", precoPinal=" + precoPinal + ", DataVenda=" + DataVenda + '}';
    }

    
    


    
    
 

    
    
}
