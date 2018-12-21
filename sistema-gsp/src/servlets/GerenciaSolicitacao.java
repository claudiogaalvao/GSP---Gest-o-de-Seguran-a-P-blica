package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Funcionarios;
import DBO.Funcionario;

/**
 * Servlet implementation class GerenciaSolicitacao
 */
@WebServlet("/GerenciaSolicitacao")
public class GerenciaSolicitacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("matricula") != null) {
			int matricula = Integer.parseInt(request.getParameter("matricula"));
			String ordem = request.getParameter("ordem");
			
			switch(ordem) {
			case "aprovar":
				Funcionarios.permiteAcesso(matricula);
				break;
			case "reprovar":
				Funcionarios.recusaAcesso(matricula);
				break;					
			}
		}
		
		List<Funcionario> listFunc = Funcionarios.buscaSolicitacoesDeAcesso();
		
		request.setAttribute("solicitacoes", listFunc.size());
		request.setAttribute("listFunc", listFunc);
		
		if(listFunc.size()==0) {
			request.getRequestDispatcher("principal_interno.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("solic_acesso.jsp").forward(request, response);
	}

}
