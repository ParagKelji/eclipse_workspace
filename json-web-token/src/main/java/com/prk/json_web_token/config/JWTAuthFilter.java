package com.prk.json_web_token.config;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {
	
	private final UserAuthProvider userAuthProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if ( header != null ) {
			String [] authElements = header.split(" ");
			if ( authElements.length == 2 && "Bearer".equals(authElements[0]) ) {
				try {
					if ( "GET".equals(request.getMethod() ) ) {
						SecurityContextHolder.getContext().setAuthentication(userAuthProvider.validateToken(authElements[1]));
					}
				} catch(Exception ex) {
					SecurityContextHolder.clearContext();
					throw ex;
				}
			}
		}
		filterChain.doFilter(request, response);
	}

}
