package tools;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Cle {
	private String cleHash;
	private Date date;
	
	/**
	 * @param cleHash : chaine de caractere (Hashcode)
	 * @param date : date qui indique la fin de validité de la clé
	 */
	public Cle(String nomUtilisateur)
	{
		this.cleHash=hash(nomUtilisateur);
		this.date=new Date(new Date().getTime());
	}
	
	public Cle() {
		// TODO Auto-generated constructor stub
	}
	
	public String hash(String nomUtilisateur)
	{
		int x=nomUtilisateur.hashCode();
		String y=Integer.toString(x);
		int taille=y.length();
		char hash[]=new char[32];
		Random r=new Random();
		int i=0;
		for(i=0;i<taille;i++) {
			hash[i]=y.charAt(i);
		}
		for(i=taille;i<32;i++) {
			hash[i]=(char)(r.nextInt(26)+'A');
		}
		return hash.toString();
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

	public void setDateAdd()
	{
		
		Date hour= new Date(3600*1000);
		this.date=new Date (date.getTime()+hour.getTime());
	}
	/**
	 * @param date
	 */
	public void MAJ_Date()
	{
		this.date=new Date(new Date().getTime());
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
	public Date getDate()
	{
		return date;
	}
}
