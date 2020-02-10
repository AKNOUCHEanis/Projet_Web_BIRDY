package tools;

public class Securite {

	/**
	 * @param nomUtilisateur
	 * @param motDePasse
	 * @return : retourne une clé de 32 caractere unique pour chaque entrée 
	 */
	public static Cle genererCle(String nomUtilisateur, String motDePasse) {

		Cle cle=new Cle();
		String hash="";
		//generer la cle 
		
		cle.setCle(hash);
		cle.setDateAdd();
				
		return cle;
	}

}
