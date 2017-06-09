package br.com.informa.services.exception;

public class CampoObrigatorioNullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3206650307073150273L;

	public CampoObrigatorioNullException()
	{
		super("campo obrigatório");
	}
	
	public CampoObrigatorioNullException(String fieldName)
	{
		super("Campo: '" + fieldName + "' é obrigatório!");
	}

}
