package br.com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Contato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="contato")
	private List<Telefone> telefones;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="contato")
	private List<Email> emails;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="contato")
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
	 * @return empresa para acessar
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa para modificar
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
