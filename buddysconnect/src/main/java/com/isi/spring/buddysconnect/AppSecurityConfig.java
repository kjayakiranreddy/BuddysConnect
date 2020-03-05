package com.isi.spring.buddysconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity

public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserDetailsService userDetailsService;
	

	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}

	
	  @Bean
		public PasswordEncoder passwordEncoder(){
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder;
		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login","/registration").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").usernameParameter("email").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll();
		
	}



		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/*.css");
			web.ignoring().antMatchers("/*.js");
		}
	
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("navin").password("1234").roles("USER").build());
//		
//		
//		return new InMemoryUserDetailsManager(users);
//	}
	
}
