package br.com.informa.negocio.common;

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
import br.com.informa.negocio.exception.AutenticacaoException;
import br.com.informa.negocio.exception.CampoObrigatorioNullException;
import br.com.informa.negocio.exception.ForaDoDominioException;
import br.com.informa.negocio.exception.SenhaInvalidoException;
import br.com.informa.negocio.exception.UsuarioInativoException;
import br.com.informa.negocio.exception.UsuarioInvalidoException;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.common.UsuarioDao;

public class UsuarioNegocioImpl implements UsuarioNegocio {

	@Override
	public void Add(Usuario entity) {
		if (validacao(entity)) {
			String senha = entity.getSenha();
			entity.setDataCadastro(new Date());
			
			try {
				entity.setSenha(CommonMethods.getInstance().SHA256(senha, entity.getLogin()));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			entity.setTipoUsuario(ETipoUsuario.U);
			UsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
			entityDao.Add(entity);
		}
	}

	@Override
	public void Update(Usuario entity) {
		if (validacao(entity)) {
			String senha = entity.getSenha();
			
			try {
				entity.setSenha(CommonMethods.getInstance().SHA256(senha, entity.getLogin()));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			UsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
			entityDao.Update(entity);
		}
	}

	@Override
	public void delete(Usuario entity) {
		UsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		entityDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		UsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		entityDao.deleteById(id);
	}

	@Override
	public Usuario getById(Integer pk) {
		UsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		return entityDao.getById(pk);
	}

	@Override
	public List<Usuario> getListAll() {
		UsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		return entityDao.getListAll();
	}

	@Override
	public Usuario login(Usuario entity) {

		Usuario entityBanco;
		UsuarioDao entityDao = FactoryDao.getFactory().getUsuarioDao();
		boolean autenticadoPeloWindows = false;

		// Valida se foi passado o usuario
		if (entity.getLogin() == null) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		// Valida se foi passado o usuario
		if (entity.getLogin().equals("")) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		if (entity.getSenha() == null) {
			throw new CampoObrigatorioNullException("Senha");
		}

		if (entity.getSenha().equals("")) {
			throw new CampoObrigatorioNullException("Senha");
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
					try {
						entity = entityBanco.clone();
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return entityBanco;
				} else {
					throw new SenhaInvalidoException();
				}
			} else {
				try {
					entity = entityBanco.clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				entityBanco.setSenha(entity.getSenha());
				this.Update(entityBanco);
				return entityBanco;
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

	@Override
	public Boolean validacao(Usuario entity) {
		// Valida se foi passado o usuario
		// Valida se foi passado o usuario
		if (entity.getNomeUsuario() == null) {
			throw new CampoObrigatorioNullException("Nome");
		}

		// Valida se foi passado o usuario
		if (entity.getNomeUsuario().equals("")) {
			throw new CampoObrigatorioNullException("Nome");
		}

		// Valida se foi passado o usuario
		if (entity.getSobreNome() == null) {
			throw new CampoObrigatorioNullException("Sobrenome");
		}

		// Valida se foi passado o usuario
		if (entity.getSobreNome().equals("")) {
			throw new CampoObrigatorioNullException("Sobrenome");
		}

		// Valida se foi passado o usuario
		if (entity.getLogin() == null) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		// Valida se foi passado o usuario
		if (entity.getLogin().equals("")) {
			throw new CampoObrigatorioNullException("Usuario");
		}

		// Valida se foi passado o senha
		if (entity.getSenha() == null) {
			throw new CampoObrigatorioNullException("Senha");
		}

		// Valida se foi passado o senha
		if (entity.getSenha().equals("")) {
			throw new CampoObrigatorioNullException("Senha");
		}

		if (entity.getGrupoUsuario().getId() == 0) {
			throw new CampoObrigatorioNullException("Grupo de Usuário");
		}

		// ativo, login, senha, email e grupo de usuário
		return true;
	}

}
