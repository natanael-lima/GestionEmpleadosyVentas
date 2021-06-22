package ar.edu.unju.fi.tpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {

	@GetMapping("/login")
	public String getIndex() {
		return "login";
	}
	
}
