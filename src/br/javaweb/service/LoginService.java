package br.javaweb.service;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.javaweb.beans.Cliente;
import br.javaweb.dao.ClienteDAO;
import br.javaweb.dao.IClienteDAO;
import br.javaweb.form.LoginForm;
import br.javaweb.util.JavaWebException;
import br.javaweb.util.MsgUtil;
import br.javaweb.util.WebResource;
import br.javaweb.util.anotacao.Service;


@Service(nome="login")
public class LoginService implements IService, Serializable {

	private static final long serialVersionUID = 8866256049023938414L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, Object objForm) throws ServletException, IOException {

		LoginForm form = (LoginForm) objForm;
		
		try {
			
			
			Cliente cliente = new Cliente();
			
			cliente.setEmail(form.getEmail());
			
			IClienteDAO dao = new ClienteDAO();
		
			cliente = dao.getClienteByLogin(cliente);
			
			if(cliente == null){
				MsgUtil.addMsgError(request, "Email ou senha incorretos");
			}else {
				
				request.getSession().setAttribute(WebResource.USUARIO_LOGADO, cliente);
				return "controller?service=catalogoProdutos";
			}

		} catch (JavaWebException e) {
			System.out.println(e.getMessage());
			MsgUtil.addMsgError(request, e.getMessage());
		}
		
        request.setAttribute("form", form);
		
		return "paginas/index.jsp";
	}

}
