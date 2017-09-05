package br.com.informa.negocio.portal;

import java.util.List;
import br.com.informa.models.portalrh.Sala;
import br.com.informa.negocio.exception.CampoObrigatorioNullException;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.SalaDao;

public class SalaNegocioImpl implements SalaNegocio {

	@Override
	public void Add(Sala entity) {
		if (validacao(entity)) {
			SalaDao entityDao = FactoryDao.getFactory().getSalaDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(Sala entity) {
		if (validacao(entity)) {
			SalaDao entityDao = FactoryDao.getFactory().getSalaDao();
			entityDao.Update(entity);
		}
	}

	@Override
	public void delete(Sala entity) {
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao();
		entityDao.deleteById(id);
	}

	@Override
	public Sala getById(Integer pk) {
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Sala> getListAll() {
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao();
		return entityDao.getListAll();
	}

	@Override
	public Boolean validacao(Sala entity) {
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
