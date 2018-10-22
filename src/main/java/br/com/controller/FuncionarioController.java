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

import br.com.model.Funcionario;
import br.com.service.FuncionarioService;
/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public ModelAndView listar() {
		List<Funcionario> lista = service.list();
		
		ModelAndView mv = new ModelAndView("pages/funcionario/funcionarios");		
		mv.addObject("funcionarios", lista);
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/funcionarios");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Funcionario removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Funcionario funcionario = this.service.getById(id); 

		return novo(funcionario);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("pages/funcionario/novo");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/funcionarios");
		
		if (result.hasErrors()) {
			return novo(funcionario);
		}

		attributes.addFlashAttribute("mensagem", "Funcionario salvo com sucesso!");
		this.service.save(funcionario);
		return mv;
	}
}