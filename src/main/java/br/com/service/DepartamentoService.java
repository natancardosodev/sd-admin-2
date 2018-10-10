/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Departamento;
import br.com.repository.DepartamentoRepository;

/**
 * @author natancardosodev
 *
 */
@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;
	
	@Transactional(readOnly=true)
	public List<Departamento> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Departamento departamento) {
		this.repository.save(departamento);
	}
	
	@Transactional
	public void remove(Long id){
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Departamento getById(Long id) {
		return this.repository.findOne(id);
	}

}
