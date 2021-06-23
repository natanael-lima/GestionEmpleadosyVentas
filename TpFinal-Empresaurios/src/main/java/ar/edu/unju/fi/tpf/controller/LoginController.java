package ar.edu.unju.fi.tpf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.tpf.model.Usuario;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/form/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		
		return "registro";
	}
	
	@PostMapping("/form/saveuser")
	public String registro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {  
		
		if(result.hasErrors()) { 
			  return "/form/registro";
		}
		
		usuarioService.guardarUsuario(usuario);
		
		return "login";
		
	}
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	
	@GetMapping("/logout")
	public String getLogout() {
		return "logout";
	}
	
}