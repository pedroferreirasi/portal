package br.com.informa.services.portalrh;

import java.util.List;
import br.com.informa.models.portalrh.Mural;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.MuralDao;

public class MuralServiceImpl implements MuralService {

	@Override
	public void Add(Mural entity) {
		if (validacao(entity)) {
			MuralDao entityDao = FactoryDao.getFactory().getMuralDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(Mural entity) {
		MuralDao entityDao = FactoryDao.getFactory().getMuralDao();
		entityDao.Update(entity);
	}

	@Override
	public void delete(Mural entity) {
		MuralDao entityDao = FactoryDao.getFactory().getMuralDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		MuralDao entityDao = FactoryDao.getFactory().getMuralDao();
		entityDao.deleteById(id);
	}

	@Override
	public Mural getById(Integer pk) {
		MuralDao entityDao = FactoryDao.getFactory().getMuralDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Mural> getListAll() {
		MuralDao entityDao = FactoryDao.getFactory().getMuralDao();
		return entityDao.getListAll();
	}

	@Override
	public Boolean validacao(Mural entity) {
		// TODO Auto-generated method stub
		return true;
	}
}
