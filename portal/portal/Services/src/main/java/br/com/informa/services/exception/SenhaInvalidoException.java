package br.com.informa.services.exception;

public class SenhaInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2367451141878889053L;
	
	public SenhaInvalidoException()
	{
		super("Senha inválida");
	}

}