package br.com.informa.services.common;

import java.util.List;

import br.com.informa.models.common.GrupoUsuario;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.common.GrupoUsuarioDao;
import br.com.informa.services.exception.CampoObrigatorioNullException;

public class GrupoUsuarioServiceImpl implements GrupoUsuarioService {

	@Override
	public void Add(GrupoUsuario entity) {
		if (validacao(entity)) {
			GrupoUsuarioDao entityDao = FactoryDao.getFactory().getGrupoUsuarioDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(GrupoUsuario entity) {
		if (validacao(entity)) {
			GrupoUsuarioDao entityDao = FactoryDao.getFactory().getGrupoUsuarioDao();
			entityDao.Update(entity);
		}
	}

	@Override
	public void delete(GrupoUsuario entity) {
		GrupoUsuarioDao entityDao = FactoryDao.getFactory().getGrupoUsuarioDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		GrupoUsuarioDao entityDao = FactoryDao.getFactory().getGrupoUsuarioDao();
		entityDao.deleteById(id);
	}

	@Override
	public GrupoUsuario getById(Integer pk) {
		GrupoUsuarioDao entityDao = FactoryDao.getFactory().getGrupoUsuarioDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<GrupoUsuario> getListAll() {
		GrupoUsuarioDao entityDao = FactoryDao.getFactory().getGrupoUsuarioDao();
		return entityDao.getListAll();
	}

	@Override
	public Boolean validacao(GrupoUsuario entity) {
		Boolean resultado = true;

		if (entity.getDescricao() == null) {
			resultado = false;
			throw new CampoObrigatorioNullException("Descrição");
		}

		if (entity.getDescricao().equals("")) {
			resultado = false;
			throw new CampoObrigatorioNullException("Descrição");
		}

		return resultado;
	}

}
