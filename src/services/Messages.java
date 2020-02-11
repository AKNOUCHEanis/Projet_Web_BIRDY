package services;

import java.sql.Connection;

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

}
