package br.com.informa.portalrh;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import br.com.informa.libraries.common.CommonMethods;
import br.com.informa.models.common.GrupoUsuario;
import br.com.informa.models.common.Usuario;
import br.com.informa.services.common.IGrupoUsuarioService;
import br.com.informa.services.common.IUsuarioService;
import br.com.informa.services.core.FactoryService;

public class AppTeste {
	public static void main(String args[]) 
	{
		//testGrupousuario();
		//testUsuario();
		
		//reflectionteste();
		
		loginwindows();
		
	}
	
	public static void loginwindows()
	{
		Hashtable<String, String> authEnv = new Hashtable<String, String>(11);
		authEnv.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		authEnv.put(Context.PROVIDER_URL, "ldap://192.168.0.1:389");
		authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		authEnv.put(Context.SECURITY_PRINCIPAL, "phferreira@informa.com.br");
		authEnv.put(Context.SECURITY_CREDENTIALS, "Informa123");
		//----------------------------------------------------------------
		try
		{
		DirContext authContext = new InitialDirContext(authEnv);
		System.out.println("logado");
		authContext.close();

		}
		catch (AuthenticationException authEx)
		{
			System.out.println("Erro na autenticação! Tente novamente.");
			authEx.printStackTrace();
		}
		catch (NamingException namEx)
		{
			//out.println("Problemas na conexÃ£o! ");
			System.out.println("Problemas na conexão! Sua maquina pode estar fora da rede. Contate o Suporte Tecnico");
			namEx.getCause().printStackTrace();
		}
	}
	
	public static Object runGetter(String field, Usuario o)
	{
		
	    // MZ: Find the correct method
	    for (Method method : o.getClass().getMethods())
	    {
	        if ((method.getName().startsWith("get")) && (method.getName().length() == (field.length() + 3)))
	        {
	            if (method.getName().toLowerCase().endsWith(field.toLowerCase()))
	            {
	                // MZ: Method found, run it
	                try
	                {
	                    return method.invoke(o);
	                }
	                catch (IllegalAccessException e)
	                {
	                    
	                }
	                catch (InvocationTargetException e)
	                {
	                    
	                }

	            }
	        }
	    }


	    return null;
	}
	
	
	public static String getValorAtributo(String atributo)
	{
		Usuario entity = new Usuario();
		String valor = null;
		
		try {
			Field f = entity.getClass().getDeclaredField(atributo);
			f.setAccessible(true);
			valor = (String) f.get(entity);
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //NoSuchFieldException
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return valor;
	}
	
	public static void reflectionteste() 
	{
		Usuario entity = new Usuario();
		GrupoUsuario grupo = new GrupoUsuario();
		grupo.setId(1);
		
		entity.setLogin("pedro");
		entity.setEmail("phferreira@informa.com.br");
		entity.setGrupoUsuario(grupo);		
		//entity.setDataCadastro("16/04/2017");
		entity.setAtivo(true);
		entity.setNomeUsuario("pedro");
		entity.setSobreNomeUsuario("Ferreira");
		//String valor = null;


		//String teste = (String) runGetter("login", entity);
		Class<?> classe = entity.getClass();
		
		for (Field atributo : classe.getDeclaredFields()) {
		  System.out.println(atributo.getName());      
		}
		

	}
	
	public static void testUsuario() 
	{
		Usuario entity = new Usuario();
		IUsuarioService entityService = FactoryService.getFactory().getUsuario();
		
		GrupoUsuario grupo = new GrupoUsuario();
		grupo.setId(1);
		
		entity.setLogin("pedro");
		entity.setEmail("phferreira@informa.com.br");
		entity.setGrupoUsuario(grupo);		
		//entity.setDataCadastro("16/04/2017");
		entity.setAtivo(true);
		entity.setNomeUsuario("pedro");
		entity.setSobreNomeUsuario("Ferreira");
		
		//entity.setDataCadastro(Calendar("16/04/2017"));
		
		try {
			
			entity.setSenha(CommonMethods.getInstance().SHA256("123456", entity.getLogin()));
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
