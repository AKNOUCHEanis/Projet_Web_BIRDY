package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.json.JSONObject;



public class User {

	public static JSONObject createUser (String login,String password,String nom,String prenom,String email,Date dateNaiss) {
		Connection c = null;
		try {
			c=bd.DataBase.getMySQLConnection();
			if (login==null || password==null || nom==null || prenom ==null) {
				return tools.ErrorJSON.serviceRefused("Service User:",1);
			}
			
			if (tools.User.userExist(login,c)) {
				return tools.ErrorJSON.serviceRefused("Service User:",1);
			}
			tools.User.insertUser(login,password,nom,prenom,email,dateNaiss,c);
			return tools.ErrorJSON.serviceAccepted();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return tools.ErrorJSON.serviceRefused("Service User",1000);
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return tools.ErrorJSON.serviceRefused("Service User",1000);
			}
		}
	}
	
	public static JSONObject deleteUser (String login,String password) {
		Connection c=null;
		try {
			c=bd.DataBase.getMySQLConnection();
			if (login==null || password==null) {
				return tools.ErrorJSON.serviceRefused("Service User",1);
			}
			
			if (!tools.User.userExist(login,c)) {
				return tools.ErrorJSON.serviceRefused("Service User",1);
			}
			tools.User.removeUser(login,c);
			return tools.ErrorJSON.serviceAccepted();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return tools.ErrorJSON.serviceRefused("Service User",1000);
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return tools.ErrorJSON.serviceRefused("Service User",1000);
			}
		}
	}
	
}
