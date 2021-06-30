package ar.edu.unju.fi.tpf.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.tpf.model.Usuario;
import ar.edu.unju.fi.tpf.service.IRolService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	IRolService rolService;
	
	@GetMapping("/form/registro")
	public String getRegistro(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("roles", rolService.obtenerRoles());
		
	
		return "registro";
	}
	
	@PostMapping("/form/registro")
	public String registro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {  
		
		if(result.hasErrors()) { 
			 model.addAttribute("roles", rolService.obtenerRoles());
			 return "redirect:/form/registro";
		}
		
		usuarioService.guardarUsuario(usuario);
		
		return "redirect:/login";
		
	}
	
	@GetMapping("/login")
	public String getLogin(@RequestParam(value="logout", required=false) String logout, Model model, Principal principal, RedirectAttributes attribute) {
		model.addAttribute("usuario", new Usuario());
		
		if(principal!=null) {
			attribute.addFlashAttribute("warning", "Ud. ya ha iniciado sesión previamente");
			return "redirect:/index";
		}
		
		if(logout!=null) {
			model.addAttribute("success", "Ha finalizado sesión con éxito");
		}
		
		return "login";
	}
	
	
	@GetMapping("/logout")
	public String getLogout() {
		return "logout";
	}
	
}