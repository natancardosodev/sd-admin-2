package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Usuario;

/**
 * @author natancardosodev
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario,String> {
	
	Usuario findByLogin(String login);

}
