package br.com.informa.intranet.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.informa.models.common.Usuario;

@FacesConverter("colaboradorConverter")
public class ColaboradorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equals("0")) {
            /*try {
             	ColaboradorController controller = (ColaboradorController) Contexto.getContextoViewScoped("colaboradorController");
             	for (Usuario usuario : controller.getResultado()) {
             		if (usuario.getId() == Integer.parseInt(value)) {
             			return usuario;
             		}
             	}
                return null;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }*/
        	return null;
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Usuario) object).getId());
        }
        else {
            return null;
        }
	}

}
