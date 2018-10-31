/**
 * 
 */
package br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Funcionario;

/**
 * @author natancardosodev
 *
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
	
	public List<Funcionario> findByNomeContaining(String nome);

}
