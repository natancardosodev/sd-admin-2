/**
 * 
 */
package br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Fornecedor;

/**
 * @author natancardosodev
 *
 */
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long>{

	public List<Fornecedor> findByNomeContaining(String nome);
	
}
