package br.com.informa.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import br.com.informa.models.common.GrupoUsuario;
import br.com.informa.models.common.Usuario;
import br.com.informa.services.common.IGrupoUsuarioService;
import br.com.informa.services.common.IUsuarioService;
//import br.com.informa.services.common.UsuarioService;
import br.com.informa.services.core.FactoryService;

public class AppTeste {
	public static void main(String args[]) 
	{
		//testGrupousuario();
		testUsuario();
	}
	
	public static String SHA256(String password, String LoginName)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update((LoginName.trim() + password.trim()).getBytes("ASCII"), 0,
				(LoginName.trim() + password.trim()).getBytes("ASCII").length);
		return bytesToHex(md.digest());
	}	
	
	public static String bytesToHex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (byte byt : bytes)
			result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(
					1));
		return result.toString();
	}	
	
	public static void testUsuario() 
	{
		Usuario entity = new Usuario();
		IUsuarioService entityService = FactoryService.getFactory().getUsuario();
		
		GrupoUsuario grupo = new GrupoUsuario();
		grupo.setId(1);
		
		entity.setLogin("Walter");
		entity.setEmail("walter@hotmail.com");
		entity.setGrupoUsuario(grupo);		
		//entity.setDataCadastro("16/04/2017");
		
		//entity.setDataCadastro(Calendar("16/04/2017"));
		
		try {
			entity.setSenha(SHA256("informa123", entity.getLogin()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		entityService.Add(entity);
	}
	
	public static void testGrupousuario() 
	{		
		GrupoUsuario entity = new GrupoUsuario();
		//entity.setId(2);
		entity.setDescricao("Gerencia de Tecnologia");
		IGrupoUsuarioService entityService = FactoryService.getFactory().getGrupoUsuario();
		entityService.Add(entity);
		
		//entityService.Update(entity);
		//entityService.delete(entity);
		//entityService.deleteById(1);
		
		//List<GrupoUsuario> lista = entityService.getListAll();
		//System.out.println(lista.toString());		
	}

}
