package oec.lis.sopl.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import oec.lis.sopl.model.domain.UserInfo;

//@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	@Value("http://localhost:8080/realms/SpringBootKeycloak/protocol/openid-connect/userinfo")
    private String keycloakUserInfoURL;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
	    if (authHeader != null) {
	        String accessToken = authHeader.replace("Bearer ", "");

	        RestTemplate restTemplate = new RestTemplate();

	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "bearer " + accessToken);

	        HttpEntity<MultiValueMap<String, String>> keycloakRequest = new HttpEntity<>(null, headers);
	        UserInfo userinfo = restTemplate.postForObject(keycloakUserInfoURL, keycloakRequest, UserInfo.class);

	        Authentication authentication =
	                new UsernamePasswordAuthenticationToken(userinfo, null);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	    }else {
	    	logger.info("no token");
	    }

	    chain.doFilter(request, response);	}
}
