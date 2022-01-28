package by.itacademy.mikhalevich.icourse.config;

import by.itacademy.mikhalevich.icourse.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/teachers").permitAll()
                .antMatchers("/salary").authenticated()
                .antMatchers("/groups").hasAnyAuthority("ROLE_ADMIN", "READ_INFO")
//                .antMatchers("/info").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/marks").hasRole("USER")
                .and().formLogin()
                .and().httpBasic()
                .and().logout().logoutSuccessUrl("/")
                .and().csrf().disable();


//        http.authorizeRequests()
////                .anyRequest().authenticated()
//                .antMatchers("/", "/teachers").permitAll()
//                .antMatchers( "/salary").authenticated()
//                .and().formLogin()
//                .and()
//                .csrf().disable()
//                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(@Autowired UserDetailsService userService,
                                                               @Autowired PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

//    @Override
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("1")
//                .password("1")
//                .roles("ADMIN")
//                .build());
//        return manager;
//    }
}


