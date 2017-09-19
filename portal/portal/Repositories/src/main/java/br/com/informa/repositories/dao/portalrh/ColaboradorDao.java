package br.com.informa.repositories.dao.portalrh;

import java.util.List;

import br.com.informa.models.common.Usuario;
import br.com.informa.repositories.dao.IDao;

public interface ColaboradorDao extends IDao<Usuario, Integer> {
	Usuario getUserLogin(String loginName);
	List<Usuario> getAniversariantesDoMes(String mes);
	List<Usuario> getColaboradoresPorChefia(Integer idChefia);
	List<Usuario> getColaboradoresPorCargo(Integer idCargo);
	List<Usuario> getColaboradoresPorNome(String nome);
}
