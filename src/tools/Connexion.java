package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.json.JSONObject;

public class Connexion {

	public static Boolean verifierConnexion(String cleHash)
	{
		Connection c=null;
		try {
			 c=bd.DataBase.getMySQLConnection();
			 String sql="SELECT * FROM Session WHERE h_cle=?";
			 PreparedStatement preparedStatement=c.prepareStatement(sql);
			 preparedStatement.setString(1, cleHash);
			 
			 ResultSet rs=preparedStatement.executeQuery();
			 if(rs.next()) {
				
				 String dateString=rs.getString(3);
				 LocalDateTime time=LocalDateTime.now();
				 LocalDateTime expirationTime=LocalDateTime.parse(dateString);
				 
				 return time.isBefore(expirationTime);
				  
			 }
			 
			 rs.close();
			 c.close();
			 
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
}
