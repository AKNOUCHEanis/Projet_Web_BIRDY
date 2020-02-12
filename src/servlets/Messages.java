package servlets;

import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class Messages
 */
@WebServlet("/Messages")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * retourne une liste de messages
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cleHash=request.getParameter("Cle");
		String nomUtilisateur=request.getParameter("NomUtilisateur");
		Calendar date=(Calendar)request.getAttribute("Date");
		tools.Cle cle=new tools.Cle(cleHash,date);
		
		JSONObject json=services.Messages.getListMessages(nomUtilisateur,cle);
		
		Writer writer=response.getWriter();
		writer.append(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * pour ajouter un message
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=request.getParameter("Message");
		String cleHash=request.getParameter("Cle");
		Calendar date=(Calendar)request.getAttribute("Date");
		tools.Cle cle=new tools.Cle(cleHash,date);
		
		JSONObject json=services.Messages.ajouter(message,cle);
		
		Writer writer=response.getWriter();
		writer.append(json.toString());
	}
	
	/**
	 *pour supprimer un message
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idMessage=request.getParameter("IdMessage");
		String cleHash=request.getParameter("Cle");
		Calendar date=(Calendar)request.getAttribute("Date");
		tools.Cle cle=new tools.Cle(cleHash,date);
		
		JSONObject json=services.Messages.Supprimer(idMessage,cle);
		
		Writer writer=response.getWriter();
		writer.append(json.toString());
	}
	

}
