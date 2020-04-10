package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class Test_Amis {

	
	@Test
	void test() {
		
		JSONObject json=services.Amis.addFriend("ANISAknouche", "Hacene","12ANISAknouche@AǈǇǆǅǄǃǂǁǀéêëìíîï");
		//JSONObject json=services.Amis.removeFriend("ANISAknouche", "Hacene","12ANISAknouche@AǈǇǆǅǄǃǂǁǀéêëìíîï");
		System.out.println(json.toString());
	}
}
