package tools;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorJSON {
	
	/**
	 * @param message :Nom du service qui solicité
	 * @param codeErreur : code de l'erreur
	 * @return un objet JSON
	 */
	public static JSONObject serviceRefused(String message, int codeErreur)
	{
		
		JSONObject json=new JSONObject();
		if(codeErreur==1)
		{
			String erreur="Type: Erreur d'argument passé au web service";
			try {
				json.put("OutPut","KO");
				json.put("serviceSolicite", message);
				json.put("Erreur",erreur);
				json.put("Code Erreur", codeErreur);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else if(codeErreur==100)
		{
			String erreur="Type: Erreur JSON";
			try {
				json.put("OutPut","KO");
				json.put("serviceSolicite", message);
				json.put("Erreur",erreur);
				json.put("Code Erreur", codeErreur);
			} catch(JSONException e)
			{
				e.printStackTrace();
			}
		}else if(codeErreur==1000)
		{
			String erreur="Type: Erreur SQL";
			try {
				json.put("OutPut","KO");
				json.put("serviceSolicite", message);
				json.put("Erreur",erreur);
				json.put("Code Erreur", codeErreur);
			} catch(JSONException e)
			{
				e.printStackTrace();
			}
		}
		else if(codeErreur==10000)
		{
			String erreur="Type: Erreur JAVA";
			try {
				json.put("OutPut","KO");
				json.put("serviceSolicite", message);
				json.put("Erreur",erreur);
				json.put("Code Erreur", codeErreur);
			} catch(JSONException e)
			{
				e.printStackTrace();
			}
		}
		else {
			String erreur="Type: code erreur erroné";
			try {
				json.put("OutPut","KO");
				json.put("serviceSolicite", message);
				json.put("Erreur",erreur);
				json.put("Code Erreur", codeErreur);
			} catch(JSONException e)
			{
				e.printStackTrace();
			}
			
		}
		
		return json;
	}
	
	public static JSONObject serviceAccepted()
	{
		JSONObject json=new JSONObject();
		try {
			json.put("OutPut","OK");
			
		} catch(JSONException e)
		{
			e.printStackTrace();
		}
		
		return json;
	}
	
	public static JSONObject serviceAccepted(String informations)
	{
		JSONObject json=new JSONObject();
		try {
			json.put("OutPut","OK");
			json.put("Informations", informations);
		}catch(JSONException e)
		{
			e.printStackTrace();
		}
		return json;
	}

}
