package br.com.devdojo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ana Gabriela
 * 
 *  Class para retorno de ResourceNotFoundException 
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
   
	private static final long serialVersionUID = -2204835713749453290L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}

