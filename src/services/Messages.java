package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.MongoDatabase;

import tools.Cle;

public class Messages {

	/**
	 * @param message : Message à ajouter
	 * @param cle     : cle pour obtenir l'utilisateur et voir si la durée de sa connexion est écoulée
	 * @return		 
	 */
	public static JSONObject ajouter(String message,String nomUtilisateur, String cle) {
		
		JSONObject json=new JSONObject();
		Boolean b=tools.Connexion.verifierConnexion(cle);
		try {
			if(b)
			{	MongoDatabase mongoDb=bd.DataBase.getMongoDBConnection();
				json=tools.Message.ajouterMessage(message,nomUtilisateur,mongoDb);
				if((json.getString("OutPut")).compareTo("OK")==0)
				{
					return json; // service accepted
				}
			}
			else {
				json=tools.ErrorJSON.serviceRefused("Service Message", 100000);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json; // faudra se reconnecter à la BD
		
				
	}

	public static JSONObject getListMessages(String nomUtilisateur, String cle) {
		
		JSONObject json=new JSONObject();
		Boolean b=tools.Connexion.verifierConnexion(cle);
		
		
			if(b)
			{
				MongoDatabase mongoDb=bd.DataBase.getMongoDBConnection();
				json=tools.Message.getListMessages(nomUtilisateur,mongoDb);
			}else {
				json=tools.ErrorJSON.serviceRefused("Service Message", 100000);
			}
		
		
		return json;
	}

	public static JSONObject supprimer(String idMessage, String cle) {
		JSONObject json=new JSONObject();
		Boolean b=tools.Connexion.verifierConnexion(cle);
		
		
			if(b)
			{
				MongoDatabase mongoDb=bd.DataBase.getMongoDBConnection();
				json=tools.Message.supprimer(idMessage,mongoDb);
			}
			else {
				json=tools.ErrorJSON.serviceRefused("Service Message", 100000);
			}
		
		
		return json;
	}

	public static JSONObject modifier(String idMessage, String message, String cle) {
		JSONObject json=new JSONObject();
	    Boolean b=tools.Connexion.verifierConnexion(cle);
		
		
			if(b)
			{
				MongoDatabase mongoDb=bd.DataBase.getMongoDBConnection();
				json=tools.Message.modifier(idMessage,message,mongoDb);
			}
		else {
			json=tools.ErrorJSON.serviceRefused("Service Message", 100000);
		}
		
		return json;
	}

}
