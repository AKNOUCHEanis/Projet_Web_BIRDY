package tools;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Message {

	public static JSONObject ajouterMessage(String message,String nomUtilisateur, Cle cle, MongoDatabase mongoDb) {
		MongoCollection<Document> coll=mongoDb.getCollection("Messages");
		Document doc=new Document();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		Date date = new Date();
		
		doc.append("Auteur", nomUtilisateur);
		doc.append("Date",format.format(date));
		doc.append("Message", message);
		System.out.println(doc.toString());
		coll.insertOne(doc);
		return tools.ErrorJSON.serviceAccepted();
		
	}

	public static JSONObject getListMessages(String nomUtilisateur, Cle cle, MongoDatabase mongoDb) {
		JSONObject json=new JSONObject();
		MongoCollection<Document> coll=mongoDb.getCollection("Messages");
		Document doc=new Document();
		doc.append("Auteur",nomUtilisateur);
		
		FindIterable<Document> res=coll.find(doc);
		
		for(Document doc2:res) {
			try {
				json.put("Document", doc2);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return json;
		
	}

	public static JSONObject supprimer(String idMessage, Cle cle, MongoDatabase mongoDb) {
		MongoCollection<Document> coll=mongoDb.getCollection("Messages");
		Document doc=new Document();
		ObjectId id=new ObjectId(idMessage);
		doc.append("_id", id);		
		coll.deleteOne(doc);

		return tools.ErrorJSON.serviceAccepted();
	}

	public static JSONObject modifier(String idMessage, String message, Cle cle, MongoDatabase mongoDb) {
		
		MongoCollection<Document> coll=mongoDb.getCollection("Messages");
		Document searchQuery=new Document();
		Document updateQuery=new Document();
		
		ObjectId id=new ObjectId(idMessage);
		searchQuery.append("_id", id);
		
		updateQuery.append("$set",new Document().append("Message", message) );
		
		coll.updateOne(searchQuery, updateQuery);
		
		return tools.ErrorJSON.serviceAccepted();
	}
	
}
