package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.models.portalrh.Aviso;
import br.com.informa.negocio.core.INegocio; 
 
public interface AvisoNegocio extends INegocio<Aviso, Integer> {
	List<Aviso> getAvisosNaoLido(Integer idUsuario);
	List<Aviso> getAllAvisos(Integer idUsuario);
} 
