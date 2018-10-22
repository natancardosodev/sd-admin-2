package br.com.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Não será produzido nesse fork: dashboard ou tela de login
 * @author natancardosodev
 *
 */
//@Controller
//@RequestMapping
public class HomeController {

//	@GetMapping("/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("admin/home");
		return mv;
	}
}
