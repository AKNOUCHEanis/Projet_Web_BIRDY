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
		Connection c=null;
		try {
			c = bd.DataBase.getMySQLConnection();
			if(nomUtilisateur==null || motDePasse==null)
			{
				return tools.ErrorJSON.serviceRefused("Service LogIn", 1);
			}
			
			if (tools.User.userExist(nomUtilisateur, c))
			{			
				tools.Cle cle=new tools.Cle(nomUtilisateur);
				json=tools.User.connect(nomUtilisateur,motDePasse,cle,c);
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
	 * @param cle : Hashcle de l'utilisateur a deconnecter
	 * @return : un objet JSON qui donne le resultat du service
	 */
	public static JSONObject logOut(String cle) {
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
