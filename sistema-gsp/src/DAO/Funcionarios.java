package DAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import BD.BDMongo;
import DBO.Escala;
import DBO.Funcionario;

public class Funcionarios {
	
	
		public static boolean inserir(Funcionario funcionario) {
			BasicDBObject Document = new BasicDBObject();
			BasicDBObject escalaDB = new BasicDBObject();
			
			Document.put("nome", funcionario.getNome());
			Document.put("sobrenome", funcionario.getSobrenome());
			Document.put("matricula", funcionario.getMatricula());
			Document.put("cargo", funcionario.getCargo());
			Document.put("senha", funcionario.getSenha());
			Document.put("flAtivo", funcionario.getFlAtivo());
			Document.put("dtSolic", funcionario.getDtSolic());
			
			escalaDB.put("dSem", funcionario.getEscala().getDiasDaSemana());
			escalaDB.put("hrInicio", funcionario.getEscala().getHrInicio());
			escalaDB.put("hrFim", funcionario.getEscala().getHrFim());
			
			Document.put("escala", escalaDB);
			
			BDMongo.colecao.insert(Document);
			return true;
		}
		
		public static void mostrar() {
			BasicDBObject Document = new BasicDBObject();
			
			DBCursor cursor = BDMongo.colecao.find();
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
		}
		
		public static int buscaMatriculaPorNomeCompleto(String nomeFunc, String sobrenomeFunc) {
			BasicDBObject Document = new BasicDBObject();
			
			Document.put("nome", nomeFunc);
			Document.put("sobrenome", sobrenomeFunc);
			DBCursor cursor = BDMongo.colecao.find(Document);
			
			String nome = String.valueOf(cursor.one().get("nome"));
			String sobrenome = String.valueOf(cursor.one().get("sobrenome"));
			int matricula = Integer.parseInt(String.valueOf(cursor.one().get("matricula")));
			String cargo = String.valueOf(cursor.one().get("cargo"));
			String senha = String.valueOf(cursor.one().get("senha"));
			String flAtivo = String.valueOf(cursor.one().get("flAtivo"));
			String dtSolic = String.valueOf(cursor.one().get("dtSolic"));
			
			return matricula;
		}
		
		public static Funcionario buscarFuncionarioPorMatricula(int matricula) {
			BasicDBObject Document = new BasicDBObject();
			
			Document.put("matricula", matricula);
			DBCursor cursor = BDMongo.colecao.find(Document);
			
			String nome = String.valueOf(cursor.one().get("nome"));
			String sobrenome = String.valueOf(cursor.one().get("sobrenome"));
			String cargo = String.valueOf(cursor.one().get("cargo"));
			String senha = String.valueOf(cursor.one().get("senha"));
			String flAtivo = String.valueOf(cursor.one().get("flAtivo"));
			String dtSolic = String.valueOf(cursor.one().get("dtSolic"));
			
			Escala escala = new Escala();
			escala = Escalas.buscaEscalaPorMatricula(matricula);
			
			Funcionario funcionario = new Funcionario(nome, sobrenome, matricula, cargo, senha, flAtivo, dtSolic, escala);
			return funcionario;
		}
		
		public static List<Funcionario> buscarFuncionariosAtivos() {
			BasicDBObject Document = new BasicDBObject();
			List<Funcionario> lstFuncionarios = new ArrayList();
			DBObject escalaDB;
			
			//Document.put("flAtivo", "sim");
			Document.put("cargo", "Policial");
			DBCursor cursor = BDMongo.colecao.find(Document);
			
			while(cursor.hasNext()) {
				DBObject pessoa = cursor.next();
				
				String nome = String.valueOf(pessoa.get("nome"));
				String sobrenome = String.valueOf(pessoa.get("sobrenome"));
				String cargo = String.valueOf(pessoa.get("cargo"));
				String senha = String.valueOf(pessoa.get("senha"));
				String flAtivo = String.valueOf(pessoa.get("flAtivo"));
				String dtSolic = String.valueOf(pessoa.get("dtSolic"));
				
				escalaDB = (DBObject)pessoa.get("escala");
				String diasSem = String.valueOf(escalaDB.get("dSem"));
				String hrInicio = String.valueOf(escalaDB.get("hrInicio"));
				String hrFim = String.valueOf(escalaDB.get("hrFim"));
				
				Escala escala = new Escala();
				escala.setDiasDaSemana(diasSem);
				escala.setHrInicio(hrInicio);
				escala.setHrFim(hrFim);
				
				Funcionario funcionario = new Funcionario(nome, sobrenome, 0, cargo, senha, flAtivo, dtSolic, escala);
				lstFuncionarios.add(funcionario);
			}
			
			
			return lstFuncionarios;
		}
		
