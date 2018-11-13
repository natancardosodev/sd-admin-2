package br.com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//import org.springframework.security.core.GrantedAuthority;

/**
 * @author natancardosodev
 *
 */
@Entity
//public class Permissao implements GrantedAuthority, Serializable{
public class Permissao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String nomePermissao;

	@ManyToMany(mappedBy = "permissoes")
    private List<Usuario> usuarios;
	
	public String getNomePermissao() {
		return nomePermissao;
	}

	public void setNomePermissao(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

//	@Override
//	public String getAuthority() {
//		return this.nomePermissao;
//	}
	
}