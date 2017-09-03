package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.models.portalrh.Ferias;
import br.com.informa.negocio.core.INegocio; 
 
public interface FeriasNegocio extends INegocio<Ferias, Integer> { 
	List<Ferias> getListAllByUsuario(Integer idUsuario);
} 
