package br.com.animalgang.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.animalgang.repository.UserRepository;
import br.com.animalgang.service.impl.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) {
            //System.out.println("Token recuperado: " + token); // Debug do token

            var login = tokenService.validateToken(token);

            UserDetails user = userRepository.findByLogin(login);
            //System.out.println("Usuário encontrado: " + user.getUsername()); // Debug do usuário encontrado

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //System.out.println("Autenticação configurada para o usuário: " + user.getUsername() + " com authorities: " + user.getAuthorities()); // Debug das authorities
        } else {
            System.out.println("Nenhum token encontrado na requisição."); // Caso o token não seja encontrado
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        //System.out.println("Cabeçalho Authorization: " + authHeader);  // Log para verificar o cabeçalho
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
