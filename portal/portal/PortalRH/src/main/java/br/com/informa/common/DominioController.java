package br.com.informa.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	
    public ESexo[] getSexo() {
    	sexo = ESexo.values();
        return sexo;
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

}
