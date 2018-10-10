/**
 * 
 */
package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Empresa;

/**
 * @author natancardosodev
 *
 */
public interface EmpresaRepository extends JpaRepository<Empresa,Long>{

}
