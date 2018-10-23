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

import br.com.model.Fornecedor;
import br.com.model.Produto;
import br.com.service.FornecedorService;
import br.com.service.ProdutoService;
/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping
	public ModelAndView listar() {
//		List<Produto> lista = service.list();
//		
//		ModelAndView mv = new ModelAndView("pages/produto/produtos");		
//		mv.addObject("produtos", lista);
//		
//		return mv;
		List<Produto> produtos = service.list();
		List<Fornecedor> fornecedores = fornecedorService.list();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("produtos", produtos);
        dados.put("fornecedores", fornecedores);
        
        return new ModelAndView("pages/produto/produtos",dados);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/produtos");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Produto removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Produto produto = this.service.getById(id); 

		return novo(produto);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Produto produto) {
//		ModelAndView mv = new ModelAndView("pages/produto/novo");
//		mv.addObject("produto", produto);
//		return mv;
		List<Produto> produtos = service.list();
		List<Fornecedor> fornecedores = fornecedorService.list();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("produtos", produtos);
        dados.put("fornecedores", fornecedores);
        
        return new ModelAndView("pages/produto/novo",dados);
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/produtos");
		
		if (result.hasErrors()) {
			return novo(produto);
		}

		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		this.service.save(produto);
		return mv;
	}
}