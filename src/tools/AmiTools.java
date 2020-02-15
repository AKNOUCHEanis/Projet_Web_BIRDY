package tools;

public class AmiTools {
	
	public static void insertF (String user,String userToAdd,Connection c) {
		Statement st=c.createStatement();
		ResultSet rs=st.executeUpdate("INSERT INTO Friend ...");	
	}
	
	public static void removeUser (String user,String userToDelete,Connection c) {
		Statement st=c.createStatement();
		ResultSet rs=st.executeUpdate("DELETE FROM User ...");	
	}
	
}
