package by.itacademy.mikhalevich.icourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"by.itacademy.mikhalevich.icourse"})
@EnableWebMvc
@EnableWebSecurity
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories(
        basePackages = "by.itacademy.mikhalevich.icourse",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
public class ApplicationConfig
        extends AbstractSecurityWebApplicationInitializer
        implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(@Autowired ApplicationContext ctx){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setApplicationContext(ctx);
        resolver.setPrefix("/WEB-INF/JSP/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

}
