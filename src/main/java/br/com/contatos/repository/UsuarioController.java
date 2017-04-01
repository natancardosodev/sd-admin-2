package br.com.contatos.repository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@GetMapping
	public String allUser(){
		return "pages/usuarios";
	}
}
