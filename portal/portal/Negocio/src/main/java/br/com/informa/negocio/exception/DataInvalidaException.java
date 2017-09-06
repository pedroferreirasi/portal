package br.com.informa.negocio.exception;

public class DataInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataInvalidaException() {
		super("Data Inválida");
	}
	
	public DataInvalidaException(String field) {
		super(field + " inválida");
	}
}