		public static boolean atualizarPorMatricula(int matricula, Funcionario funcNovo) {
			BasicDBObject Document = new BasicDBObject();
			
			Document.put("matricula", matricula);
			BasicDBObject DocNovo = new BasicDBObject();
			DocNovo.put("nome", funcNovo.getNome());
			DocNovo.put("sobrenome", funcNovo.getSobrenome());
			DocNovo.put("matricula", funcNovo.getMatricula());
			DocNovo.put("cargo", funcNovo.getCargo());
			DocNovo.put("senha", funcNovo.getSenha());
			DocNovo.put("flAtivo", funcNovo.getFlAtivo());
			BDMongo.colecao.findAndModify(Document, DocNovo);
			return true;
		}
		
		public static boolean remover(Funcionario funcionario) {
			BasicDBObject Document = new BasicDBObject();
			
			Document.put("matricula", funcionario.getMatricula());
			BDMongo.colecao.remove(Document);
			return true;
		}
	
		public static boolean efetuaLogin(int matricula, String senha) {
			BasicDBObject Document = new BasicDBObject();
			boolean retorno = false;
			
			Document.put("matricula", matricula);
			DBCursor cursor = BDMongo.colecao.find(Document);
			
			if(cursor.one()!=null) {
				String senhaBD = String.valueOf(cursor.one().get("senha"));
				String flAtivo = String.valueOf(cursor.one().get("flAtivo"));
				
				if(senhaBD.equals(senha)) {
					if(flAtivo.equals("sim"))
						retorno=true;
				}	
			}
			
			
			return retorno;
		}
		
		public static List<Funcionario> buscaSolicitacoesDeAcesso() {
			BasicDBObject Document = new BasicDBObject();
			
			Document.put("flAtivo", "nao");
			DBCursor cursor = BDMongo.colecao.find(Document);
			
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			while(cursor.hasNext()) {
				DBObject pessoa = cursor.next();
				
				String nome = String.valueOf(pessoa.get("nome"));
				String sobrenome = String.valueOf(pessoa.get("sobrenome"));
				int matricula = Integer.parseInt(String.valueOf(pessoa.get("matricula")));
				String cargo = String.valueOf(pessoa.get("cargo"));
				String senha = String.valueOf(pessoa.get("senha"));
				String flAtivo = String.valueOf(pessoa.get("flAtivo"));
				String dtSolic = String.valueOf(pessoa.get("dtSolic"));
				
				Funcionario func = new Funcionario(nome, sobrenome, matricula, cargo, senha, flAtivo, dtSolic, Escalas.buscaEscalaPorMatricula(matricula));
				
				funcionarios.add(func);
			}
			
			return funcionarios;
		}
		
		public static void permiteAcesso(int matricula) {
			BasicDBObject searchQuery = new BasicDBObject();			
			BasicDBObject updateQuery = new BasicDBObject();
			
			searchQuery.put("matricula", matricula);
			
			updateQuery.append("$set", new BasicDBObject("flAtivo", "sim"));
			
			BDMongo.colecao.update(searchQuery, updateQuery);
		}
		
		public static void recusaAcesso(int matricula) {
			BasicDBObject Document = new BasicDBObject();			
			
			Document.put("matricula", matricula);
			BDMongo.colecao.remove(Document);
		}

}
