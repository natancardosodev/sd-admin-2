/**
 * 
 */
package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dto.FuncionarioPesquisaDTO;
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
	
	@Transactional(readOnly=true)
	public String pesquisaVazia(){
		return "Não encontrado";
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
	
	public List<Funcionario> filtrar(FuncionarioPesquisaDTO funcionario) {
		String nome = funcionario.getNome() == null ? "%" : funcionario.getNome()+"%";
		return repository.findByNomeContaining(nome);
	}
	
	@Transactional
	public boolean ativarDesativar(Long id) {
		
		boolean ativou = false;
		
		Funcionario funcionario = this.repository.getOne(id);
		if(funcionario.isAtivo()) {
			funcionario.setAtivo(false);
			return ativou;
		}else {
			funcionario.setAtivo(true);
			ativou = true;
		}
		return ativou;
	}
	
	public boolean ativaDesativarFuncionario(Funcionario funcionario) {
		if (funcionario.isAtivo()) {
			ativaDesativaUsuario(funcionario);
		} else {
			ativaDesativaUsuario(funcionario);
		}
		return false;
	}
	
	@Transactional
	private void ativaDesativaUsuario(Funcionario funcionario) {
		if (funcionario.isAtivo()) {
			funcionario.setAtivo(false);
		} else {
			funcionario.setAtivo(true);
		}
		this.repository.saveAndFlush(funcionario);
	}

}