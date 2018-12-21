package DAO;

import com.mongodb.BasicDBObject;

import BD.BDEvento;
import BD.BDMongo;
import DBO.Evento;

public class Eventos {
	
	public static void registraEvento(Evento evento) {
		BasicDBObject Document = new BasicDBObject();
		
		Document.put("nome", evento.getNomeEvento());
		Document.put("dataInicio", evento.getDataInicio());
		Document.put("dataFim", evento.getDataFim());
		Document.put("hrInicio", evento.getHrInicio());
		Document.put("hrFim", evento.getHrFim());
		
		BDEvento.colecao.insert(Document);
	}

}
