package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONObject;

public class Amis{

	public static JSONObject addFriend (String user, String UserToAdd) {
		Connection c = null;
		try {
			c=bd.DataBase.getMySQLConnection();
			if (user==null || UserToAdd==null) {
				return tools.ErrorJSON.serviceRefused("Service Amis:",1);
			}
			if (!tools.User.userExist(UserToAdd,c)) {
				return tools.ErrorJSON.serviceRefused("Service Amis:",1);
			}
			tools.AmiTools.insertF(user,UserToAdd,c);
			return tools.ErrorJSON.serviceAccepted();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return tools.ErrorJSON.serviceRefused("Service Amis:", 1000);
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return tools.ErrorJSON.serviceRefused("Service Amis:", 1000);
			}
		}
	}
	
	public static JSONObject removeFriend (String user, String UserToDelete) {
		Connection c=null;
		try {
			c=bd.DataBase.getMySQLConnection();
			if (user==null || UserToDelete==null) {
				return tools.ErrorJSON.serviceRefused("champ(s) invalide(s)",1);
			}
			if (!tools.User.userExist(UserToDelete,c)) {
				return tools.ErrorJSON.serviceRefused("utilisateur inexistant",1);
			}
			tools.AmiTools.removeF(user,UserToDelete,c);
			return tools.ErrorJSON.serviceAccepted();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return tools.ErrorJSON.serviceRefused("Service Amis:", 1000);
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return tools.ErrorJSON.serviceRefused("Service Amis:", 1000);
			}
		}
	}
}
