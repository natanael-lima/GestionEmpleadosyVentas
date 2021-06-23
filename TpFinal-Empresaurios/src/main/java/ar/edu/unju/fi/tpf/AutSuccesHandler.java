/*package ar.edu.unju.fi.tpf;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutSuccesHandler implements AuthenticationSuccessHandler{
	
	private RedirectStrategy redirect = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,Authentication authentication) throws IOException, ServletException {
		
		boolean esAdmin = false;
		boolean esUser = false;
		
		Collection<? extends GrantedAuthority> auth = authentication.getAuthorities();
		
		for(GrantedAuthority grantedAuthority : auth) {
			if(grantedAuthority.getAuthority().equals("ADMIN")) {
				esAdmin = true;
				break;
			}else {
				if(grantedAuthority.getAuthority().equals("USER")) {
					esUser=true;
					break;
				}
			}
		}
		
		if(esAdmin) {
			redirect.sendRedirect(request, response, "/index");
		}
		else {
			if(esUser) {
				redirect.sendRedirect(request, response, "/index");
			}
			else {
				throw new IllegalStateException();
			}
		}
		
	}
}*/