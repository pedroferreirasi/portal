package br.com.informa.services.common;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import br.com.informa.libraries.common.CommonMethods;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.ETipoUsuario;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.common.IUsuarioDao;
import br.com.informa.services.exception.UsuarioInvalidoException;
import br.com.informa.services.exception.SenhaInvalidoException;
import br.com.informa.services.exception.UsuarioInativoException;
import br.com.informa.services.exception.AutenticacaoException;
import br.com.informa.services.exception.CampoObrigatorioNullException;
import br.com.informa.services.exception.ForaDoDominioException;

public class UsuarioService implements IUsuarioService {

	@Override
	public void Add(Usuario entity) {
		try {
			if (validarInsertUpdate(entity)) {
				String senha = entity.getSenha();
				entity.setDataCadastro(new Date());
				entity.setSenha(CommonMethods.getInstance().SHA256(senha, entity.getLogin()));
				entity.setTipoUsuario(ETipoUsuario.U);
				IUsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
				entityDao.Add(entity);
			}
		} catch (Exception e) {

		}
	}

	@Override
	public void Update(Usuario entity) {
		try {
			if (validarInsertUpdate(entity)) {
				String senha = entity.getSenha();
				entity.setSenha(CommonMethods.getInstance().SHA256(senha, entity.getLogin()));
				IUsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
				entityDao.Update(entity);
			}
		} catch (Exception e) {

		}
	}

	@Override
	public void delete(Usuario entity) {
		IUsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		IUsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		entityDao.deleteById(id);
	}

	@Override
	public Usuario getById(Integer pk) {
		IUsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Usuario> getListAll() {
		IUsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		return entityDao.getListAll();
	}

	private Boolean validarInsertUpdate(Usuario entity) {
		// Valida se foi passado o usuario
		if (entity.getLogin() == null) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		if (entity.getSenha() == null) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		if (entity.getEmail() == null) {
			throw new CampoObrigatorioNullException("E-Mail");
		}

		if (entity.getGrupoUsuario().getId() == 0) {
			throw new CampoObrigatorioNullException("Grupo de Usuário");
		}

		// ativo, login, senha, email e grupo de usuário
		return true;
	}

	@Override
	public Boolean login(Usuario entity) {

		Usuario entityBanco;
		IUsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		boolean autenticadoPeloWindows = false;

		// Valida se foi passado o usuario
		if (entity.getLogin() == null) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		if (entity.getSenha() == null) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		try {
			autenticadoPeloWindows = this.loginPeloWindows(entity);
		} catch (Exception e) {

		}

		// login é uma chave unica que é a mesma de rede
		entityBanco = entityDao.getUserLogin(entity.getLogin());

		// Se não encontrou no banco nem foi validado pelo windows
		if ((entityBanco == null) && (!autenticadoPeloWindows)) {
			throw new UsuarioInvalidoException();
		} else if ((entityBanco == null) && (autenticadoPeloWindows)) {
			entity = null;
		}

		if (entityBanco != null) {
			if (!entityBanco.getAtivo()) {
				throw new UsuarioInativoException();
			}
		}

		// Compara a senha digitada criptografada com a senha do banco
		try {
			if (!autenticadoPeloWindows) {
				if (CommonMethods.getInstance().SHA256(entity.getSenha(), entity.getLogin())
						.equals(entityBanco.getSenha())) {
					entityBanco.clone(entity);
					return true;
				} else {
					throw new SenhaInvalidoException();
				}
			} else {
				entityBanco.clone(entity);
				return true;
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean loginPeloWindows(Usuario entity) {
		Hashtable<String, String> authEnv = new Hashtable<String, String>(11);
		authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		authEnv.put(Context.PROVIDER_URL, "ldap://192.168.0.1:389");
		authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		authEnv.put(Context.SECURITY_PRINCIPAL, entity.getLogin() + "@informa.com.br");
		authEnv.put(Context.SECURITY_CREDENTIALS, entity.getSenha());
		// ----------------------------------------------------------------
		try {
			DirContext authContext = new InitialDirContext(authEnv);
			System.out.println("logado");
			authContext.close();
			return true;

		} catch (AuthenticationException authEx) {
			throw new AutenticacaoException();
		} catch (NamingException namEx) {
			throw new ForaDoDominioException();
		}

	}

}
