/**
 * 
 */
package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Permissao;

/**
 * @author natancardosodev
 *
 */
public interface PermissaoRepository extends JpaRepository<Permissao,String>{

}
