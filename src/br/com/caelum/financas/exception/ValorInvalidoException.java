package br.com.caelum.financas.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ValorInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValorInvalidoException (String message) {
		super(message);
	}

}
