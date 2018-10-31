/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dto.FornecedorPesquisaDTO;
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
	
	public List<Fornecedor> filtrar(FornecedorPesquisaDTO fornecedor) {
		String nome = fornecedor.getNome() == null ? "%" : fornecedor.getNome()+"%";
		return repository.findByNomeContaining(nome);
	}
	
	@Transactional
	public boolean ativarDesativar(Long id) {
		
		boolean ativou = false;
		
		Fornecedor fornecedor = this.repository.getOne(id);
		if(fornecedor.isAtivo()) {
			fornecedor.setAtivo(false);
			return ativou;
		}else {
			fornecedor.setAtivo(true);
			ativou = true;
		}
		return ativou;
	}
	
	public boolean ativaDesativarFornecedor(Fornecedor fornecedor) {
		if (fornecedor.isAtivo()) {
			ativaDesativaUsuario(fornecedor);
		} else {
			ativaDesativaUsuario(fornecedor);
		}
		return false;
	}
	
	@Transactional
	private void ativaDesativaUsuario(Fornecedor fornecedor) {
		if (fornecedor.isAtivo()) {
			fornecedor.setAtivo(false);
		} else {
			fornecedor.setAtivo(true);
		}
		this.repository.saveAndFlush(fornecedor);
	}

}
