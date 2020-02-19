package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;


import javax.naming.InitialContext;
import javax.naming.NamingException;
// class en charge de la connexion aux base de données
public class DataBase {
	
	private DataSource dataSource;
	private static DataBase database = null;
	
	public DataBase(String ressource_name) throws SQLException{
		try {
			// construire l'objet dataSource à partir du fichier de context
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/"+ressource_name);
		}catch (NamingException e) {
			throw new SQLException(ressource_name+" unreachable :"+e.getMessage());
		}
	}
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public static Connection getMySQLConnection() throws SQLException {
		// si on n'utilise pas le pooling 
		if(!BdStatic.mysql_pooling) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// on créer donc une nouvelle connexion
			return DriverManager.getConnection("jdbc:mysql://"+BdStatic.mysql_host+"/"+BdStatic.mysql_db, BdStatic.mysql_username, BdStatic.mysql_password);
			/* on notera toutefois que le port est nécéssaire si la bd n'est pas interfacer au port par défaut.
			 *  Ainsi jdbc:mysql://"+DBStatic.mysql_host+":"+DBStatic.mysql_port+"/"+DBStatic.mysql_bd
			 */
		}
		// si on utilise le pooling
		else {
			// si c'est la toute première connexion
			if(database == null) {
				/* on creer l'objet Database en indiquant le nom de la 
				 * ressource dans le fichier de context
				 */
				database = new DataBase("jdbc/db");
			}
			// on retourne la connexion du pooling
			return database.getConnection();
		}
	}
	public static MongoDatabase getMongoDBConnection()  {
		MongoClient mongo = MongoClients.create(BdStatic.mongo_host);
		MongoDatabase db=mongo.getDatabase(BdStatic.mongo_db);
		return db;
	}

}
