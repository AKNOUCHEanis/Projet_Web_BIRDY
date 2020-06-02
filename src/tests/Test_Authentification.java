package tests;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import tools.Cle;

public class Test_Authentification {

	
	
	
	
	@Test
	void test_LogIn() {
		JSONObject json=services.Authentification.logIn("MAXI", "MAXI98");
		try {
			assertTrue(json.get("OutPut").equals("OK"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void test_LogOut() {
		JSONObject json=services.Authentification.logOut("[C@54e1c68b");
		try {
			assertTrue(json.get("OutPut").equals("OK"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
