package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import DAO.Escalas;
import DAO.Funcionarios;
import DAO.Itens;
import DBO.Funcionario;

/**
 * Servlet implementation class EfetuaLogin
 */
@WebServlet("/EfetuaLogin")
public class EfetuaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String senha = request.getParameter("senha");
		
		if(Funcionarios.efetuaLogin(matricula, senha)) {
			Funcionario func = Funcionarios.buscarFuncionarioPorMatricula(matricula);
			request.setAttribute("nome", func.getNomeCompleto());
			request.setAttribute("cargo", func.getCargo());
			
			if(func.getCargo().equals("Delegado")) {
				List<Funcionario> listFunc = Funcionarios.buscaSolicitacoesDeAcesso();
				
				request.setAttribute("solicitacoes", listFunc.size());
				request.setAttribute("listFunc", listFunc);
			}
			
			request.getRequestDispatcher("principal_interno.jsp").forward(request, response);
		} else {
			request.setAttribute("erro", true);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
