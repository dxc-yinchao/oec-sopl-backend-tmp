package oec.lis.sopl.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import oec.lis.sopl.common.filter.AuthenticationFilter;

@Configuration
public class SecurityConfig{
    
//	@Autowired
//    private AuthenticationFilter authenticationFilter;

	@Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.cors().and().csrf().disable()
//        .exceptionHandling().and()
//        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//        .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//        .antMatchers("/api/test/**").permitAll()
//        .anyRequest().authenticated();
    
		httpSecurity
    	.authorizeRequests()
    	.antMatchers("/")
    	.permitAll();	
		
        return httpSecurity.build();
    }
}