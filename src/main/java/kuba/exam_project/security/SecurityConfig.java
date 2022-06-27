package kuba.exam_project.security;

import kuba.exam_project.security.jwt.JwtTokenFilter;
import kuba.exam_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService service;
    private final JwtTokenFilter jwtTokenFilter;

    @Autowired
    PasswordEncoder passwordEncoder;

    public SecurityConfig(UserService service, JwtTokenFilter jwtTokenFilter1) {
        this.service = service;
        this.jwtTokenFilter = jwtTokenFilter1;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/jwt/**").permitAll().
                antMatchers("/v3/api-docs/**","swagger-ui/**","/swagger-ui.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    protected AuthenticationManager authenticationManagerBuilder() throws Exception {
        return  super.authenticationManager();
    }
}
