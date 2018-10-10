/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Empresa;
import br.com.repository.EmpresaRepository;

/**
 * @author natancardosodev
 *
 */
@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;
	
	@Transactional(readOnly=true)
	public List<Empresa> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Empresa empresa) {
		this.repository.save(empresa);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Empresa getById(Long id) {
		return this.repository.findOne(id);
	}

}
