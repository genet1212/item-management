package com.backend.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "itemsTransactionManager",
        basePackages = "com.backend"
)
public class DbConfig {

    private final Environment env;

    public DbConfig(Environment env) {
        super();
        this.env = env;
    }


    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mysqlServerDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean msServerEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysqlServerDataSource());
        em.setPackagesToScan("com.backend");
        em.setPersistenceUnitName("employee_managment_system");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//        properties.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean(name = "itemsTransactionManager")
    public PlatformTransactionManager mysqlServerTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(msServerEntityManager().getObject());
        return transactionManager;
    }
}