package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import tools.Cle;

public class Messages {

	/**
	 * @param message : Message à ajouter
	 * @param cle     : cle pour obtenir l'utilisateur et voir si la durée de sa connexion est écoulée
	 * @return		 
	 */
	public static JSONObject ajouter(String message, Cle cle) {
		
		JSONObject json=new JSONObject();
		json=tools.Connexion.verifierConnexion(cle);
		try {
			if((json.getString("OutPut")).compareTo("OK")==0)
			{	Connection c=bd.DataBase.getMySQLConnection();
				json=tools.Message.ajouterMessage(message,cle,c);
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
		Connection c;
		try {
			if((json.getString("OutPut")).compareTo("OK")==0)
			{
			    c=bd.DataBase.getMySQLConnection();
				json=tools.Message.getListMessages(nomUtilisateur,cle,c);
			}
		}catch(JSONException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return json;
	}

	public static JSONObject supprimer(String idMessage, Cle cle) {
		JSONObject json=new JSONObject();
		json=tools.Connexion.verifierConnexion(cle);
		Connection c;
		try {
			if((json.getString("OutPut")).compareTo("OK")==0)
			{
				c=bd.DataBase.getMySQLConnection();
				json=tools.Message.supprimer(idMessage,cle,c);
			}
		}catch(JSONException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return json;
	}

	public static JSONObject modifier(String idMessage, String message, Cle cle) {
		JSONObject json=new JSONObject();
		json=tools.Connexion.verifierConnexion(cle);
		Connection c;
		try {
			if((json.getString("OutPut")).compareTo("OK")==0)
			{
			    c=bd.DataBase.getMySQLConnection();
				json=tools.Message.modifier(idMessage,message,cle,c);
			}
		}catch(JSONException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return json;
	}

}
