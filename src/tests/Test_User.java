package tests;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.json.JSONObject;

public class Test_User {

	
	
	@Test
	void test1() {
		
		Date date;
		date = Date.valueOf("1998-05-03");
		
		JSONObject json=services.User.createUser("M", "M", "M", "M", "MAX98@gmail.com",date);	
		//JSONObject json=services.User.deleteUser("AnisAknouche","Anis1111" );
		
		System.out.println(json.toString());
		
		
	}
}
