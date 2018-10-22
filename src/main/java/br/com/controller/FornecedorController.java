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

import br.com.model.Fornecedor;
import br.com.service.FornecedorService;
/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService service;
	
	@GetMapping
	public ModelAndView listar() {
		List<Fornecedor> lista = service.list();
		
		ModelAndView mv = new ModelAndView("pages/fornecedor/fornecedores");		
		mv.addObject("fornecedores", lista);
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/fornecedores");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Fornecedor removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Fornecedor fornecedor = this.service.getById(id); 

		return novo(fornecedor);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Fornecedor fornecedor) {
		ModelAndView mv = new ModelAndView("pages/fornecedor/novo");
		mv.addObject("fornecedor", fornecedor);
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Fornecedor fornecedor, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/fornecedores");
		
		if (result.hasErrors()) {
			return novo(fornecedor);
		}

		attributes.addFlashAttribute("mensagem", "Fornecedor salvo com sucesso!");
		this.service.save(fornecedor);
		return mv;
	}
}