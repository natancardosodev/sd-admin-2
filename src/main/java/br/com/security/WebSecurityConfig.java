package br.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author natancardosodev
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.
		authorizeRequests()
			.antMatchers("/contatos").hasAnyRole("ADMIN")
			.antMatchers("/contatos").hasAnyRole("USER")
			.antMatchers(HttpMethod.GET, "/contatos/novo").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
		.and()
		.logout()
			.logoutSuccessUrl("/login?logout")
.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "/**/favicon.ico");
	}
	
//	http.csrf().disable().authorizeRequests()
//	.antMatchers(HttpMethod.GET, "/").permitAll()
//	.antMatchers(HttpMethod.GET, "/contatos").hasRole("ADMIN")
//	.antMatchers(HttpMethod.GET, "/contatos/novo").hasRole("ADMIN")
//	.anyRequest().authenticated()
//	.and().formLogin().permitAll()
//	.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

}
