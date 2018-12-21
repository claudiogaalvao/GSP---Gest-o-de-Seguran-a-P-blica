package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BD.BDMongo;
import DAO.Escalas;
import DAO.Funcionarios;
import DBO.Escala;
import DBO.Funcionario;

/**
 * Servlet implementation class solicitaAcesso
 */
@WebServlet("/SolicitaAcesso")
public class SolicitaAcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			int matricula = Integer.parseInt(request.getParameter("matricula"));
			String cargo = request.getParameter("cargo");
			String senha = request.getParameter("senha");
			String flAtivo = "nao"; //Usar sem acento e maiusculo
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String dtSolic = dateFormat.format(date);
			
			Escala escala = new Escala();
					
			Funcionario funcionario1 = new Funcionario(nome, sobrenome, matricula, cargo, senha, flAtivo, dtSolic, escala);
			
			Funcionarios.inserir(funcionario1);
			
			request.setAttribute("sucesso", true);		
			request.getRequestDispatcher("form_agentes.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			request.setAttribute("erro", true);
			request.getRequestDispatcher("form_agentes.jsp").forward(request, response);
		}
		
		
		
		
	}

}
