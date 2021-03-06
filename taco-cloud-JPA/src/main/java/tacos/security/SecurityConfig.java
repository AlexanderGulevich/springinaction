package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web
                        .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
                        .configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation
             .authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web
             .builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private UserDetailsService userDetailsService;
  
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
////    http
//      .authorizeRequests()
//        .antMatchers("/design", "/orders")
//          .access("hasRole('ROLE_USER')")
//        .antMatchers("/", "/**").access("permitAll")
//        
//      .and()
//        .formLogin()
//          .loginPage("/login")
//      .and()
//        .logout()
//          .logoutSuccessUrl("/")
//      .and()
//        .csrf()
//          .ignoringAntMatchers("/h2-console/**")
//      .and()  
//        .headers()
//          .frameOptions()
//            .sameOrigin()
//      ;
//  }

  /*
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {

    auth
      .userDetailsService(userDetailsService);
    
  }
  
   */
//
//  @Bean
//  public PasswordEncoder encoder() {
//    return new StandardPasswordEncoder("53cr3t");
//  }
//  
//  
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth)
//      throws Exception {
//
//    auth
//      .userDetailsService(userDetailsService)
//      .passwordEncoder(encoder());
//    
//  }
  
// IN MEMORY AUTHENTICATION EXAMPLE
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    
    auth
      .inMemoryAuthentication()
        .withUser("buzz").password("{noop}infinity").authorities("USER")
        .and()
        .withUser("woody").password("{noop}bull").authorities("USER");
  }
  
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//      auth.inMemoryAuthentication()
//              .withUser("user").password("{noop}password").roles("USER")
//              .and()
//              .withUser("admin").password("{noop}password").roles("ADMIN");
//
//  }
  
  
  // способ  
//  @Bean
//  public UserDetailsService userDetailsService() {
//
//      User.UserBuilder users = User.withDefaultPasswordEncoder();
//      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//      manager.createUser(users.username("user1").password("password").roles("USER").build());
//      manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
//      return manager;
//
//  }
//  
  

// JDBC Authentication example
/*
//tag::configureAuthentication_jdbc[]
  @Autowired
  DataSource dataSource;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    
    auth
      .jdbcAuthentication()
        .dataSource(dataSource);
    
  }
*/

/*
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    
    auth
      .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery(
            "select username, password, enabled from Users " +
            "where username=?")
        .authoritiesByUsernameQuery(
            "select username, authority from UserAuthorities " +
            "where username=?");
    
  }
*/

/*
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    
    auth
      .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery(
            "select username, password, enabled from Users " +
            "where username=?")
        .authoritiesByUsernameQuery(
            "select username, authority from UserAuthorities " +
            "where username=?")
        .passwordEncoder(new StandardPasswordEncoder("53cr3t");
    
  }
*/
  
  
// LDAP Authentication example
/*
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    auth
      .ldapAuthentication()
        .userSearchFilter("(uid={0})")
        .groupSearchFilter("member={0}");
  }
*/
  

}