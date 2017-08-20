package br.com.informa.portalrh;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="albumFotosController")
@ViewScoped
public class AlbumFotosController {

    private List<String> imagensCarnaval;
    private List<String> imagensDiaDasMaes;
    private List<String> imagensDiaDosPais;
    private List<String> imagensSaoJoao;
    
    @PostConstruct
    public void init() {
    	imagensCarnaval = new ArrayList<String>();
    	imagensDiaDasMaes = new ArrayList<String>();
    	imagensDiaDosPais = new ArrayList<String>();
    	imagensSaoJoao = new ArrayList<String>();

    	for (int i = 1; i <= 12; i++) {
        	imagensCarnaval.add(i + ".jpg");
        }
        
        for (int i = 1; i <= 7; i++) {
        	imagensDiaDasMaes.add(i + ".jpg");
        }
        
        for (int i = 1; i <= 5; i++) {
        	imagensDiaDosPais.add(i + ".jpg");
        }
        
        for (int i = 1; i <= 11; i++) {
        	imagensSaoJoao.add(i + ".jpg");
        }        
    }
 
    public List<String> getImagensCarnaval() {
        return imagensCarnaval;
    }	
    
    public List<String> getImagensDiaDasMaes() {
        return imagensDiaDasMaes;
    }

	public List<String> getImagensDiaDosPais() {
		return imagensDiaDosPais;
	}

	public List<String> getImagensSaoJoao() {
		return imagensSaoJoao;
	}    
}
