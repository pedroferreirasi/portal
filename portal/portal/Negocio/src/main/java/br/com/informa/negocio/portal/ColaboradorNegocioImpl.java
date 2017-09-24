package br.com.informa.negocio.portal;

import java.util.List;

import br.com.informa.libraries.common.CommonMethods;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.ETipoUsuario;
import br.com.informa.negocio.exception.CampoObrigatorioNullException;
import br.com.informa.negocio.exception.EmailInvalidoException;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.ColaboradorDao;

public class ColaboradorNegocioImpl implements ColaboradorNegocio {

	@Override
	public void Add(Usuario entity) throws CampoObrigatorioNullException {
		if (validacao(entity)) {
			try {
				entity.setTipoUsuario(ETipoUsuario.C);
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
		if ((entity.getNomeCompleto() == null) || (entity.getNomeCompleto().equals(""))) {
			throw new CampoObrigatorioNullException("Nome Completo");
		}
		
		if ((entity.getNomeUsuario() == null) || (entity.getNomeUsuario().equals(""))) {
			throw new CampoObrigatorioNullException("Nome");
		}
		
		if ((entity.getSobreNome() == null) || (entity.getSobreNome().equals(""))) {
			throw new CampoObrigatorioNullException("Sobrenome");
		}	
		
		if ((entity.getEmail() == null) || (entity.getEmail().equals(""))) {
			throw new CampoObrigatorioNullException("e-mail");
		} else if (!CommonMethods.getInstance().validarEmail(entity.getEmail())) {
			throw new EmailInvalidoException();
		}
		
		// Valida se foi passado o usuario
		if ((entity.getLogin() == null) || (entity.getLogin().equals(""))) {
			throw new CampoObrigatorioNullException("Login");
		}

		if (entity.getGrupoUsuario().getId() == 0) {
			throw new CampoObrigatorioNullException("Grupo de Usuário");
		}
		
		if (entity.getDadosPessoais() != null) {
			if ((entity.getDadosPessoais().getDataNascimento() == null) ||
			    (entity.getDadosPessoais().getDataNascimento().toString() == "")) {
				throw new CampoObrigatorioNullException("Data de Nascimento");
			}/* else if (!DateUtils.getInstance().getDataValida((new SimpleDateFormat("dd/MM/yyyy")).format(entity.getDadosPessoais().getDataNascimento()))) {
				throw new DataInvalidaException("Data de Nascimento");
			}*/
		}

		// ativo, login, senha, email e grupo de usuário
		return true;
	}

	@Override
	public List<Usuario> getAniversariantesDoMes(String mes) {
		ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		return entityDao.getAniversariantesDoMes(mes);
	}

	@Override
	public Usuario getUserLogin(String loginName) {
		ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		return entityDao.getUserLogin(loginName);
	}

	@Override
	public List<Usuario> getColaboradoresPorChefia(Integer idChefia) {
		ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		return entityDao.getColaboradoresPorChefia(idChefia);
	}

	@Override
	public List<Usuario> getColaboradoresPorCargo(Integer idCargo) {
		ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		return entityDao.getColaboradoresPorCargo(idCargo);
	}

	@Override
	public List<Usuario> getColaboradoresPorNome(String nome) {
		ColaboradorDao entityDao = FactoryDao.getFactory().getColaboradorDao();
		return entityDao.getColaboradoresPorNome(nome);
	}

}
