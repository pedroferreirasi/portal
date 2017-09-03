package br.com.informa.intranet.utils;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class Mensagens extends FacesContext implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void erroNaOperacao() {
		if (Contexto.ValidaSeContextoExiste())
		{
			messageFatal(Constantes.ERRO_NA_OPERACAO);
		}
	}
	
	public static void OperacaoRealizadaComSucesso() {
		if (Contexto.ValidaSeContextoExiste())
		{
			messageInformation(Constantes.OPERACAO_REALIZADA_COM_SUCESSO);
		}
	}	
	
	public static void messageInformation(String msg)
	{
		if (Contexto.ValidaSeContextoExiste()) {
			Contexto.getCurrentFaceContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", msg));
		}
	}
	
	public static void messageWarnning(String msg)
	{
		if (Contexto.ValidaSeContextoExiste()) {
			Contexto.getCurrentFaceContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_WARN, "Cuidado", msg));
		}
	}
	
	public static void messageError(String msg)
	{
		if (Contexto.ValidaSeContextoExiste()) {
			Contexto.getCurrentFaceContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", msg));
		}
	}	
	
	public static void messageFatal(String msg)
	{
		if (Contexto.ValidaSeContextoExiste()) {
			Contexto.getCurrentFaceContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg));
		}
	}		

}
