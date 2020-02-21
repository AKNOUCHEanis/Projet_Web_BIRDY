package tools;

import java.util.Calendar;
import java.util.Date;

public class Cle {
	private String cleHash;
	private Date date;
	
	/**
	 * @param cleHash : chaine de caractere (Hashcode)
	 * @param date : date qui indique la fin de validit� de la cl�
	 */
	public Cle(String nomUtilisateur)
	{
		this.cleHash=hash(nomUtilisateur);
		this.date=new Date(new Date().getTime());
	}
	
	public Cle() {
		// TODO Auto-generated constructor stub
	}
	
	public String hash(String nom)
	{
		return null;
	}

	/**
	 * @param cle : chaine de caractere (HashCode)
	 */
	public void setCle(String cleHash)
	{
		this.cleHash=cleHash;
	}
	
	/**
	 * Ajoute � la date une dur�e d'1 heure
	 */

	public void setDateAdd()
	{
		
		Date hour= new Date(3600*1000);
		this.date=new Date (date.getTime()+hour.getTime());
	}
	/**
	 * @param date
	 */
	public void setDate(Date date)
	{
		this.date=date;
	}
	
	/**
	 * @return la cl�
	 */
	public String getCle()
	{
		return cleHash;
	}
	
	/**
	 * @return la date de fin de validit� de la cl�
	 */
	public Date getDate()
	{
		return date;
	}
}
