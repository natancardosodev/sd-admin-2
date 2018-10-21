/**
 * 
 */
package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Fornecedor;

/**
 * @author natancardosodev
 *
 */
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long>{

}
