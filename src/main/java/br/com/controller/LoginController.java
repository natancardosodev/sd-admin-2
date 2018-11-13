package br.com.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.model.Usuario;

/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public ModelAndView novo(Usuario usuario) {
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("usuario", usuario);
		
        return new ModelAndView("/login",dados);
	}
	
	@PostMapping("/signin")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, 
			Model model, RedirectAttributes attributes){
		
		if(usuario.getLogin().equals("natan") && usuario.getSenha().equals("admin")) {
			ModelAndView mv = new ModelAndView("redirect:/contatos");
			attributes.addFlashAttribute("mensagem", "Seja bem-vindo!");
			
			return mv;
		} else {
			
			return novo(usuario);
		}
		
	}
	
}