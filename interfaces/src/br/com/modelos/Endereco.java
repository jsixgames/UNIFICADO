
package br.com.modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_end;
    private String descricao;
    private String cep;
    private String endereco;        
    private String cidade;                   
    
    public Endereco() {
    }    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }   
    
    public Long getId() {
        return id_end;
    }

    public void setId(Long id) {
        this.id_end = id;
    }       
  
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_end != null ? id_end.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id_end == null && other.id_end != null) || (this.id_end != null && !this.id_end.equals(other.id_end))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "<tr>"+
                "<td id='listaclientelinhas'>"+id_end+"</td>"+
                "<td id='listaclientelinhas'>"+descricao+"</td>"+
                "<td id='listaclientelinhas'>"+cep+"</td>"+
                "<td id='listaclientelinhas'>"+endereco+"</td>"+
                "<td id='listaclientelinhas'>"+cidade+"</td>"+   
                "</tr>";
    }
    
}
