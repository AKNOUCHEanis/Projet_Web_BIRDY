package services;

import java.sql.Connection;

import org.json.JSONException;
import org.json.JSONObject;

public class Authentification {

	/**
	 * @param nomUtilisateur: nom d'utilisateur 
	 * @param motDePasse : mot de passe
	 * @return : un objet JSON qui donne le resultat du service
	 */
	public static JSONObject logIn(String nomUtilisateur, String motDePasse) {
		JSONObject json=new JSONObject();
		Boolean b1,b2;
		tools.Cle cle=new tools.Cle();
		
		if(!tools.User.verifierNomUtilisateur(nomUtilisateur))  //la methode renvoie vrai si le nomUtilisateur est BON
		{
			return tools.ErrorJSON.serviceRefused("Service LogIn", 1);
		}
		if(!tools.User.verifierMotDePasse(motDePasse)) // la methode renvoie vrai si le motDePasse est BON
		{
			return tools.ErrorJSON.serviceRefused("Service LogIn", 1);
		}
		
		cle=tools.Securite.genererCle(nomUtilisateur,motDePasse);
		Connection c=bd.DataBase.getMySQLConnection();
		json=tools.User.connect(nomUtilisateur,motDePasse,cle,c);
		
		return json;
		
	}
	
	/**
	 * @param cle : clé de l'utilisateur à deconnecter
	 * @return : un objet JSON qui donne le resultat du service
	 */
	public static JSONObject logOut(tools.Cle cle) {
		Connection c=bd.DataBase.getMySQLConnection();
		JSONObject json=tools.User.desconnect(cle,c);
		return json;
	}
}
