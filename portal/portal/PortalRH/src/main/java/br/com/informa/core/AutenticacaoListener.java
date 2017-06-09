package br.com.informa.core;

import java.util.regex.Pattern;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

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
		
		boolean urlPadraoProtegida = Pattern.matches(RESTRICTION_PATTERN, viewId);
		boolean urlGerencialProtegida = Pattern.matches(RESTRICTION_PATTERN_MANAGER, viewId);
		boolean urlAdministradorProtegida = Pattern.matches(RESTRICTION_PATTERN_ADMINISTRATOR, viewId);
		
		Object usuario = context.getExternalContext().getSessionMap().get("ususario");	
		
		if(urlPadraoProtegida && usuario == null) 
		{
			NavigationHandler navigator = context.getApplication().getNavigationHandler();
			navigator.handleNavigation(context, null, "login");			
		}	
		
		if(urlGerencialProtegida && usuario == null)
		{
			NavigationHandler navigator = context.getApplication().getNavigationHandler();
			navigator.handleNavigation(context, null, "login");				
		}
		
		if(urlAdministradorProtegida && usuario == null)
		{
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
