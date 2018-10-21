/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Produto;
import br.com.repository.ProdutoRepository;

/**
 * @author natancardosodev
 *
 */
@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Transactional(readOnly=true)
	public List<Produto> list() {
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Produto produto) {
		this.repository.save(produto);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Produto getById(Long id) {
		return this.repository.findOne(id);
	}

}
