package br.com.modelos;

import java.io.Serializable;
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
import javax.persistence.OneToOne;

@Entity
public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String email;
    private String nome;   
    private String cpf;
    private String sexo;    
    private String senha;             
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinTable(name = "Clientes_Enderecos",joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_end"))  
    private List<Endereco> endereco;
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinTable(name = "Clientes_Pedidos",joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_pedido"))  
    private List<Pedido> pedido;    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ListaDesejos lista;

    public Cliente() {
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }        

    public ListaDesejos getLista() {
        return lista;
    }

    public void setLista(ListaDesejos lista) {
        this.lista = lista;
    }        

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id_cliente;
    }

    public void setId(Long id) {
        this.id_cliente = id;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "<tr>"+
                "<td id='listaclientelinhas'>"+id_cliente+"</td>"+
                "<td id='listaclientelinhas'>"+nome+"</td>"+
                "<td id='listaclientelinhas'>"+cpf+"</td>"+
                "<td id='listaclientelinhas'>"+sexo+"</td>"+
                "<td id='listaclientelinhas'>"+email+"</td>"+
                "<td id='listaclientelinhas'>"+senha+"</td>"+
                "</tr>";
    }
    
}
