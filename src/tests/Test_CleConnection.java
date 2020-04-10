package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class Test_CleConnection {
	
	@Test
	void test() {
		boolean bool=tools.Connexion.verifierConnexion("[C@54e1c68b");
		assertTrue(bool);
	}

}
