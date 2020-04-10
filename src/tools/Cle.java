package tools;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Cle {
	private String cleHash;
	private LocalDateTime date;
	
	/**
	 * @param cleHash : chaine de caractere (Hashcode)
	 * @param date : indique la date de l'action la plus recente du client
	 */
	public Cle(String nomUtilisateur)
	{
		this.cleHash=hash(nomUtilisateur);
		
		this.date=java.time.LocalDateTime.now();
		this.date=this.date.plusMinutes(30);
	}
	
	public Cle() {
		// TODO Auto-generated constructor stub
	}
	
	public String hash(String username)
	{
		int taille=username.length();
		String cle="";
		String x=Integer.toString(taille);
		int i=0;
		int somme=0;
		while(i<taille) {
			
			somme+=username.codePointAt(i);
			i++;
			
		}
		
		
		
		i=0;
		for(i=0;i<x.length();i++) {
			cle=cle+x.charAt(i);
		}
		int t=x.length();
		int j=0;
		while(i<32 && j<taille) {
			cle=cle+username.charAt(j);
			i++;
			j++;
		}
		
		while(i<16) {
			char z=(char) (username.charAt(taille-1)/2+i);
			cle=cle+z;
			i++;
		}
		while(i<25) {
			char z=(char)(username.charAt(taille-1)-i+somme/3);
			cle=cle+z;
			i++;
		}
		while(i<32) {
			char z=(char)(username.charAt(taille-2)*2+i);
			cle=cle+z;
			i++;
		}
		
		return cle;
	}
	/**
	 * @param cle : chaine de caractere (HashCode)
	 */
	public void setCle(String cleHash)
	{
		this.cleHash=cleHash;
	}
	
	/**
	 * Ajoute à la date une durée d'1 heure
	 */


	/**
	 * @param date
	 */
	public void MAJ_Date()
	{
		this.date=this.date.plusMinutes(30);
	}
	
	/**
	 * @return la clé
	 */
	public String getCle()
	{
		return cleHash;
	}
	
	/**
	 * @return la date de l'action la plus recente de l'utilisateur
	 */
	public LocalDateTime getDate()
	{
		return this.date;
	}
}
