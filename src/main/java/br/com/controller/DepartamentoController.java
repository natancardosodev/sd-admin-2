/**
 * 
 */
package br.com.controller;

import java.util.HashMap;
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

import br.com.model.Departamento;
import br.com.model.Empresa;
import br.com.service.DepartamentoService;
import br.com.service.EmpresaService;

/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public ModelAndView listar() {
		List<Departamento> lista = service.list();

		ModelAndView mv = new ModelAndView("pages/departamento/departamentos");		
		mv.addObject("departamentos", lista);
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/departamentos");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Departamento removido com sucesso!");
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Departamento departamento = this.service.getById(id);
	
		return novo(departamento);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Departamento departamento) {
		List<Empresa> empresas = empresaService.list();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("departamento", departamento);
        dados.put("empresas", empresas);
        
        return new ModelAndView("pages/departamento/novo",dados);
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Departamento departamento, BindingResult result,
			Model model, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/departamentos");
		
		if (result.hasErrors()) {
			return novo(departamento);
		}
		
		attributes.addFlashAttribute("mensagem", "Departamento salvo com sucesso!");
		this.service.save(departamento);
		
		return mv;
	}
}