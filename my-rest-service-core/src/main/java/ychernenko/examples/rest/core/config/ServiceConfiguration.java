package ychernenko.examples.rest.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfiguration {

    @Value("${" + PropertyNames.DB_DRIVER_NAME + "}")
    private String driverName;

    @Value("${" + PropertyNames.DB_JDBC_URL + "}")
    private String jdbcUrl;

    @Value("${" + PropertyNames.DB_HIBERNATE_DIALECT + "}")
    private String hibernateDialect;

    public String getDriverName() {
        return driverName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getHibernateDialect() {
        return hibernateDialect;
    }
}
