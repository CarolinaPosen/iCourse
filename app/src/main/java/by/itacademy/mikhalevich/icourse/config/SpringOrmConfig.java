package by.itacademy.mikhalevich.icourse.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jca.support.LocalConnectionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class SpringOrmConfig {

    private final DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean factoryBean(@Autowired Properties jpaProperties){
        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        managerFactoryBean.setDataSource(dataSource);
        managerFactoryBean.setPersistenceUnitName("jpa-unit");
        managerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        managerFactoryBean.setPackagesToScan("by.itacademy.mikhalevich.icourse.model");
        managerFactoryBean.setJpaProperties(jpaProperties);
        return managerFactoryBean;
    }

    @Bean
    public Properties jpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        properties.setProperty("show_sql", "true");
        properties.setProperty("format_sql", "true");
        properties.setProperty("hbm2ddl.auto", "none");
        properties.setProperty("current_session_context_class", "thread");
        properties.setProperty("connection.pool_size", "100");
        properties.setProperty("hibernate.dbcp.initialSize", "10");
        properties.setProperty("hibernate.dbcp.maxTotal", "100");
        properties.setProperty("hibernate.dbcp.maxIdle", "10");
        properties.setProperty("hibernate.dbcp.minIdle","10");
        properties.setProperty("hibernate.dbcp.maxWaitMillis","-1");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }

}
