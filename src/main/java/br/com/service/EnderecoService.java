/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Endereco;
import br.com.repository.EnderecoRepository;

/**
 * @author natancardosodev
 *
 */
@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	@Transactional(readOnly=true)
	public List<Endereco> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Endereco endereco) {
		this.repository.save(endereco);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Endereco getById(Long id) {
		return this.repository.findOne(id);
	}

}
