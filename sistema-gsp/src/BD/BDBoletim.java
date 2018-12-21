package BD;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

import DBO.Funcionario;

public class BDBoletim {
	
	public final static DB BaseDados;
	public final static DBCollection colecao;	
	
	static {
		DB db=null;
        DBCollection collection=null;
		try {
			Mongo mongo = new Mongo("localhost", 27017);
			db = mongo.getDB("boletins");
			collection = db.getCollection("boletins");
			System.out.println("Conexão efetuada com sucesso!");
		} catch(Exception e) {
			Logger.getLogger(BDMongo.class.getName()).log(Level.SEVERE, null, e);
            System.exit(0);
		}
		BaseDados=db;
		colecao=collection;
	}
	
}