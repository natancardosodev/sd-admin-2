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

import br.com.model.Empresa;
import br.com.service.EmpresaService;
/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	
	@GetMapping
	public ModelAndView listar() {
		List<Empresa> lista = service.list();
		
		ModelAndView mv = new ModelAndView("pages/empresa/empresas");		
		mv.addObject("empresas", lista);
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/empresas");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Empresa removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Empresa empresa = this.service.getById(id); 

		return novo(empresa);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Empresa empresa) {
		ModelAndView mv = new ModelAndView("pages/empresa/novo");
		mv.addObject("empresa", empresa);
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Empresa empresa, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/empresas");
		
		if (result.hasErrors()) {
			return novo(empresa);
		}

		attributes.addFlashAttribute("mensagem", "Empresa salvo com sucesso!");
		this.service.save(empresa);
		return mv;
	}
}