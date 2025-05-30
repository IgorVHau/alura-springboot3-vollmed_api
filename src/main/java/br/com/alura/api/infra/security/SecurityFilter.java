package br.com.alura.api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.api.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		var tokenJWT = recuperarToken(request);
		System.out.println("Ainda fora da condição tokenJWT!!!");
		
		if(tokenJWT != null) {
			System.out.println("Entrou na condição tokenJWT!!!");
			var subject = tokenService.getSubject(tokenJWT);
			var usuario = repository.findByLogin(subject);
			var authentication =  new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("Logado na requisição!!!");
		}
		
		filterChain.doFilter(request, response);
	}
	
	protected String recuperarToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization");
		if(authorizationHeader != null) {
			return authorizationHeader.replace("Bearer ", "");
		}
		return null;
		//else {
			
		//}
		//throw new RuntimeException("Token JWT não enviado no cabeçalho Authorization!");	
	}

}
