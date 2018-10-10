/**
 * 
 */
package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Departamento;

/**
 * @author natancardosodev
 *
 */
public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {

}
