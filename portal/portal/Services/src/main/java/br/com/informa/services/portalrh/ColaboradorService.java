package br.com.informa.services.portalrh;

import java.util.List;
import br.com.informa.libraries.common.CommonMethods;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.ETipoUsuario;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.IColaboradorDao;
import br.com.informa.services.exception.CampoObrigatorioNullException;

public class ColaboradorService implements IColaboradorService {

	@Override
	public void Add(Usuario entity) throws CampoObrigatorioNullException {
		if (validarInsertUpdate(entity)) {
			try {
				String senha = entity.getSenha();
				// entity.setDataCadastro(Calendar.getInstance());
				entity.setSenha(CommonMethods.getInstance().SHA256(senha, entity.getLogin()));
				entity.setTipoUsuario(ETipoUsuario.C);
				IColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
				entityDao.Add(entity);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void Update(Usuario entity) throws CampoObrigatorioNullException {

		if (validarInsertUpdate(entity)) {
			try {
				IColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
				entityDao.Update(entity);
			} catch (Exception e) {

			}
		}
	}

	@Override
	public void delete(Usuario entity) {
		IColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		IColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		entityDao.deleteById(id);
	}

	@Override
	public Usuario getById(Integer pk) {
		IColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Usuario> getListAll() {
		IColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		return entityDao.getListAll();
	}

	private Boolean validarInsertUpdate(Usuario entity) {
		// Valida se foi passado o usuario
		if ((entity.getLogin() == null) || (entity.getLogin().equals(""))) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		if ((entity.getSenha() == null) || (entity.getSenha().equals(""))) {
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
