/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Telefone;
import br.com.repository.TelefoneRepository;

/**
 * @author natancardosodev
 *
 */
@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository repository;
	
	@Transactional(readOnly=true)
	public List<Telefone> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Telefone telefone) {
		this.repository.save(telefone);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Telefone getById(Long id) {
		return this.repository.findOne(id);
	}

}
