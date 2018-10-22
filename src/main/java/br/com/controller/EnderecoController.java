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

import br.com.model.Endereco;
import br.com.service.EnderecoService;
/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public ModelAndView listar() {
		List<Endereco> lista = service.list();
		
		ModelAndView mv = new ModelAndView("pages/endereco/enderecos");		
		mv.addObject("enderecos", lista);
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/enderecos");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Endereco removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Endereco endereco = this.service.getById(id); 

		return novo(endereco);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Endereco endereco) {
		ModelAndView mv = new ModelAndView("pages/endereco/novo");
		mv.addObject("endereco", endereco);
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Endereco endereco, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/enderecos");
		
		if (result.hasErrors()) {
			return novo(endereco);
		}

		attributes.addFlashAttribute("mensagem", "Endereco salvo com sucesso!");
		this.service.save(endereco);
		return mv;
	}
}