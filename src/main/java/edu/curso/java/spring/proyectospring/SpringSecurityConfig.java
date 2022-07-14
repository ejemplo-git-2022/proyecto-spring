package edu.curso.java.spring.proyectospring;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

	/*@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("general").password("general1234").roles("USER")
				.build();

		UserDetails user2 = User.withDefaultPasswordEncoder().username("admin").password("admin1234")
				.roles("USER", "ADMIN").build();

		ArrayList<UserDetails> users = new ArrayList<UserDetails>();

		users.add(user1);
		users.add(user2);

		return new InMemoryUserDetailsManager(users);
	}*/
	
	@Bean
	public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
	  //String usersByUsernameQuery = "select username, password, enabled from USERS where username = ?";
	  //String authsByUserQuery = "select username, authority as role from AUTHORITIES where username = ?";
	      
	  JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

	  //users.setEnableGroups(true);
	  
	  //users.setUsersByUsernameQuery(usersByUsernameQuery);
	  //users.setAuthoritiesByUsernameQuery(authsByUserQuery);
	  
	  return users;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
			.antMatchers("/api/**").authenticated()
			.antMatchers("/productos/**").authenticated()
			.antMatchers("/**").permitAll().and()
			.formLogin(form -> {
				form.loginPage("/login");
				form.loginProcessingUrl("/validarusuario");
				form.failureUrl("/login?error=true");
				form.defaultSuccessUrl("/productos");
			}).httpBasic().and().csrf().disable()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID");

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}

}