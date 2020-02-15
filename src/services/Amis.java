package services;

public class Amis{

	public static JSONObject addFriend (String user, String UserToAdd) {
		try {
			Connection c=Database.getMySQLConnection();
			if (user==null || UserToAdd==null) {
				return tools.ErrorJSON.serviceRefused("champ(s) invalide(s)",1);
			}
			if (!tools.User.userExist(UserToAdd,c)) {
				return tools.ErrorJSON.serviceRefused("utilisateur inexistant",1);
			}
			tools.Amis.insertF(user,UserToAdd,c);
			return tools.ErrorJSON.serviceAccepted();
		}
		finally {
			c.close();
		}
	}
	
	public static JSONObject removeFriend (String user, String UserToDelete) {
		try {
			Connection c=Database.getMySQLConnection();
			if (user==null || UserToDelete==null) {
				return tools.ErrorJSON.serviceRefused("champ(s) invalide(s)",1);
			}
			if (!tools.User.userExist(UserToAdd,c)) {
				return tools.ErrorJSON.serviceRefused("utilisateur inexistant",1);
			}
			tools.Amis.removeF(user,UserToDelete,c);
			return tools.ErrorJSON.serviceAccepted();
		}
		finally {
			c.close();
		}
	}
}
