package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.model.Contato;
import br.com.service.ContatoService;

/**
 * Não será produzido nesse fork: dashboard ou tela de login
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping
public class HomeController {
	
	@Autowired
	private ContatoService service;

	@GetMapping("/")
	public ModelAndView index(){
		List<Contato> lista = service.list();
		
		ModelAndView mv = new ModelAndView("redirect:/contatos");		
		mv.addObject("contatos", lista);
		
		return mv;
	}
}
