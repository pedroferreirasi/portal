package br.com.informa.negocio.exception;

public class ForaDoDominioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4934255494687970745L;

	public ForaDoDominioException()
	{
		super("Problemas na conexão! Sua maquina pode estar fora da rede. Contate o Suporte Tecnico");
	}
}
