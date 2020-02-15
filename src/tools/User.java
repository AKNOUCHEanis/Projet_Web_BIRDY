package tools;

import java.sql.Connection;

import org.json.JSONObject;

import services.String;

public class User {

	/**
	 * @param nomUtilisateur
	 * @return : retourne True si le le nom d'utilisateur respecte le format
	 */
	public static boolean verifierNomUtilisateur(String nomUtilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param motDePasse
	 * @return : retourne True si le mot de passe respecte le format
	 */
	public static boolean verifierMotDePasse(String motDePasse) {
		// TODO Auto-generated method stub
		return false;
	}

	public static JSONObject connect(String nomUtilisateur, String motDePasse, Cle cle, Connection c) {
		// TODO Auto-generated method stub
		return null;
	}

	public static JSONObject desconnect(Cle cle,Connection c) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @param login
	 * @param c
	 * @return
	 */
	public static boolean userExist (String login,Connection c) {
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuerry("SELECT * FROM User WHERE login==");
		if (rs.next()) return true;
		return false;
	}
	
	/**
	 * @param login
	 * @param password
	 * @param nom
	 * @param prenom
	 * @param c
	 */
	public static void insertUser (String login,String password,String nom,String prenom,Connection c) {
		Statement st=c.createStatement();
		ResultSet rs=st.executeUpdate("INSERT INTO User ...");	
	}
	
	/**
	 * @param login
	 * @param password
	 * @param c
	 */
	public static void removeUser (String login,String password,Connection c) {
		Statement st=c.createStatement();
		ResultSet rs=st.executeUpdate("DELETE FROM User ...");	
	}
	

}
