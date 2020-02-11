package tools;

import java.sql.Connection;

import org.json.JSONObject;

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

}
