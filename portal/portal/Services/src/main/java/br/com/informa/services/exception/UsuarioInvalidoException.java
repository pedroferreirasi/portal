package br.com.informa.services.exception;

public class UsuarioInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2367451141878889053L;
	
	public UsuarioInvalidoException()
	{
		super("Usuário inválido");
	}

}
