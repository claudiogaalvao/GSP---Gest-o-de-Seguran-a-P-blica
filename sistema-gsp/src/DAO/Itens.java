package DAO;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import BD.BDEstoque;
import DBO.Item;

public class Itens {
	
	public static List<Item> buscarItens() {
		BasicDBObject Document = new BasicDBObject();
		List<Item> lstItens = new ArrayList();
		
		DBCursor cursor = BDEstoque.colecao.find();
		
		while(cursor.hasNext()) {
			DBObject item = cursor.next();
			
			String titulo = String.valueOf(item.get("titulo"));
			String descricao = String.valueOf(item.get("descricao"));
			String quantidade = String.valueOf(item.get("quantidade"));
			String dtEntrada = String.valueOf(item.get("dtEntrada"));
			String dtSaida = String.valueOf(item.get("dtSaída"));
			String tipo = String.valueOf(item.get("tipo"));
			
			Item objItem = new Item(titulo, descricao, quantidade, dtEntrada, dtSaida, tipo);
			
			if(tipo.equals("arma")) {
				String nrSerie = String.valueOf(item.get("nrSerie"));
				objItem.setNrSerie(nrSerie);
			}
			
			lstItens.add(objItem);
			
		}
		
		return lstItens;
	}

}
