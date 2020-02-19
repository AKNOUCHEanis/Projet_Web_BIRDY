package tools;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Message {

	public static JSONObject ajouterMessage(String message,String nomUtilisateur, Cle cle, MongoDatabase mongoDb) {
		DBCollection coll=(DBCollection)mongoDb.getCollection("Messages");
		Document doc=new Document();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		Date date = new Date();;
		
		doc.append("Auteur", nomUtilisateur);
		doc.append("Date",format.format(date));
		doc.append("Message", message);
		
		((MongoCollection<Document>) coll).insertOne(doc);
		return tools.ErrorJSON.serviceAccepted();
		
	}

	public static JSONObject getListMessages(String nomUtilisateur, Cle cle, Connection c) {
		// TODO Auto-generated method stub
		return null;
	}

	public static JSONObject supprimer(String idMessage, Cle cle, Connection c) {
		// TODO Auto-generated method stub
		return null;
	}

	public static JSONObject modifier(String idMessage, String message, Cle cle, Connection c) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
