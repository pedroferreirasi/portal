package br.com.informa.services.portalrh;

import java.util.List;
import br.com.informa.models.portalrh.Cargo;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.ICargoDao;
import br.com.informa.services.exception.CampoObrigatorioNullException;

public class CargoService implements ICargoService {

	@Override
	public void Add(Cargo entity) {
		if (validacao(entity)) {
			ICargoDao entityDao = FactoryDao.getFactory().getCargoDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(Cargo entity) {
		if (validacao(entity)) {
			ICargoDao entityDao = FactoryDao.getFactory().getCargoDao();
			entityDao.Update(entity);
		}
	}

	@Override
	public void delete(Cargo entity) {
		ICargoDao entityDao = FactoryDao.getFactory().getCargoDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		ICargoDao entityDao = FactoryDao.getFactory().getCargoDao();
		entityDao.deleteById(id);
	}

	@Override
	public Cargo getById(Integer pk) {
		ICargoDao entityDao = FactoryDao.getFactory().getCargoDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Cargo> getListAll() {
		ICargoDao entityDao = FactoryDao.getFactory().getCargoDao();
		return entityDao.getListAll();
	}

	@Override
	public Boolean validacao(Cargo entity) {
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
