package br.com.informa.services.common;

import br.com.informa.models.common.Usuario;

public interface UsuarioService extends IService<Usuario, Integer> {
	Usuario login(Usuario entity);
	boolean loginPeloWindows(Usuario entity);

}
