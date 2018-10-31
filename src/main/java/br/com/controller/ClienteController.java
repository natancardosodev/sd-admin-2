package br.com.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import br.com.dto.ClientePesquisaDTO;
import br.com.model.Cliente;
import br.com.service.ClienteService;
/**
 * @author natancardosodev
 *
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	
	@GetMapping
	public ModelAndView listar(@ModelAttribute("filtro") ClientePesquisaDTO filtro) {
		ModelAndView mv = new ModelAndView("pages/cliente/clientes");
		
		if(!StringUtils.isEmpty(filtro.getEmail())) {
			List<Cliente> clientes = this.service.filtrar(filtro);
			mv.addObject("clientes", clientes);
//		}else if(StringUtils.isEmpty(filtro.getEmail())) {
//			mv.addObject("clientes", service.pesquisaVazia());
		}else {
			mv.addObject("clientes", service.list());
		}
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		this.service.remove(id);
		attributes.addFlashAttribute("removido", "Cliente removido com sucesso!");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Cliente cliente = this.service.getById(id); 

		return novo(cliente);
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Cliente cliente) {
		//List<Pedido> enderecos = pedidoService.list();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("cliente", cliente);
		//dados.put("pedidos", pedidos);
        
        return new ModelAndView("pages/cliente/novo",dados);
	}
	
	@PostMapping("/save")
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, 
			Model model, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		
		if (result.hasErrors()) {
			return novo(cliente);
		}

		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		this.service.save(cliente);
		return mv;
	}
	
}