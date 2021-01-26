package com.eduardo.pagamento.repository;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends NestedRuntimeException {
	private static final long serialVersionUID = -5288467348971103354L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}

}
