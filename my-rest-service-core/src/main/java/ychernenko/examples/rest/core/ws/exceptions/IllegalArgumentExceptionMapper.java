package ychernenko.examples.rest.core.ws.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper extends SimpleExceptionMapper<IllegalArgumentException> {

    public IllegalArgumentExceptionMapper() {
        super(Response.Status.BAD_REQUEST);
    }

}
