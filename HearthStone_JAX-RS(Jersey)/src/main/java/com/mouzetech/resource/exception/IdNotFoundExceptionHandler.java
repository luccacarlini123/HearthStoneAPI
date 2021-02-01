package com.mouzetech.resource.exception;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.mouzetech.exception.IdNotFoundException;

@Component
public class IdNotFoundExceptionHandler implements ExceptionMapper<IdNotFoundException> {

	@Context
	private UriInfo info;
	
	@Override
	public Response toResponse(IdNotFoundException exception) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), 
				"Não encontrado", exception.getLocalizedMessage(), info.getAbsolutePath().toString());
		return Response.status(Status.NOT_FOUND).entity(error).build();
				
	}

}
