/**
 * 
 */
package br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Cliente;

/**
 * @author natancardosodev
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public List<Cliente> findByNomeContaining(String nome);

}
