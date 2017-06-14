package br.com.informa.repositories.dao.portalrh;

import java.util.List;

import br.com.informa.models.portalrh.Ferias; 
import br.com.informa.repositories.dao.IDao; 
 
public interface FeriasDao extends IDao<Ferias, Integer> {
	List<Ferias> getListAllByUsuario(Integer idUsuario);
} 
