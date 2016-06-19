package br.javaweb.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.javaweb.beans.Produto;
import br.javaweb.dao.IProdutoDAO;
import br.javaweb.dao.ProdutoDAOImpl;
import br.javaweb.util.JavaWebException;
import br.javaweb.util.anotacao.Service;


@Service(nome="catalogoProdutos")
public class CatalogoProdutosService implements IService, Serializable {

	private static final long serialVersionUID = 8236902560347463602L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, Object form) throws ServletException, IOException {

		IProdutoDAO produtoDAO  = new ProdutoDAOImpl();
        List<Produto> listaProduto = new ArrayList<>();
        
        try {
			listaProduto = produtoDAO.getCatalogoProdutos();
		} catch (JavaWebException e) {
			e.printStackTrace();
		}
        
        request.setAttribute("catalogoProduto", listaProduto);
		
		return "paginas/catalogoProdutos.jsp";
	}

}
