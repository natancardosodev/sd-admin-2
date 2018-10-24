/**
 * 
 */
package br.com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author natancardosodev
 *
 */
@Entity
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String rua;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="endereco",fetch = FetchType.LAZY,optional = true)
	private Empresa empresa;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="endereco",fetch = FetchType.LAZY,optional = true)
	private Funcionario funcionario;
	
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
	 * @return rua para acessar
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua para modificar
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return bairro para acessar
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro para modificar
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return cidade para acessar
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade para modificar
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return estado para acessar
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado para modificar
	 */
	public void setEstado(String estado) {
		this.estado = estado;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
