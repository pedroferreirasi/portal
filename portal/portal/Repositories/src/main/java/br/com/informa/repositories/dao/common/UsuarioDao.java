package br.com.informa.repositories.dao.common;

import br.com.informa.models.common.Usuario;
import br.com.informa.repositories.dao.IDao;

public interface UsuarioDao extends IDao<Usuario, Integer> {
	Usuario getUserLogin(String loginName);
}
