/**
 * 
 */
package br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author natancardosodev
 *
 */
@Entity
public class Email implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@ManyToOne
	private Contato contato;
	
	@ManyToOne
	private Funcionario funcionario;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
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
	 * @return descricao para acessar
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao para modificar
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return contato para acessar
	 */
	public Contato getContato() {
		return contato;
	}

	/**
	 * @param contato para modificar
	 */
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	/**
	 * @return funcionario para acessar
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario para modificar
	 */
	public void setFuncionario(Funcionario funcionario) {
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

	/**
	 * @return fornecedor para acessar
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * @param fornecedor para modificar
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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
		Email other = (Email) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
