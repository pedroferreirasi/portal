package br.com.informa.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.models.dominio.ESexo;
import br.com.informa.models.dominio.TipoGrupoUsuario;

@ManagedBean(name = "dominioController")
@ViewScoped
public class DominioController {
	
	private ESexo[] sexo;
	private TipoGrupoUsuario[] tipoGrupoUsuario;
	
    public ESexo[] getSexo() {
    	sexo = ESexo.values();
        return sexo;
    }
    
    public TipoGrupoUsuario[] getTipoGrupoUsuario()
    {
    	tipoGrupoUsuario = TipoGrupoUsuario.values(); 
    	return tipoGrupoUsuario;
    }

}
