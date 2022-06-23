package com.sparta.hh99_clone.security;

import com.sparta.hh99_clone.security.filter.FormLoginFilter;
import com.sparta.hh99_clone.security.filter.JwtAuthFilter;
import com.sparta.hh99_clone.security.jwt.HeaderTokenExtractor;
import com.sparta.hh99_clone.security.provider.FormLoginAuthProvider;
import com.sparta.hh99_clone.security.provider.JwtAuthProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthProvider jwtAuthProvider;
    private final HeaderTokenExtractor headerTokenExtractor;
    private final CorsFilter corsFilter;

    public WebSecurityConfig(
            JwtAuthProvider jwtAuthProvider,
            HeaderTokenExtractor headerTokenExtractor,
            CorsFilter corsFilter) {
        this.jwtAuthProvider = jwtAuthProvider;
        this.headerTokenExtractor = headerTokenExtractor;
        this.corsFilter = corsFilter;
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth
                .authenticationProvider(formLoginAuthProvider())
                .authenticationProvider(jwtAuthProvider);
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .addFilter(corsFilter)
                .addFilterBefore(formLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/api/user/logout")
                .permitAll()
                .logoutSuccessHandler(jwtLogoutSuccessHandler())
                .and()
                .exceptionHandling()
                .accessDeniedPage("/");
    }

    @Bean
    public FormLoginFilter formLoginFilter() throws Exception {
        FormLoginFilter formLoginFilter = new FormLoginFilter(authenticationManager());
        formLoginFilter.setFilterProcessesUrl("/api/user/login");
        formLoginFilter.setAuthenticationSuccessHandler(formLoginSuccessHandler());
        formLoginFilter.afterPropertiesSet();
        return formLoginFilter;
    }

    @Bean
    public FormLoginSuccessHandler formLoginSuccessHandler() {
        return new FormLoginSuccessHandler();
    }

    @Bean
    public JwtLogoutSuccessHandler jwtLogoutSuccessHandler() {
        return new JwtLogoutSuccessHandler();
    }

    @Bean
    public FormLoginAuthProvider formLoginAuthProvider() {
        return new FormLoginAuthProvider(encodePassword());
    }

    private JwtAuthFilter jwtAuthFilter() throws Exception {
        List<String> skipPathList = new ArrayList<>();

        skipPathList.add("GET,/**"); // static 폴더 접근 허용
        skipPathList.add("GET,/h2-console/**");
        skipPathList.add("POST,/h2-console/**");
        skipPathList.add("POST,/api/user/signup"); // 프론트에서 URL 받아서 loginView 추가해야 합니다.
        skipPathList.add("GET,/");
        skipPathList.add("GET,/api/vehicle/**");
        skipPathList.add("GET,/api/shop");
        skipPathList.add("GET,/api/shop/category/**");
        skipPathList.add("GET,/api/shop/item/**");

        FilterSkipMatcher matcher = new FilterSkipMatcher(
                skipPathList,
                "/**"
        );

        JwtAuthFilter filter = new JwtAuthFilter(
                matcher,
                headerTokenExtractor
        );
        filter.setAuthenticationManager(super.authenticationManagerBean());

        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
