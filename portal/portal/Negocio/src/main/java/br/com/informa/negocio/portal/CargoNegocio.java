package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.models.portalrh.Cargo;
import br.com.informa.negocio.core.INegocio; 
 
public interface CargoNegocio extends INegocio<Cargo, Integer> { 
	List<Cargo> getCargoPorNome(String nome);

} 
