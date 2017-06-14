package br.com.informa.services.portalrh;

import java.util.List;

import br.com.informa.models.portalrh.Ferias;
import br.com.informa.services.common.IService; 
 
public interface FeriasService extends IService<Ferias, Integer> { 
	List<Ferias> getListAllByUsuario(Integer idUsuario);
} 
