package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Produto;

/**
 * @author natancardosodev
 *
 */
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
