package tools;

import java.util.Calendar;

public class Cle {
	private String cleHash;
	private Calendar date;
	
	/**
	 * @param cleHash : chaine de caractere (Hashcode)
	 * @param date : date qui indique la fin de validit� de la cl�
	 */
	public Cle(String cleHash,Calendar date)
	{
		this.cleHash=cleHash;
		this.date=date;
	}
	
	public Cle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cle : chaine de caractere (HashCode)
	 */
	public void setCle(String cleHash)
	{
		this.cleHash=cleHash;
	}
	
	/**
	 * Ajoute � la date une dur�e d'un jour
	 */
	public void setDateAdd()
	{
		date.add(Calendar.DAY_OF_MONTH, 1);
		
	}
	/**
	 * @param date
	 */
	public void setDate(Calendar date)
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
	public Calendar getDate()
	{
		return date;
	}
}
