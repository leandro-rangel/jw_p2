package br.javaweb.service;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.javaweb.beans.Cliente;
import br.javaweb.dao.ClienteDAO;
import br.javaweb.dao.IClienteDAO;
import br.javaweb.form.CadastroClienteForm;
import br.javaweb.util.JavaWebException;
import br.javaweb.util.MsgUtil;
import br.javaweb.util.anotacao.Service;


@Service(nome="cadastraCliente")
public class CadastraClienteService implements IService, Serializable {

	private static final long serialVersionUID = -8481061822264752553L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, Object objForm) throws ServletException, IOException {

		CadastroClienteForm form = (CadastroClienteForm) objForm;
		
		if(!form.getSenha().equals(form.getSenha2())){
			MsgUtil.addMsgError(request, "Senha e confirmação da sennha devem ser correspondentes");
			request.setAttribute("form", form);
			return "paginas/cadastroCliente.jsp";
		}
		
		Cliente cliente = new Cliente();
		
		cliente.setId(form.getId());
		cliente.setNome(form.getNome());
		cliente.setCpf(form.getCpf());
		cliente.setTelefone(form.getTelefone());
		cliente.setEmail(form.getEmail());
		
		IClienteDAO dao = new ClienteDAO();
		
		
		try {
			
			if(cliente.getId() == null){
				dao.save(cliente);
			}
			
			MsgUtil.addMsgSucess(request, "Cliente cadastrado com sucesso");

		} catch (JavaWebException e) {
			System.out.println(e.getMessage());
			MsgUtil.addMsgError(request, e.getMessage());
		}
		
        request.setAttribute("form", form);
		
		return "paginas/cadastroCliente.jsp";
	}

}
