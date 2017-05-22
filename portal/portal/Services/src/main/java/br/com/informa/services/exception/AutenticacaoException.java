package br.com.informa.services.exception;

public class AutenticacaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2593930590196534655L;
	
	public AutenticacaoException()
	{
		super("Erro na autenticação! Tente novamente.");
	}

}
