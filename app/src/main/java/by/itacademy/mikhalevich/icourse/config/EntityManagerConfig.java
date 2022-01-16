package by.itacademy.mikhalevich.icourse.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@Import({SpringOrmConfig.class})
@EnableTransactionManagement
@RequiredArgsConstructor
public class EntityManagerConfig implements TransactionManagementConfigurer {

    private final DataSource dataSource;
    private final LocalContainerEntityManagerFactoryBean factoryBean;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(factoryBean.getObject());
        transactionManager.setDataSource(dataSource);
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }



}
