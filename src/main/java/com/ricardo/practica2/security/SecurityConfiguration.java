package com.ricardo.practica2.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableConfigurationProperties(WebConfigProperties.class)
public class SecurityConfiguration {

    private final WebConfigProperties webConfigProperties;

    public SecurityConfiguration(WebConfigProperties webConfigProperties) {
        this.webConfigProperties = webConfigProperties;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()).cors(withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/auth/login", "/oauth2/**", "/login/**",
                                "/swagger-ui/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())   ;  // returns HttpSecurity
                //.oauth2Login(withDefaults());  // now compiles

        return http.build();

    }


    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        var user = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        var admin = User.builder().username("user").password(passwordEncoder.encode("user123")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
          @Override
          public void addCorsMappings(CorsRegistry corsRegistry){
              WebConfigProperties.Cors cors = webConfigProperties.getCors();
              corsRegistry.addMapping("/**")
                      .allowedOrigins(cors.getAllowedOrigins())
                      .allowedMethods(cors.getAllowedMethods())
                      .maxAge(cors.getMaxAge())
                      .allowedHeaders(cors.getAllowedHeaders())
                      .exposedHeaders(cors.getExposedHeaders());
          }
        };
    }
}
