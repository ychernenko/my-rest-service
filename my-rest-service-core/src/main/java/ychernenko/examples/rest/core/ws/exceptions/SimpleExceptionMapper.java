package ychernenko.examples.rest.core.ws.exceptions;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class SimpleExceptionMapper<T extends Exception> implements ExceptionMapper<T> {

    @Context
    private HttpHeaders headers;
    private final Response.Status status;

    public SimpleExceptionMapper(Response.Status status) {
        this.status = status;
    }

    @Override
    public Response toResponse(T exception) {
        return Response
                .status(status)
                .entity("")
                .type(getAcceptType())
                .build();
    }

    private MediaType getAcceptType() {
        List<MediaType> accepts = headers.getAcceptableMediaTypes();
        if (accepts == null || accepts.isEmpty()) {
            return headers.getMediaType();
        } else {
            return accepts.get(0);
        }
    }
}
