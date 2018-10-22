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

import br.com.model.Email;
import br.com.service.EmailService;
/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/emails")
public class EmailController {
	
	@Autowired
	private EmailService service;
	
	@GetMapping
	public ModelAndView listar() {
		List<Email> lista = service.list();
		
		ModelAndView mv = new ModelAndView("pages/email/emails");		
		mv.addObject("emails", lista);
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/emails");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Email removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Email email = this.service.getById(id); 

		return novo(email);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Email email) {
		ModelAndView mv = new ModelAndView("pages/email/novo");
		mv.addObject("email", email);
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Email email, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/emails");
		
		if (result.hasErrors()) {
			return novo(email);
		}

		attributes.addFlashAttribute("mensagem", "Email salvo com sucesso!");
		this.service.save(email);
		return mv;
	}
}