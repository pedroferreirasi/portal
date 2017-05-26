package br.com.informa.repositories.dao.portalrh;

import br.com.informa.models.common.Usuario;
import br.com.informa.repositories.dao.IDao;

public interface IColaboradorDao extends IDao<Usuario, Integer> {
	Usuario getUserLogin(String loginName);
}
