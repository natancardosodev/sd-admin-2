/**
 * 
 */
package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Telefone;

/**
 * @author natancardosodev
 *
 */
public interface TelefoneRepository extends JpaRepository<Telefone,Long>{

}
