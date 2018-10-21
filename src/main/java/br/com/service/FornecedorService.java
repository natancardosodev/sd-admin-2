/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Fornecedor;
import br.com.repository.FornecedorRepository;

/**
 * @author natancardosodev
 *
 */
@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository repository;
	
	@Transactional(readOnly=true)
	public List<Fornecedor> list() {
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Fornecedor fornecedor) {
		this.repository.save(fornecedor);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Fornecedor getById(Long id) {
		return this.repository.findOne(id);
	}

}
