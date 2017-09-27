package br.com.informa.repositories.dao.portalrh;

import java.util.List;

import br.com.informa.models.portalrh.Cargo;
import br.com.informa.repositories.dao.IDao; 
 
public interface CargoDao extends IDao<Cargo, Integer> { 
	List<Cargo> getCargoPorNome(String nome);
} 
