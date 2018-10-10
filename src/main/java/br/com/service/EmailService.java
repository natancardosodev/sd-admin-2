/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Email;
import br.com.repository.EmailRepository;

/**
 * @author natancardosodev
 *
 */
@Service
public class EmailService {
	
	@Autowired
	private EmailRepository repository;
	
	@Transactional(readOnly=true)
	public List<Email> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Email email) {
		this.repository.save(email);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Email getById(Long id) {
		return this.repository.findOne(id);
	}

}
