package ar.edu.unju.fi.tpf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginSuccessMensaje extends SimpleUrlAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		SessionFlashMapManager fmanager = new SessionFlashMapManager();
		
		FlashMap fmap = new FlashMap();
		
		fmap.put("success", "Has iniciado sesion con exito");
		
		fmanager.saveOutputFlashMap(fmap, request, response);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	

}
