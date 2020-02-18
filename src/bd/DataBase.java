package bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.JSONObject;

public class DataBase{
	private DataSource dataSource;
	
	public DataBase(String jndiname) throws SQLException {
		try {
			dataSource=(DataSource) new InitialContext().lookup("java:comp/env/"+jndiname) ;
		}
		catch (NamingException e) {
			throw new SQLException (jndiname + " is missing in JNDI ! : "+e.getMessage( )) ;
		}
	}

	public static Connection getConnection () throws SQLException {
		return dataSource.getConnection();
	}

	public static Connection getMySQLConnection ( ) throws SQLException {
		if ( DBStatic.my_sqlpooling==false ) {
			return ( DriverManager.getConnection("jdbc:mysql://" + DBStatic.mysql_host+
					"/"+DBStatic.mysql_db,DBStatic.mysql_username,DBStatic.mysql_password ));
		}
		else{
			if ( database==null ) {
				database=new Database ("jdbc/db") ;
			}
			return (database.getConnection( )) ;
		}
	 }

}
