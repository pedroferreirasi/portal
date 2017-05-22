package br.com.informa.services.common;

import br.com.informa.models.common.Usuario;

public interface IUsuarioService extends IService<Usuario, Integer> {
	Boolean login(Usuario entity);
	boolean loginPeloWindows(Usuario entity);

}
