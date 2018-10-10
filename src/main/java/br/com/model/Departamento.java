/**
 * 
 */
package br.com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author natancardosodev
 *
 */
@Entity
public class Departamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cod_dep")
	private Double codDepartamento;
	
	@ManyToMany
	private List<Contato> contato;
	
	@ManyToMany
	private List<Funcionario> funcionario;
	
	@ManyToOne
	private Empresa empresa;
	
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
	 * @return codDepartamento para acessar
	 */
	public Double getCodDepartamento() {
		return codDepartamento;
	}

	/**
	 * @param codDepartamento para modificar
	 */
	public void setCodDepartamento(Double codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	/**
	 * @return contato para acessar
	 */
	public List<Contato> getContato() {
		return contato;
	}

	/**
	 * @param contato para modificar
	 */
	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

	/**
	 * @return funcionario para acessar
	 */
	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario para modificar
	 */
	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
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
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
