/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Contato;
import br.com.model.Empresa;
import br.com.model.Fornecedor;
import br.com.repository.ContatoRepository;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;
	
	@Transactional(readOnly=true)
	public List<Contato> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Contato contato) {
		this.repository.save(contato);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Contato getById(Long id) {
		return this.repository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public List<Empresa> listarEmpresas(){
		return this.repository.findByEmpresas();
	}
	
	@Transactional(readOnly=true)
	public List<Fornecedor> listarFornecedores(){
		return this.repository.findByFornecedor();
	}
	
}
