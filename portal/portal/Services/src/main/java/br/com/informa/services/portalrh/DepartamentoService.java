package br.com.informa.services.portalrh;

import java.util.List;
import br.com.informa.models.portalrh.Departamento;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.IDepartamentoDao;
import br.com.informa.services.exception.CampoObrigatorioNullException;

public class DepartamentoService implements IDepartamentoService {

	@Override
	public void Add(Departamento entity) {
		if (this.validacao(entity)) {
			IDepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(Departamento entity) {
		IDepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
		entityDao.Update(entity);
	}

	@Override
	public void delete(Departamento entity) {
		IDepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		IDepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
		entityDao.deleteById(id);
	}

	@Override
	public Departamento getById(Integer pk) {
		IDepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Departamento> getListAll() {
		IDepartamentoDao entityDao = FactoryDao.getFactory().getDepartamentoDao();
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
