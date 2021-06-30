package ar.edu.unju.fi.tpf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tpf.service.imp.UsuarioDetailServiceImp;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UsuarioDetailServiceImp usuarioDetail;
	
	@Autowired
	private LoginSuccessMensaje successMessage;
	
	@Bean
	public BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(usuarioDetail).passwordEncoder(passEncoder());
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/include/**","/css/**","icons/**","/img/**","/images/**","/js/**","/fonts/**","/webjars/**","/vendor/**","/layouts/**","/layout/**","/logout","/form/registro","/index").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.successHandler(successMessage)
				.loginPage("/login")
				.defaultSuccessUrl("/index",true)
				.failureUrl("/login?error=true")
				.loginProcessingUrl("/login-post")
				.permitAll()
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/index");
				
	}
}