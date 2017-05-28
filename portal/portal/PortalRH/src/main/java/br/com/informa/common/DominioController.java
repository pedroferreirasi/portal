package br.com.informa.common;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.models.dominio.EBanco;
import br.com.informa.models.dominio.EEstadoCivil;
import br.com.informa.models.dominio.EEstadosBrasil;
import br.com.informa.models.dominio.ESexo;
import br.com.informa.models.dominio.ETipoGrupoUsuario;
import br.com.informa.models.dominio.ETipoLogradouro;

@ManagedBean(name = "dominioController")
@ViewScoped
public class DominioController {
	
	private ESexo[] sexo;
	private ETipoGrupoUsuario[] tipoGrupoUsuario;
	private EEstadoCivil[] estadoCivil;
	private EEstadosBrasil[] estadosBrasil;
	private ETipoLogradouro[] tipoLogradouro;
	private EBanco[] bancos;
	private List<String> tipoLogradouroList;
	
    public ESexo[] getSexo() {
    	sexo = ESexo.values();
        return sexo;
    }
    
    public EBanco[] getBancos() {
    	bancos = EBanco.values();
    	return bancos;
    }
    
    public ETipoGrupoUsuario[] getTipoGrupoUsuario()
    {
    	tipoGrupoUsuario = ETipoGrupoUsuario.values(); 
    	return tipoGrupoUsuario;
    }
    
    public EEstadoCivil[] getEstadoCivil()
    {
    	estadoCivil = EEstadoCivil.values(); 
    	return estadoCivil;
    }
    
    public EEstadosBrasil[] getEstadosBrasil()
    {
    	estadosBrasil = EEstadosBrasil.values(); 
    	return estadosBrasil;
    }
    
    public ETipoLogradouro[] getTipoLogradouro()
    {
    	tipoLogradouro = ETipoLogradouro.values(); 
    	return tipoLogradouro;
    }
    
    public List<String> getTipoLogradouroList()
    {
    	tipoLogradouro = ETipoLogradouro.values();
    	if (tipoLogradouroList == null) {
    		tipoLogradouroList = new ArrayList<String>();
    	}

    	for (int i = 0; i < tipoLogradouro.length; i++) {    	
			tipoLogradouroList.add(tipoLogradouro[i].toString());
		}
    	return tipoLogradouroList;
    }    

}
