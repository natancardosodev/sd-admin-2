package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Contato;

/**
 * @author natancardosodev
 *
 */
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
