package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Eventos;
import DAO.FuncionariosPrefeitura;
import DBO.Evento;
import DBO.FuncionarioPrefeitura;

/**
 * Servlet implementation class BuscarFuncionarioPrefeitura
 */
@WebServlet("/RegistrarEvento")
public class RegistrarEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String retorno = "false";
		
		String matricula = request.getParameter("matriculaPref");
		String nomeEvento = request.getParameter("nomeEvento");
		String dataInicio = request.getParameter("dataInicio");
		String dataFim = request.getParameter("dataFim");
		String hrInicio = request.getParameter("hrInicio");
		String hrFim = request.getParameter("hrFim");
		
		Evento evento = new Evento(nomeEvento, dataInicio, dataFim, hrInicio, hrFim);
		
		
		if(FuncionariosPrefeitura.existeFuncionario(matricula)) {
			Eventos.registraEvento(evento);
			retorno = "true";
		}
		System.out.println(retorno);
		request.setAttribute("retorno", retorno);
		
		request.getRequestDispatcher("informar_evento.jsp").forward(request, response);
        
	}

}
