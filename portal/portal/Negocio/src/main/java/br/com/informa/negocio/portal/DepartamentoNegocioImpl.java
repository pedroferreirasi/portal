package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.models.portalrh.Departamento;
import br.com.informa.negocio.exception.CampoObrigatorioNullException;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.DepartamentoDao;

public class DepartamentoNegocioImpl implements DepartamentoNegocio {

	@Override
	public void Add(Departamento entity) {
		if (this.validacao(entity)) {
			DepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(Departamento entity) {
		if (this.validacao(entity)) {
			DepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
			entityDao.Update(entity);
		}
	}

	@Override
	public void delete(Departamento entity) {
		DepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		DepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
		entityDao.deleteById(id);
	}

	@Override
	public Departamento getById(Integer pk) {
		DepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Departamento> getListAll() {
		DepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
		return entityDao.getListAll();
	}

	@Override
	public Boolean validacao(Departamento entity) {
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
