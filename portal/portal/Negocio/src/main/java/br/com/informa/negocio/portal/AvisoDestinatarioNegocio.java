package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.models.portalrh.AvisoDestinatario;
import br.com.informa.negocio.core.INegocio; 
 
public interface AvisoDestinatarioNegocio extends INegocio<AvisoDestinatario, Integer> { 
	List<AvisoDestinatario> getAvisosPorUsuario(Integer idUsuario);
	List<AvisoDestinatario> getAvisosNaoLido(Integer idUsuario);
} 
