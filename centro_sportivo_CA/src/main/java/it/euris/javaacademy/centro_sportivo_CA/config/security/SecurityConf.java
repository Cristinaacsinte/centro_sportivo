package it.euris.javaacademy.centro_sportivo_CA.config.security;

import it.euris.javaacademy.centro_sportivo_CA.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConf {
    private final WhiteListConfiguration whiteList;

    public SecurityConf(WhiteListConfiguration whiteList) {
        this.whiteList = whiteList;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles(UserRole.USER.toString())
                .build();

        UserDetails admin = User.builder()
                .username("academy")
                .password(passwordEncoder().encode("academy"))
                .roles(UserRole.MANAGER.toString())
                .build();

        UserDetails visitor = User.builder()
                .username("visitor")
                .password(passwordEncoder().encode("visitor"))
                .roles(UserRole.VISITOR.toString())
                .build();

        return new InMemoryUserDetailsManager(user, admin, visitor);
    }
}
