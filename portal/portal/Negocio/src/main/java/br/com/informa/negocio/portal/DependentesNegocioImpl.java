package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.models.portalrh.Dependentes;
import br.com.informa.negocio.exception.CampoObrigatorioNullException;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.DependentesDao;

public class DependentesNegocioImpl implements DependentesNegocio {

	@Override
	public void Add(Dependentes entity) {
		if (validacao(entity)) {
			DependentesDao entityDao = FactoryDao.getFactory().getDependentesDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(Dependentes entity) {
		if (validacao(entity)) {
			DependentesDao entityDao = FactoryDao.getFactory().getDependentesDao();
			entityDao.Update(entity);
		}
	}

	@Override
	public void delete(Dependentes entity) {
		DependentesDao entityDao = FactoryDao.getFactory().getDependentesDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		DependentesDao entityDao = FactoryDao.getFactory().getDependentesDao();
		entityDao.deleteById(id);
	}

	@Override
	public Dependentes getById(Integer pk) {
		DependentesDao entityDao = FactoryDao.getFactory().getDependentesDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Dependentes> getListAll() {
		DependentesDao entityDao = FactoryDao.getFactory().getDependentesDao();
		return entityDao.getListAll();
	}

	@Override
	public Boolean validacao(Dependentes entity) {
		Boolean resultado = true;

		if (entity.getNome() == null) {
			resultado = false;
			throw new CampoObrigatorioNullException("Nome");
		}

		if (entity.getNome().equals("")) {
			resultado = false;
			throw new CampoObrigatorioNullException("Nome");
		}

		return resultado;
	}
}
