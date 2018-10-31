/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dto.ClientePesquisaDTO;
import br.com.model.Cliente;
import br.com.repository.ClienteRepository;


/**
 * @author natancardosodev
 *
 */
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Transactional(readOnly=true)
	public List<Cliente> list(){
		return this.repository.findAll();
	}
	
	@Transactional(readOnly=true)
	public String pesquisaVazia(){
		return "Não encontrado";
	}
	
	@Transactional
	public void save(Cliente cliente) {
		this.repository.save(cliente);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Cliente getById(Long id) {
		return this.repository.findOne(id);
	}
	
	public List<Cliente> filtrar(ClientePesquisaDTO cliente) {
		String email = cliente.getEmail() == null ? "%" : cliente.getEmail()+"%";
		return repository.findByNomeContaining(email);
	}

}