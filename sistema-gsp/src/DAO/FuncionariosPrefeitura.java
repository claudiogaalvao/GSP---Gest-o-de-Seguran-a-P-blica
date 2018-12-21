package DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import BD.BDMongo;
import BD.BDPrefeitura;
import DBO.Escala;
import DBO.Funcionario;
import DBO.FuncionarioPrefeitura;

public class FuncionariosPrefeitura {
	
	public static FuncionarioPrefeitura buscarFuncionarioPorMatricula(String matricula) {
		BasicDBObject Document = new BasicDBObject();
		
		Document.put("matricula", matricula);
		DBCursor cursor = BDPrefeitura.colecao.find(Document);
		
		FuncionarioPrefeitura funcPref = new FuncionarioPrefeitura();
		
		if(cursor.length()>0) {
			String nome = String.valueOf(cursor.one().get("nome"));
			String cargo = String.valueOf(cursor.one().get("cargo"));
			
			funcPref.setNome(nome);
			funcPref.setMatricula(matricula);
			funcPref.setCargo(cargo);
		}
		
		return funcPref;
	}
	
	public static boolean existeFuncionario(String matricula) {
		BasicDBObject Document = new BasicDBObject();
		boolean retorno = false;
		
		Document.put("matricula", matricula);
		DBCursor cursor = BDPrefeitura.colecao.find(Document);
		
		if(cursor.length()>0)
			retorno = true;
		
		return retorno;
	}


}
