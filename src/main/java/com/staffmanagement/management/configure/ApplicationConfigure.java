// package com.staffmanagement.management.configure;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class ApplicationConfigure extends WebSecurityConfigurerAdapter {
//     @Autowired
//     private UserDetailsService userDetailsService;
//     @Bean

//     public AuthenticationProvider authProvide(){
    
//     DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    
//     provider.setUserDetailsService(userDetailsService);
//     provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//     return provider;
//     }
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
        
//         http.authorizeRequests()
//         .antMatchers("/staff").hasAnyAuthority("USER","ADMIN")
//         .antMatchers("/admin").hasAuthority("ADMIN")
//         .anyRequest().authenticated()
//         .and().httpBasic();
// }
    
// }
