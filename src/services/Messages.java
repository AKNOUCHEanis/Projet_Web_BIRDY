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
	public static JSONObject ajouter(String message,String nomUtilisateur, Cle cle) {
		
		JSONObject json=new JSONObject();
		json=tools.Connexion.verifierConnexion(cle);
		try {
			if((json.getString("OutPut")).compareTo("OK")==0)
			{	MongoDatabase mongoDb=bd.DataBase.getMongoDBConnection();
				json=tools.Message.ajouterMessage(message,nomUtilisateur,cle,mongoDb);
				if((json.getString("OutPut")).compareTo("OK")==0)
				{
					return json; // service accepted
				}
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json; // faudra se reconnecter à la BD
		
				
	}

	public static JSONObject getListMessages(String nomUtilisateur, Cle cle) {
		
		JSONObject json=new JSONObject();
		json=tools.Connexion.verifierConnexion(cle);
		
		try {
			if((json.getString("OutPut")).compareTo("OK")==0)
			{
				MongoDatabase mongoDb=bd.DataBase.getMongoDBConnection();
				json=tools.Message.getListMessages(nomUtilisateur,cle,mongoDb);
			}
		}catch(JSONException e)
		{
			e.printStackTrace();
		}
		
		return json;
	}

	public static JSONObject supprimer(String idMessage, Cle cle) {
		JSONObject json=new JSONObject();
		json=tools.Connexion.verifierConnexion(cle);
		
		try {
			if((json.getString("OutPut")).compareTo("OK")==0)
			{
				MongoDatabase mongoDb=bd.DataBase.getMongoDBConnection();
				json=tools.Message.supprimer(idMessage,cle,mongoDb);
			}
		}catch(JSONException e)
		{
			e.printStackTrace();
		}
		
		return json;
	}

	public static JSONObject modifier(String idMessage, String message, Cle cle) {
		JSONObject json=new JSONObject();
		json=tools.Connexion.verifierConnexion(cle);
		
		try {
			if((json.getString("OutPut")).compareTo("OK")==0)
			{
				MongoDatabase mongoDb=bd.DataBase.getMongoDBConnection();
				json=tools.Message.modifier(idMessage,message,cle,mongoDb);
			}
		}catch(JSONException e)
		{
			e.printStackTrace();
		}
		
		return json;
	}

}
