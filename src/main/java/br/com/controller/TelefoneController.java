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

import br.com.model.Telefone;
import br.com.service.TelefoneService;
/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/telefones")
public class TelefoneController {
	
	@Autowired
	private TelefoneService service;
	
	@GetMapping
	public ModelAndView listar() {
		List<Telefone> lista = service.list();
		
		ModelAndView mv = new ModelAndView("pages/telefone/telefones");		
		mv.addObject("telefones", lista);
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/telefones");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Telefone removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Telefone telefone = this.service.getById(id); 

		return novo(telefone);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Telefone telefone) {
		ModelAndView mv = new ModelAndView("pages/telefone/novo");
		mv.addObject("telefone", telefone);
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Telefone telefone, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/telefones");
		
		if (result.hasErrors()) {
			return novo(telefone);
		}

		attributes.addFlashAttribute("mensagem", "Telefone salvo com sucesso!");
		this.service.save(telefone);
		return mv;
	}
}