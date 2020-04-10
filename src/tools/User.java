package tools;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONObject;
public class User {
	
	/**
	 * @param nomUtilisateur
	 * @return : retourne True si le le nom d'utilisateur respecte le format
	 * @throws SQLException 
	 */
	

	public static JSONObject connect(String nomUtilisateur, String motDePasse, Cle cle,Connection c) throws SQLException {
		
		String sql = "SELECT * FROM Compte WHERE username=? and password=?";
		PreparedStatement preparedStatement =c.prepareStatement(sql);
		preparedStatement.setString(1, nomUtilisateur);
		preparedStatement.setString(2, motDePasse);
		
		ResultSet rs=preparedStatement.executeQuery();
		if (rs.next()) {
			sql = "INSERT INTO Session (username,h_cle,date_expiration) VALUES(?,?,?)";
			preparedStatement =c.prepareStatement(sql);
			preparedStatement.setString(1, nomUtilisateur);
			preparedStatement.setString(2, cle.getCle());
			preparedStatement.setString(3,cle.getDate().toString());
			preparedStatement.executeUpdate();
			
			
			return tools.ErrorJSON.serviceAccepted();
		}
		return tools.ErrorJSON.serviceRefused("Service User", 1);
	}
	

	public static JSONObject desconnect(String cle,Connection c) throws SQLException {
		String sql = "DELETE FROM Session WHERE h_cle=?";
		PreparedStatement preparedStatement =c.prepareStatement(sql);
		preparedStatement.setString(1, cle);
		preparedStatement.executeUpdate();
		return tools.ErrorJSON.serviceAccepted();
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
	 * @throws SQLException 
	 */
	public static void insertUser (String login,String password,String nom,String prenom,String email,Date dateNaiss,Connection c) throws SQLException {
		
		String sql1 = "INSERT INTO User VALUES (?,?,?,?,?)";
		String sql2 = "INSERT INTO Compte VALUES (?,?)";
		
		PreparedStatement preparedStatement1 =c.prepareStatement(sql1);
		preparedStatement1.setString(1, login);
		preparedStatement1.setString(2, nom);
		preparedStatement1.setString(3, prenom);
		preparedStatement1.setString(4, email);
		preparedStatement1.setDate(5, dateNaiss);
		
		PreparedStatement preparedStatement2 =c.prepareStatement(sql2);
		preparedStatement2.setString(1, login);
		preparedStatement2.setString(2, password);

		preparedStatement1.executeUpdate();
		preparedStatement2.executeUpdate();
	}
	
	/**
	 * @param login
	 * @param password
	 * @param c
	 * @throws SQLException 
	 */
	public static void removeUser (String login,Connection c) throws SQLException {
		
		String sql1 = "DELETE FROM User WHERE username=?";
		String sql2 = "DELETE FROM Compte WHERE username=?";
		String sql3 = "DELETE FROM Session WHERE username=?";
		
		PreparedStatement preparedStatement1 =c.prepareStatement(sql1);
		preparedStatement1.setString(1, login);
		
		PreparedStatement preparedStatement2 =c.prepareStatement(sql2);
		preparedStatement2.setString(1, login);
		
		PreparedStatement preparedStatement3 =c.prepareStatement(sql3);
		preparedStatement3.setString(1, login);

		preparedStatement2.executeUpdate();	
		preparedStatement3.executeUpdate();
		preparedStatement1.executeUpdate();
	}
	

}
