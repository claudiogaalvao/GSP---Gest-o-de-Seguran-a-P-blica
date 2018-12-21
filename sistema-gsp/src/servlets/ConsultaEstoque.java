package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Itens;
import DBO.Item;

/**
 * Servlet implementation class ConsultaEstoque
 */
@WebServlet("/ConsultaEstoque")
public class ConsultaEstoque extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Item> lstItens = Itens.buscarItens();
		
		request.setAttribute("lstItens", lstItens);
		
		request.getRequestDispatcher("estoque.jsp").forward(request, response);
	}

}
