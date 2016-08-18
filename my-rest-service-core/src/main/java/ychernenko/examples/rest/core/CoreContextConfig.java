package ychernenko.examples.rest.core;

import ychernenko.examples.rest.core.config.ServiceConfiguration;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
//@EnableTransactionManagement
@EnableJpaRepositories("ychernenko.examples.rest.core.db")
@PropertySource("classpath:my-rest-service-default.properties")
public class CoreContextConfig {

    static {
        System.setProperty("derby.language.logStatementText", "true");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource(ServiceConfiguration configuration) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(configuration.getDriverName());
        dataSource.setUrl(configuration.getJdbcUrl());
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter vendorAdapter, DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPersistenceUnitName("main");
        bean.setJpaVendorAdapter(vendorAdapter);
        bean.setDataSource(dataSource);
        return bean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(ServiceConfiguration configuration) {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setGenerateDdl(true);
        bean.setShowSql(true);
        bean.setDatabasePlatform(configuration.getHibernateDialect());
        return bean;
    }

//    @Bean
//    public JpaTransactionManager transactionManager() {
//        return new JpaTransactionManager();
//    }

}
