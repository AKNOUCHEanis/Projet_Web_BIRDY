package services;

public class User {

	public static JSONObject createUser (String login,String password,String nom,String prenom) {
		try {
			
			Connection c=Database.getMySQLConnection();
			if (login==null || password==null || nom==null || prenom ==null) {
				return tools.ErrorJSON.serviceRefused("champ(s) invalide(s)",1);
			}
			
			if (tools.User.userExist(login,c)) {
				return tools.ErrorJSON.serviceRefused("utilisateur dèja existant",1);
			}
			tools.User.insertUser(login,password,nom,prenom,c);
			return tools.ErrorJSON.serviceAccepted();
		}
		finally {
			c.close();
		}
	}
	
	public static JSONObject deleteUser (String login,String password) {
		try {
			Connection c=Database.getMySQLConnection();
			if (login==null || password==null) {
				return tools.ErrorJSON.serviceRefused("champ(s) invalide(s)",1);
			}
			
			if (!tools.User.userExist(login,c)) {
				return tools.ErrorJSON.serviceRefused("utilisateur inexistant",1);
			}
			tools.User.removeUser(login,password,c);
			return tools.ErrorJSON.serviceAccepted("Utilisateur supprimé");
		}
		finally {
			c.close();
		}
	}
	
}
