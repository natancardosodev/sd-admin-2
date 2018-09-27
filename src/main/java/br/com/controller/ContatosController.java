package br.com.controller;

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
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/contatos");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Contato removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Contato contato = this.service.getById(id); 
		System.out.println(contato.getNome());
		return novo(contato);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Contato contato) {
		ModelAndView mv = new ModelAndView("pages/contato/novo_contato");
		mv.addObject("contato", contato);
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Contato contato, BindingResult result, Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/contatos");
		
		if (result.hasErrors()) {
			return novo(contato);
		}

		attributes.addFlashAttribute("mensagem", "Contato salvo com sucesso");
		this.service.save(contato);
		return mv;
	}
}