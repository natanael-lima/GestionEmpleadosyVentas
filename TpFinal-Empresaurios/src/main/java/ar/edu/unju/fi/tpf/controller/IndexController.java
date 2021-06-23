package ar.edu.unju.fi.tpf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tpf.model.Usuario;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

@Controller
public class IndexController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	//============================ Metodo para ingresar al home Principal ============================
	@GetMapping("/index")
	public String getIndex(Authentication auth,HttpSession session) {
		
		String nombreU = auth.getName();
		
		if(session.getAttribute(nombreU)==null) {
			Usuario usuario = usuarioService.findbyNombreU(nombreU);
			usuario.setPass(null);
			session.setAttribute("usuario", usuario);
		}
		
		return "index";
	}
	
}
