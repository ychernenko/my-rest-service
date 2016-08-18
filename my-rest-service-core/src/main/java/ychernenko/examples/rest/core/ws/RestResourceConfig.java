package ychernenko.examples.rest.core.ws;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

import ychernenko.examples.rest.core.ws.exceptions.IllegalArgumentExceptionMapper;
import ychernenko.examples.rest.core.ws.exceptions.NotFoundExceptionMapper;

@Component
public class RestResourceConfig extends ResourceConfig {

    public RestResourceConfig() {
        register(MyServiceImpl.class);
        register(RequestContextFilter.class);
        register(LoggingFilter.class);
        register(IllegalArgumentExceptionMapper.class);
        register(NotFoundExceptionMapper.class);
    }
}