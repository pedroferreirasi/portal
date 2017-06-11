package br.com.informa.services.portalrh;

import java.util.List;
import br.com.informa.models.portalrh.Cargo;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.CargoDao;
import br.com.informa.services.exception.CampoObrigatorioNullException;

public class CargoServiceImpl implements CargoService {

	@Override
	public void Add(Cargo entity) {
		if (validacao(entity)) {
			CargoDao entityDao = FactoryDao.getFactory().getCargoDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(Cargo entity) {
		if (validacao(entity)) {
			CargoDao entityDao = FactoryDao.getFactory().getCargoDao();
			entityDao.Update(entity);
		}
	}

	@Override
	public void delete(Cargo entity) {
		CargoDao entityDao = FactoryDao.getFactory().getCargoDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		CargoDao entityDao = FactoryDao.getFactory().getCargoDao();
		entityDao.deleteById(id);
	}

	@Override
	public Cargo getById(Integer pk) {
		CargoDao entityDao = FactoryDao.getFactory().getCargoDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Cargo> getListAll() {
		CargoDao entityDao = FactoryDao.getFactory().getCargoDao();
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
