package com.eduardo.crud.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = -5756922119859962619L;
	
	private Date timestamp;
	private String message;
	private String details;

}
