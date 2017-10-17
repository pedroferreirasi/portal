package br.com.informa.negocio.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.informa.models.portalrh.Cargo;
import br.com.informa.negocio.exception.CampoObrigatorioNullException;
import br.com.informa.repositories.dao.portalrh.CargoDao;

public class CargoNegocioImpl implements CargoNegocio {

	@Autowired
	@Qualifier("CargoDaoImpl")
	private CargoDao entityDao;
	
	@Override
	public void Add(Cargo entity) {
		if (validacao(entity)) {
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(Cargo entity) {
		if (validacao(entity)) {
			entityDao.Update(entity);
		}
	}

	@Override
	public void delete(Cargo entity) {
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		entityDao.deleteById(id);
	}

	@Override
	public Cargo getById(Integer pk) {
		return entityDao.getById(pk);
	}

	@Override
	public List<Cargo> getListAll() {
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

	@Override
	public List<Cargo> getCargoPorNome(String nome) {
		return entityDao.getCargoPorNome(nome);
	}
}
