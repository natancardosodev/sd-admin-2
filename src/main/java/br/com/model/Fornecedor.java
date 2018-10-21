/**
 * 
 */
package br.com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author natancardosodev
 *
 */
@Entity
public class Fornecedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="fornecedor")
	private List<Contato> contatos;
	
	private String endereco;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="fornecedor")
	private List<Email> emails;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="fornecedor")
	private List<Produto> produtos;

	/**
	 * @return id para acessar
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id para modificar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return nome para acessar
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome para modificar
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return telefone para acessar
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone para modificar
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return contatos para acessar
	 */
	public List<Contato> getContatos() {
		return contatos;
	}

	/**
	 * @param contatos para modificar
	 */
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	/**
	 * @return endereco para acessar
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco para modificar
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return emails para acessar
	 */
	public List<Email> getEmails() {
		return emails;
	}

	/**
	 * @param emails para modificar
	 */
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	/**
	 * @return produtos para acessar
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos para modificar
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
