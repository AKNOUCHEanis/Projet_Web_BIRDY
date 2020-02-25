package tools;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;

import services.String;

public class User {
	
	/**
	 * @param nomUtilisateur
	 * @return : retourne True si le le nom d'utilisateur respecte le format
	 */
	

	public static JSONObject connect(String nomUtilisateur, String motDePasse, Cle cle,Connection c) {
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
	 * @throws SQLException 
	 */
	public static boolean userExist (String login,Connection c) throws SQLException {
		
		String sql = "SELECT * FROM User WHERE username=?";
		PreparedStatement preparedStatement =c.prepareStatement(sql);
		preparedStatement.setString(1, login);
		ResultSet rs=preparedStatement.executeQuery();
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
		
		String sql = "INSERT INTO User VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement =c.prepareStatement(sql);
		preparedStatement.setString(1, user);
		preparedStatement.setString(2, userToAdd);
		preparedStatement.executeUpdate();
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
