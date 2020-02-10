package bd;

import java.util.Calendar;

import org.json.JSONObject;

public class Connexion {

	public static JSONObject connect(String nomUtilisateur, String motDePasse, tools.Cle cle){
		// TODO Auto-generated method stub
		return null;
	}

	public static JSONObject desconnect(tools.Cle cle) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static JSONObject verifierConnexion(tools.Cle cle)
	{
		Calendar date = null;
		JSONObject json=new JSONObject();
		date.getTime();
		if(date.compareTo(cle.getDate())<0)
		{
			return tools.ErrorJSON.serviceAccepted();
			
		}else {
			return tools.ErrorJSON.serviceRefused("Service : Verification de la connexion: durée dépassée", 1);
		}
	
	}


}
