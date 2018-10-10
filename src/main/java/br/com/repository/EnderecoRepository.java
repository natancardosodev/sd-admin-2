/**
 * 
 */
package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Endereco;

/**
 * @author natancardosodev
 *
 */
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
	
}
