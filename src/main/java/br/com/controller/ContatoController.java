package br.com.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.model.Contato;
import br.com.model.Empresa;
import br.com.model.Fornecedor;
import br.com.service.ContatoService;
import br.com.service.EmpresaService;
import br.com.service.FornecedorService;

@Controller
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService service;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping
	public ModelAndView listar() {
		List<Contato> lista = service.list();
		
		ModelAndView mv = new ModelAndView("pages/contato/contatos");		
		mv.addObject("contatos", lista);
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/contatos");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Contato removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Contato contato = this.service.getById(id); 

		return novo(contato);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Contato contato) {
		List<Empresa> empresas = empresaService.list();
		List<Fornecedor> fornecedor = fornecedorService.list();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("contato", contato);
        dados.put("empresas", empresas);
        dados.put("fornecedores", fornecedor);
        
        return new ModelAndView("pages/contato/novo",dados);
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Contato contato, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/contatos");
		
		if (result.hasErrors()) {
			return novo(contato);
		}

		attributes.addFlashAttribute("mensagem", "Contato salvo com sucesso!");
		this.service.save(contato);
		return mv;
	}
}