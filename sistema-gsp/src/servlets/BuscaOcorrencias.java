package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Boletins;
import DAO.Itens;
import DBO.Boletim;
import DBO.Item;

/**
 * Servlet implementation class BuscaOcorrencias
 */
@WebServlet("/BuscaOcorrencias")
public class BuscaOcorrencias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Boletim> lstBoletins = Boletins.buscarBoletins();
		
		request.setAttribute("lstBoletins", lstBoletins);
		
		request.getRequestDispatcher("ocorrencias.jsp").forward(request, response);
	}

}
