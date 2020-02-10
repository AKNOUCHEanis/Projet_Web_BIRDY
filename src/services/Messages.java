package services;

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
		json=bd.Connexion.verifierConnexion(cle);
		try {
			if((json.getString("OutPut")).compareTo("OK")==0)
			{
				json=bd.Traitement.ajouterMessage(message,cle);
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
