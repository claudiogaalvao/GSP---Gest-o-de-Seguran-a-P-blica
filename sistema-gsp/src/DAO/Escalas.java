package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import BD.BDMongo;
import DBO.Escala;
import DBO.Funcionario;

public class Escalas {
	
	public static Escala buscaEscalaPorMatricula(int matricula) {
		BasicDBObject Document = new BasicDBObject();
		Escala escala = new Escala();
		
		Document.put("matricula", matricula);
		DBCursor cursor = BDMongo.colecao.find(Document);
		
		while(cursor.hasNext()) {
			DBObject pessoa = cursor.next();
			DBObject escalaDB = (DBObject)pessoa.get("escala");
			
			String dSem = String.valueOf(escalaDB.get("dSem"));
			String hrInicio = String.valueOf(escalaDB.get("hrInicio"));
			String hrFim = String.valueOf(escalaDB.get("hrFim"));
			
			escala.setDiasDaSemana(dSem);
			escala.setHrInicio(hrInicio);
			escala.setHrFim(hrFim);
			
		}
		
		return escala;
	}
	
	public static boolean alteraEscala(int matricula, Funcionario funcNovo) {
		BasicDBObject Document = new BasicDBObject();
		BasicDBObject DocNovo = new BasicDBObject();
		BasicDBObject escalaDB = new BasicDBObject();		
		
		Document.put("matricula", matricula);
		
		DocNovo.put("nome", funcNovo.getNome());
		DocNovo.put("sobrenome", funcNovo.getSobrenome());
		DocNovo.put("matricula", funcNovo.getMatricula());
		DocNovo.put("cargo", funcNovo.getCargo());
		DocNovo.put("senha", funcNovo.getSenha());
		DocNovo.put("flAtivo", funcNovo.getFlAtivo());
		
		escalaDB.put("dSem", funcNovo.getEscala().getDiasDaSemana());
		escalaDB.put("hrInicio", funcNovo.getEscala().getHrInicio());
		escalaDB.put("hrFim", funcNovo.getEscala().getHrFim());
		
		DocNovo.put("escala", escalaDB);
		BDMongo.colecao.findAndModify(Document, DocNovo);
		return true;
	}
	
}
