package servlets;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Escalas;
import DAO.Funcionarios;
import DBO.Funcionario;

/**
 * Servlet implementation class BuscaEscalas
 */
@WebServlet("/BuscaEscalas")
public class BuscaEscalas extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Funcionario> listFunc = Funcionarios.buscarFuncionariosAtivos();
		
		request.setAttribute("listFunc", listFunc);
		
		request.getRequestDispatcher("escalas.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String horario = request.getParameter("horario") == null ? null : request.getParameter("horario");
		String dia = request.getParameter("dia");
		String acao = request.getParameter("acao");
		int matricula = Funcionarios.buscaMatriculaPorNomeCompleto(nome, sobrenome);
		
		Funcionario funcionario = Funcionarios.buscarFuncionarioPorMatricula(matricula);
		
		//Se horário estiver vazio, é porque foi passado o dia da semana para alterar
		if(horario==null) {
			//Altera DIA DA SEMANA da escala do funcionário
			String diasDaSemana = funcionario.getEscala().getDiasDaSemana();
			diasDaSemana = diasDaSemana.replace(" ", "");
			String vDiasDaSemana[] = diasDaSemana.split(Pattern.quote(","));
			String novoVetor = "";
			
			if(acao.equals("inserir")) {				
				for (String vDia : vDiasDaSemana) {
					novoVetor += vDia + ",";
				}
				novoVetor = novoVetor + dia;
			} else {
				for (int i = 0; i < vDiasDaSemana.length; i++) {
					if(!(vDiasDaSemana[i].equals(dia))) {
						novoVetor += vDiasDaSemana[i] + ",";
						
					}					
				}
				novoVetor = novoVetor.substring(0, novoVetor.length()-1);
			}
			
			funcionario.getEscala().setDiasDaSemana(novoVetor);
			
			Escalas.alteraEscala(matricula, funcionario);
			
		} else {
			//Altera HORÁRIO da escala do funcionário
			String[] horarioSeparado = horario.split(",");
			String hrInicio = horarioSeparado[0];
			String hrFim = horarioSeparado[1];
			
			funcionario.getEscala().setHrInicio(hrInicio);
			funcionario.getEscala().setHrFim(hrFim);
			
			Escalas.alteraEscala(matricula, funcionario);
		}
		
		
		
	}

}
