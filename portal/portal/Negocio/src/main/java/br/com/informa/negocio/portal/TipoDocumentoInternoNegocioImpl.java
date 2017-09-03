package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.models.portalrh.TipoDocumentoInterno;
import br.com.informa.negocio.exception.CampoObrigatorioNullException;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.TipoDocumentoInternoDao;

public class TipoDocumentoInternoNegocioImpl implements TipoDocumentoInternoNegocio {

	@Override
	public void Add(TipoDocumentoInterno entity) {
		if (validacao(entity)) {
			TipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(TipoDocumentoInterno entity) {
		if (validacao(entity)) {
			TipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao();
			entityDao.Update(entity);
		}
	}

	@Override
	public void delete(TipoDocumentoInterno entity) {
		TipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		TipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao();
		entityDao.deleteById(id);
	}

	@Override
	public TipoDocumentoInterno getById(Integer pk) {
		TipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<TipoDocumentoInterno> getListAll() {
		TipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao();
		return entityDao.getListAll();
	}

	@Override
	public Boolean validacao(TipoDocumentoInterno entity) {
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
