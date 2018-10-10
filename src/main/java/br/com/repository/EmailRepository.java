/**
 * 
 */
package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Email;

/**
 * @author natancardosodev
 *
 */
public interface EmailRepository extends JpaRepository<Email, Long>{

}

