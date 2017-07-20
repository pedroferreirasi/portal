package br.com.informa.services.portalrh;

import java.util.List;

import br.com.informa.libraries.common.CommonMethods;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.ETipoUsuario;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.ColaboradorDao;
import br.com.informa.services.exception.CampoObrigatorioNullException;

public class ColaboradorServiceImpl implements ColaboradorService {

	@Override
	public void Add(Usuario entity) throws CampoObrigatorioNullException {
		if (validacao(entity)) {
			try {
				entity.setTipoUsuario(ETipoUsuario.C);
				entity.getCargo().setId(2);
				entity.setSenha(CommonMethods.getInstance().SHA256("informa", entity.getLogin()));
				ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
				entityDao.Add(entity);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void Update(Usuario entity) throws CampoObrigatorioNullException {

		if (validacao(entity)) {
			try {
				ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
				entityDao.Update(entity);
			} catch (Exception e) {

			}
		}
	}

	@Override
	public void delete(Usuario entity) {
		ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		entityDao.deleteById(id);
	}

	@Override
	public Usuario getById(Integer pk) {
		ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Usuario> getListAll() {
		ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		return entityDao.getListAll();
	}

	@Override
	public Boolean validacao(Usuario entity) {
		// Valida se foi passado o usuario
		if ((entity.getLogin() == null) || (entity.getLogin().equals(""))) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		if ((entity.getEmail() == null) || (entity.getEmail().equals(""))) {
			throw new CampoObrigatorioNullException("E-Mail");
		}

		if (entity.getGrupoUsuario().getId() == 0) {
			throw new CampoObrigatorioNullException("Grupo de Usuário");
		}

		// ativo, login, senha, email e grupo de usuário
		return true;
	}

}
