package br.com.informa.negocio.exception;

public class EmailInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmailInvalidoException() {
		super("Email inválido");
	}

}
