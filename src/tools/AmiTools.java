package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AmiTools {
	
	public static void insertF (String user,String userToAdd,Connection c) throws SQLException {
		
		String sql = "INSERT INTO Friends (user1,user2) VALUES (?,?)";
		PreparedStatement preparedStatement =c.prepareStatement(sql);
		preparedStatement.setString(1, user);
		preparedStatement.setString(2, userToAdd);
		preparedStatement.executeUpdate();
	}
	
	
	public static void removeF (String user,String userToDelete,Connection c) throws SQLException {
	
		String sql = "DELETE FROM Friends WHERE user1=? and user2=?";
		PreparedStatement preparedStatement =c.prepareStatement(sql);
		preparedStatement.setString(1, user);
		preparedStatement.setString(2, userToDelete);
		preparedStatement.executeUpdate();
		
		
	}
	
}
