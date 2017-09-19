package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.models.common.Usuario;
import br.com.informa.negocio.core.INegocio;

public interface ColaboradorNegocio extends INegocio<Usuario, Integer> {
	Usuario getUserLogin(String loginName);
	List<Usuario> getAniversariantesDoMes(String mes);
	List<Usuario> getColaboradoresPorChefia(Integer idChefia);
	List<Usuario> getColaboradoresPorCargo(Integer idCargo);
	List<Usuario> getColaboradoresPorNome(String nome);

}
