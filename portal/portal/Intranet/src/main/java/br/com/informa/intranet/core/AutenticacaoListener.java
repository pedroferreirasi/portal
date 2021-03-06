package br.com.informa.intranet.core;

import java.util.regex.Pattern;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import br.com.informa.models.common.Usuario;
import br.com.informa.intranet.utils.Contexto;

public class AutenticacaoListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2755420887457934422L;
	private static final String RESTRICTION_PATTERN = "^/pages/.*";
	private static final String RESTRICTION_PATTERN_MANAGER = "^/gerencial/.*";
	private static final String RESTRICTION_PATTERN_ADMINISTRATOR = "^/administrador/.*";

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		String viewId = context.getViewRoot().getViewId();
		Usuario usuario = null;
		
		boolean urlPadraoProtegida = Pattern.matches(RESTRICTION_PATTERN, viewId);
		boolean urlGerencialProtegida = Pattern.matches(RESTRICTION_PATTERN_MANAGER, viewId);
		boolean urlAdministradorProtegida = Pattern.matches(RESTRICTION_PATTERN_ADMINISTRATOR, viewId);

		if (context.getExternalContext().getSessionMap().containsKey("autenticacaoController")) {
			usuario = Contexto.getUsuarioLogado();
		}

		if (urlPadraoProtegida && usuario == null) {
			NavigationHandler navigator = context.getApplication().getNavigationHandler();
			navigator.handleNavigation(context, null, "login");
		}

		if ((urlGerencialProtegida && usuario == null) ||
		   (urlGerencialProtegida && !Contexto.getAutenticacaoController().isGerente())) {
			NavigationHandler navigator = context.getApplication().getNavigationHandler();
			navigator.handleNavigation(context, null, "login");
		}

		if ((urlAdministradorProtegida && usuario == null) || 
		    (urlAdministradorProtegida && !Contexto.getAutenticacaoController().isAdministrador())) {
			NavigationHandler navigator = context.getApplication().getNavigationHandler();
			navigator.handleNavigation(context, null, "login");
		} 
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
