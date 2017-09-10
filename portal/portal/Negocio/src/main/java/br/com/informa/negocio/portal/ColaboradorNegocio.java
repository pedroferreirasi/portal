package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.models.common.Usuario;
import br.com.informa.negocio.core.INegocio;

public interface ColaboradorNegocio extends INegocio<Usuario, Integer> {
	List<Usuario> getAniversariantesDoMes(String mes);

}
