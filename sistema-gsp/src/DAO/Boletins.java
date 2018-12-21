package DAO;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import BD.BDBoletim;
import BD.BDEstoque;
import DBO.Boletim;
import DBO.Item;

public class Boletins {
	
	public static List<Boletim> buscarBoletins() {
		BasicDBObject Document = new BasicDBObject();
		List<Boletim> lstBoletins = new ArrayList();
		
		Document.put("idade_pessoa", 22);
		
		DBCursor cursor = BDBoletim.colecao.find(Document);
		
		while(cursor.hasNext()) {
			DBObject boletim = cursor.next();
			
			String nome = String.valueOf(boletim.get("nome_vitima"));
			String idade = String.valueOf(boletim.get("idade_pessoa"));
			String sexo = String.valueOf(boletim.get("sexo_pessoa"));
			String logradouro = String.valueOf(boletim.get("logradouro"));
			String hrDenuncia = String.valueOf(boletim.get("hora_ocorrencia_bo"));
			String instrucao = String.valueOf(boletim.get("descr_grau_instrucao"));
			String crime = String.valueOf(boletim.get("rubrica"));
			
			Boletim ocorrencia = new Boletim(nome, idade, sexo, logradouro, hrDenuncia, instrucao, crime);
			
			lstBoletins.add(ocorrencia);
			
		}
		
		return lstBoletins;
	}

}
