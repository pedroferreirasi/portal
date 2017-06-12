package br.com.informa.utils;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class Mensagens extends FacesContext implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void erroNaOperacao() {
		if (ValidaSeContextoExiste())
		{
			messageFatal(Constantes.ERRO_NA_OPERACAO);
		}
	}
	
	public static void OperacaoRealizadaComSucesso() {
		if (ValidaSeContextoExiste())
		{
			messageInformation(Constantes.OPERACAO_REALIZADA_COM_SUCESSO);
		}
	}	
	
	public static FacesContext getCurrentFaceContext(){
		return FacesContext.getCurrentInstance();
	}
	
	public static boolean ValidaSeContextoExiste() {
		return FacesContext.getCurrentInstance() != null;
	}
	
	public static void messageInformation(String msg)
	{
		if (ValidaSeContextoExiste()) {
			getCurrentFaceContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		}
	}
	
	public static void messageWarnning(String msg)
	{
		if (ValidaSeContextoExiste()) {
			getCurrentFaceContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
		}
	}
	
	public static void messageError(String msg)
	{
		if (ValidaSeContextoExiste()) {
			getCurrentFaceContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}	
	
	public static void messageFatal(String msg)
	{
		if (ValidaSeContextoExiste()) {
			getCurrentFaceContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg));
		}
	}		

}
