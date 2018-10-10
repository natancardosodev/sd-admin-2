/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Funcionario;
import br.com.repository.FuncionarioRepository;


/**
 * @author natancardosodev
 *
 */
@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	@Transactional(readOnly=true)
	public List<Funcionario> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Funcionario funcionario) {
		this.repository.save(funcionario);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Funcionario getById(Long id) {
		return this.repository.findOne(id);
	}

}
