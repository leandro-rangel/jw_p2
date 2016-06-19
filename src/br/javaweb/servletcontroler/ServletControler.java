package br.javaweb.servletcontroler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.javaweb.service.IService;
import br.javaweb.util.FormBuild;
import br.javaweb.util.IFormBuild;
import br.javaweb.util.WebResource;


public class ServletControler extends HttpServlet {

	private static final long serialVersionUID = 4335320875411888578L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String service = request.getParameter("service");
		
		if(service.contains(".jsp")){
			request.getRequestDispatcher(service).forward(request,response); 
		
		}else{
		
			IService iService = null;
			
			String nomeClazz = ((Map<String, String>)request.getServletContext().getAttribute(WebResource.MAPA_SERVICES)).get(service);
			Object form = null;
			try {
				iService = (IService) Class.forName(nomeClazz).newInstance();
			
				IFormBuild formBuild = new FormBuild();
				form = formBuild.formBuild(request);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			request.getRequestDispatcher(iService.execute(request, response, form)).forward(request,response);  
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	
}
