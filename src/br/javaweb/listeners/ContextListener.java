package br.javaweb.listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.javaweb.dao.ClienteDAO;
import br.javaweb.dao.ProdutoDAOImpl;
import br.javaweb.util.JavaWebException;
import br.javaweb.util.ProjetClassDiscover;
import br.javaweb.util.WebResource;
import br.javaweb.util.anotacao.Form;
import br.javaweb.util.anotacao.Service;


public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		
		if(contextEvent.getServletContext().getAttribute(WebResource.MAPA_SERVICES) != null){
			return;
		}
		
		Map<String, String> mapaService = new HashMap<>();
		Map<String, String> mapaForm = new HashMap<>();
		
		try {
			for(Class c: new ProjetClassDiscover().getClasses("br.javaweb.service", Service.class)){
				String name = ((Service) c.getAnnotation(Service.class)).nome();
				mapaService.put(name, c.getCanonicalName());
			}
			
			for(Class c: new ProjetClassDiscover().getClasses("br.javaweb.form", Form.class)){
				String name = ((Form) c.getAnnotation(Form.class)).nome();
				mapaForm.put(name, c.getCanonicalName());
			}
			
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		
		contextEvent.getServletContext().setAttribute(WebResource.MAPA_SERVICES, mapaService);
		contextEvent.getServletContext().setAttribute(WebResource.MAPA_FORMS, mapaForm);
		
		try {
			new ProdutoDAOImpl().createTable();
			new ClienteDAO().createTable();
			
		} catch (JavaWebException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
