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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author natancardosodev
 *
 */
@Entity
public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String matricula;
	
	@OneToOne
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="funcionario")
	private List<Telefone> telefones;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="funcionario")
	private List<Email> emails;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="funcionario")
	private List<Departamento> departamento;
	
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
	 * @return matricula para acessar
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula para modificar
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	 * @return departamento para acessar
	 */
	public List<Departamento> getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento para modificar
	 */
	public void setDepartamento(List<Departamento> departamento) {
		this.departamento = departamento;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
