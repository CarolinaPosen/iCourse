package by.itacademy.mikhalevich.icourse.config;

import by.itacademy.mikhalevich.icourse.auth.UserService;
import by.itacademy.mikhalevich.icourse.exception.SimpleAccessDeniedHandler;
import by.itacademy.mikhalevich.icourse.exception.SimpleAuthenticationEntryPoint;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").permitAll()

                .antMatchers("/teachers").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "READ_INFO")
                .antMatchers("/teacher-edit").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/delete-teacher").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/create-teacher").hasAnyAuthority("ROLE_ADMIN")

                .antMatchers("/students").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "READ_INFO")
                .antMatchers("/student-edit").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/delete-student").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/create-student").hasAnyAuthority("ROLE_ADMIN")

                .antMatchers("/groups").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "READ_INFO")
                .antMatchers("/group-edit").hasAnyAuthority("ROLE_ADMIN", "WRITE_INFO")
                .antMatchers("/delete-group").hasAnyAuthority("ROLE_ADMIN")

                .antMatchers("/salary").hasAnyAuthority("WRITE_INFO", "READ_INFO")
                .antMatchers("/salary-edit").hasAnyAuthority("WRITE_INFO")
                .antMatchers("/marks").hasAnyAuthority("WRITE_INFO", "READ_INFO")
                .antMatchers("/mark-edit").hasAnyAuthority("WRITE_INFO")
                .antMatchers("/group-students-edit").hasAnyAuthority("WRITE_INFO")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/teachers", true)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .and();
//                .exceptionHandling().accessDeniedHandler(new SimpleAccessDeniedHandler())
//                .authenticationEntryPoint(new SimpleAuthenticationEntryPoint());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
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


