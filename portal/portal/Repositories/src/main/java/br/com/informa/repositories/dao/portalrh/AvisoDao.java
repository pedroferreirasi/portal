package br.com.informa.repositories.dao.portalrh;


import java.util.List;

import br.com.informa.models.portalrh.Aviso;
import br.com.informa.repositories.dao.IDao; 
 
public interface AvisoDao extends IDao<Aviso, Integer> { 
	List<Aviso> getAvisosNaoLido(Integer idUsuario);
	List<Aviso> getAllAvisos(Integer idUsuario);
	
} 
