package services;

import org.json.simple.JSONObject;

public class Login {
	
	public static JSONObject checkUserName(String username,String password)
	{
		if(username.equals(""))
		{
			return tools.ErrorJSON.serviceRefused("ERREUR : FORMAT USERNAME ",100);
		}
		else {
			return tools.ErrorJSON.serviceAccepted();
		}
	}
	
	public static JSONObject checkPassword()
	{
		
	}
	
	public static JSONObject login()
	{
		
	}
	
	

}
