package br.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.model.Contato;
import br.com.service.ContatoService;

@Controller
@RequestMapping("/contatos")
public class ContatosController {
	
	@Autowired
	private ContatoService service;
	
	@GetMapping
	public ModelAndView listar() {
		List<Contato> lista = service.list();
		
		ModelAndView modelAndView = new ModelAndView("pages/contato/contatos");		
		modelAndView.addObject("contatos", lista);
		
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("pages/contato/novo_contato");
		mv.addObject("contato", new Contato());
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid @RequestBody Contato contato, BindingResult result){
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			return novo();
		}
		this.service.save(contato);
		return mv;
	}
}