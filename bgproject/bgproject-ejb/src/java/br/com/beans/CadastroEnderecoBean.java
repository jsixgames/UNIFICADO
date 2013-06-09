package br.com.beans;

import br.com.interfaces.EnderecoRemote;
import br.com.modelos.Endereco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/CadastroEnderecoBean")
public class CadastroEnderecoBean extends AbstractFacade<Endereco> implements EnderecoRemote{
    
    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadastroEnderecoBean() {
        super(Endereco.class);
    }         
    
  }