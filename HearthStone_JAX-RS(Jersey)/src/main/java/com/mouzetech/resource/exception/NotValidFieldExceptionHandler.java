package com.mouzetech.resource.exception;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.stereotype.Component;

import com.mouzetech.exception.NotValidFieldException;

@Component
public class NotValidFieldExceptionHandler implements ExceptionMapper<NotValidFieldException> {

	@Context
	private UriInfo info;
	
	@Override
	public Response toResponse(NotValidFieldException exception) {
		ValidationError error = exception.getError();
		return Response.status(422).entity(error).build();
				
	}

}
