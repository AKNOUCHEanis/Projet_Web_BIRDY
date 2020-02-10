package services;

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
		
		if(!tools.Verification.verifierNomUtilisateur(nomUtilisateur))  //la methode renvoie vrai si le nomUtilisateur est BON
		{
			return tools.ErrorJSON.serviceRefused("Service LogIn", 1);
		}
		if(!tools.Verification.verifierMotDePasse(motDePasse)) // la methode renvoie vrai si le motDePasse est BON
		{
			return tools.ErrorJSON.serviceRefused("Service LogIn", 1);
		}
		
		cle=tools.Securite.genererCle(nomUtilisateur,motDePasse);
		json=bd.Connexion.connect(nomUtilisateur,motDePasse,cle);
		
		return json;
		
	}
	
	/**
	 * @param cle : clé de l'utilisateur à deconnecter
	 * @return : un objet JSON qui donne le resultat du service
	 */
	public static JSONObject logOut(tools.Cle cle) {
		JSONObject json=bd.Connexion.desconnect(cle);
		return json;
	}
}
