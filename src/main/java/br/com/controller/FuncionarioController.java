package br.com.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import br.com.dto.FuncionarioPesquisaDTO;
import br.com.model.Endereco;
import br.com.model.Funcionario;
import br.com.service.EnderecoService;
import br.com.service.FuncionarioService;
/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public ModelAndView listar(@ModelAttribute("filtro") FuncionarioPesquisaDTO filtro) {
		ModelAndView mv = new ModelAndView("pages/funcionario/funcionarios");
		
		if(!StringUtils.isEmpty(filtro.getNome())) {
			List<Funcionario> funcionarios = this.service.filtrar(filtro);
			mv.addObject("funcionarios", funcionarios);
//		}else if(StringUtils.isEmpty(filtro.getNome())) {
//			mv.addObject("funcionarios", service.pesquisaVazia());
		}else {
			mv.addObject("funcionarios", service.list());
		}
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/funcionarios");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Funcionario removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Funcionario funcionario = this.service.getById(id); 

		return novo(funcionario);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Funcionario funcionario) {
		List<Endereco> enderecos = enderecoService.list();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("funcionario", funcionario);
		dados.put("enderecos", enderecos);
        
        return new ModelAndView("pages/funcionario/novo",dados);
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/funcionarios");
		
		if (result.hasErrors()) {
			return novo(funcionario);
		}

		attributes.addFlashAttribute("mensagem", "Funcionario salvo com sucesso!");
		this.service.save(funcionario);
		return mv;
	}
	
	@GetMapping("/ativar/{id}")
	public ModelAndView ativarDesativar(@PathVariable("id") Long id,RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/funcionarios");
		
		if(this.service.ativarDesativar(id)) {
			attributes.addFlashAttribute("ativadoDesativado", "Funcionario ativado com sucesso!");
		}else {
			attributes.addFlashAttribute("ativadoDesativado", "Funcionario desativado com sucesso!");
		}
		
		return mv;
	}
}