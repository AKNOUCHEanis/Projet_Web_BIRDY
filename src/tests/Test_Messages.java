package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;

import tools.Cle;

class Test_Messages{

	@Test
	void test() {
		MongoDatabase mongoDb=bd.DataBase.getMongoDBConnection();
		
		tools.Cle cle=new tools.Cle("hashcode");
		//JSONObject json=tools.Message.ajouterMessage("Texet du Message3", "nomUtilisateur", mongoDb);
		//JSONObject json=tools.Message.getListMessages("nomUtilisateur", cle, mongoDb);
		//JSONObject json=tools.Message.supprimer("5e4f256c02ec0226977a60ec", cle, mongoDb);
		JSONObject json=services.Messages.modifier("5ed69d7db810cb25e470e246"," modifié","13HaceneHaddadiCǺǹǸǷǶǵǴǳǲáâãäåæç");
		System.out.println(json.toString());
	}

}
