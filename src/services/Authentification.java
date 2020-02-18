package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import tools.Connexion;

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
		Connection c;
		try {
			if(!tools.User.verifierNomUtilisateur(nomUtilisateur))  //la methode renvoie vrai si le nomUtilisateur est BON
			{
				return tools.ErrorJSON.serviceRefused("Service LogIn", 1);
			}
			if(!tools.User.verifierMotDePasse(motDePasse)) // la methode renvoie vrai si le motDePasse est BON
			{
				return tools.ErrorJSON.serviceRefused("Service LogIn", 1);
			}
		
			cle=tools.Securite.genererCle(nomUtilisateur,motDePasse);
			c = bd.DataBase.getMySQLConnection();
		
			json=tools.User.connect(nomUtilisateur,motDePasse,cle,c);
			
			c.close();
		
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
			return json;
		
	}
	
	/**
	 * @param cle : clé de l'utilisateur à deconnecter
	 * @return : un objet JSON qui donne le resultat du service
	 */
	public static JSONObject logOut(tools.Cle cle) {
		JSONObject json=new JSONObject();
		try {
			 Connection c=bd.DataBase.getMySQLConnection();
			 json=tools.User.desconnect(cle,c);
			 c.close();
			
		}catch(SQLException e) {
	               e.printStackTrace();
            }
		return json;
	}
	
}
