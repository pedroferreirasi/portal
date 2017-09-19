package br.com.informa.repositories.dao.portalrh;

import java.util.List;
import br.com.informa.models.portalrh.AvisoDestinatario;
import br.com.informa.repositories.dao.IDao; 
 
public interface AvisoDestinatarioDao extends IDao<AvisoDestinatario, Integer> { 
	List<AvisoDestinatario> getAvisosPorUsuario(Integer pk);
} 
