package br.com.informa.negocio.common;

import br.com.informa.models.common.Usuario;
import br.com.informa.negocio.core.INegocio;

public interface UsuarioNegocio extends INegocio<Usuario, Integer> {
	Usuario login(Usuario entity);
	boolean loginPeloWindows(Usuario entity);

}
