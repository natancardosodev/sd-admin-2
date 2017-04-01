package br.com.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contatos.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long> {

}
