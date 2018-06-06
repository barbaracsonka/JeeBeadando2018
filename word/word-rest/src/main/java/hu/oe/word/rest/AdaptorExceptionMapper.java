package hu.oe.word.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import hu.oe.word.ejbservice.error.AdaptorException;


@Provider
public class AdaptorExceptionMapper implements ExceptionMapper<AdaptorException>{

	@Override
	public Response toResponse(AdaptorException e) {
		return Response.status(e.getHttpStatus()).entity(e.build()).type(MediaType.APPLICATION_JSON).build();
	}

}
