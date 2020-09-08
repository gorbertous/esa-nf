///**
// * create a Web Security Configuration file, that is used to secure your application to access the HTTP Endpoints by using basic authentication.
// */
//package eu.europa.ec.estat.esa.security;
//
////import java.util.ArrayList;
////import java.util.List;
//
//import javax.sql.DataSource;
//
///**
// * @author Gorazd.Bertoncelj
// *
// */
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.authority.SimpleGrantedAuthority;
////import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	private static final String ADMIN = "ADMIN";
//	private static final String USER = "USER";
//	
//
//	@Autowired
//	private DataSource datasource;
//
//	@Autowired
//	private AccessDeniedHandler accessDeniedHandler;
//
//	// roles admin allow to access /admin/**
//	// roles user allow to access /user/**
//	// custom 403 access denied handler
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.csrf().disable().authorizeRequests()
//				.antMatchers("/", "/index", "/registration**", "/chapters**", "/js/**", "/css/**", "/bootstrap/**", "/dist/**",
//						"/plugins/**", "/img/**")
//				.permitAll().antMatchers("/admin/**").hasAnyRole(ADMIN).antMatchers("/user/**").hasAnyRole(USER)
//				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
//				.permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//	}
//	
//	@Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userDetailsService());
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		// Use Spring Boots User detailsMAnager
//		JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
//
//		// Set our Datasource to use the one defined in application.properties
//		userDetailsService.setDataSource(datasource);
//
//		// Create BCryptPassword encoder
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//		// add components
//		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//		auth.jdbcAuthentication().dataSource(datasource);
//
//		// add new user "user" with password "password" - password will be encrypted
////		if (!userDetailsService.userExists("naruto")) {
////			List<GrantedAuthority> authorities = new ArrayList<>();
////			authorities.add(new SimpleGrantedAuthority("USER"));
////			User userDetails = new User("naruto", encoder.encode("1234"), authorities);
////			userDetailsService.createUser(userDetails);
////		}
//	}
//
//}