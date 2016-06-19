package br.javaweb.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.javaweb.dao.IProdutoDAO;
import br.javaweb.dao.ProdutoDAOImpl;
import br.javaweb.util.JavaWebException;
import br.javaweb.util.anotacao.Service;


@Service(nome="addProdutoCarrinho")
public class AdicionarProdutoCarrinhoService implements IService {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, Object form) throws ServletException, IOException {
		
		IProdutoDAO produtoDAO = new ProdutoDAOImpl();
		
		try {
			request.setAttribute("produto", produtoDAO.getProdutoById(Integer.parseInt(request.getParameter("id"))));
		} catch (JavaWebException e) {
			e.printStackTrace();
		}
		
		return "paginas/addProdutoCarrinho.jsp";
	}

}
