package br.com.informa.services.exception;

public class UsuarioInativoException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4613360562150745742L;

	public UsuarioInativoException()
	{
		super("Usuário inativo");
	}
}
