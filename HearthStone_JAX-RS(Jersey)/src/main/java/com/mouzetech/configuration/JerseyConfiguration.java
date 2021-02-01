package com.mouzetech.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mouzetech.resource.CartaResource;
import com.mouzetech.resource.EnumResource;
import com.mouzetech.resource.exception.IdNotFoundExceptionHandler;
import com.mouzetech.resource.exception.NomeNotFoundExceptionHandler;
import com.mouzetech.resource.exception.NotValidFieldExceptionHandler;

@Component
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
		register(CartaResource.class);
		register(EnumResource.class);
		register(NomeNotFoundExceptionHandler.class);
		register(IdNotFoundExceptionHandler.class);
		register(NotValidFieldExceptionHandler.class);
	}
	

}