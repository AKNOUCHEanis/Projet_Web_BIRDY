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
	 * @throws SQLException 
	 */
	public static JSONObject logIn(String nomUtilisateur, String motDePasse){
		JSONObject json=new JSONObject();
		Boolean b1,b2;
		Connection c;
		try {
			c = bd.DataBase.getMySQLConnection();
			if(nomUtilisateur!=null && motDePasse!=null)  //la methode renvoie vrai si le nomUtilisateur est BON
			{
				return tools.ErrorJSON.serviceRefused("Service LogIn", 1);
			}
			
			if (tools.User.userExist(nomUtilisateur, c))
			{			
				tools.Cle cle=new tools.Cle(nomUtilisateur);
			
				tools.User.connect(nomUtilisateur,motDePasse,cle,c);
				
				c.close();
			
			}
			else {
				json=tools.ErrorJSON.serviceRefused("Service Login:", 1);
			}
		} catch (SQLException e) {
				e.printStackTrace();
				return tools.ErrorJSON.serviceRefused("Service Login",1000);
		}
		
			return json;
		
	}
	
	/**
	 * @param cle : cl� de l'utilisateur � deconnecter
	 * @return : un objet JSON qui donne le resultat du service
	 */
	public static JSONObject logOut(tools.Cle cle) {
		JSONObject json=new JSONObject();
		try {
			 Connection c=bd.DataBase.getMySQLConnection();
			 json=tools.User.desconnect(cle,c);
			 c.close();
			
		}
		catch(SQLException e) {       
			e.printStackTrace();
	        return tools.ErrorJSON.serviceRefused("Service Login",1000);
            }
		return json;
	}
	
}
