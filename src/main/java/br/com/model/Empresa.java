/**
 * 
 */
package br.com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author natancardosodev
 *
 */
@Entity
public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="empresa")
	private List<Contato> contatos;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="empresa")
	private List<Telefone> telefones;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="empresa")
	private List<Departamento> departamentos;
	
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
	 * @return telefones para acessar
	 */
	public List<Telefone> getTelefones() {
		return telefones;
	}

	/**
	 * @param telefones para modificar
	 */
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	/**
	 * @return departamentos para acessar
	 */
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	/**
	 * @param departamentos para modificar
	 */
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	/**
	 * @return endereco para acessar
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco para modificar
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
