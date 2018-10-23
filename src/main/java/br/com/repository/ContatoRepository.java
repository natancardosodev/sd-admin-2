package br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.model.Contato;
import br.com.model.Empresa;
import br.com.model.Fornecedor;

/**
 * @author natancardosodev
 *
 */
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	@Query(name="findByEmpresas",value="SELECT e FROM Empresa e")
	public List<Empresa> findByEmpresas();
	
	@Query(name="findByFornecedor",value="SELECT nome FROM Fornecedor f")
	public List<Fornecedor> findByFornecedor();

}
