package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Contato;

public interface ContatosRepository extends JpaRepository<Contato, Long> {

}
