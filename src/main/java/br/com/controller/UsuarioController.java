package br.com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.model.User;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@GetMapping
	public ModelAndView allUser(){
		return new ModelAndView("pages/usuario/usuarios");
	}
	
	@GetMapping("/novo")
	public ModelAndView newUser(User usuario){
		ModelAndView mv = new ModelAndView("pages/usuario/novo_usuario");
        mv.addObject("usuario", usuario);
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView saveUser(@Valid User usuario, BindingResult result,RedirectAttributes attributes){
		if (result.hasErrors()) {
			return newUser(usuario);
		}
		
		//Adiciona o usuário aqui ...
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso");
		
		return new ModelAndView("redirect:/usuarios");
	}
}
