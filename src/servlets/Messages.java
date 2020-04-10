package servlets;

import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import tools.Cle;

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

		
		JSONObject json=services.Messages.getListMessages(nomUtilisateur,cleHash);
		
		response.setContentType("application/json");
		Writer writer=response.getWriter();
		writer.append(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * pour ajouter un message
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=request.getParameter("Message");
		String nomUtilisateur=request.getParameter("NomUtilisateur");
		String cleHash=request.getParameter("Cle");
		
		JSONObject json=services.Messages.ajouter(message,nomUtilisateur,cleHash);
	
		Writer writer=response.getWriter();
		writer.append(json.toString());
	}
	
	/**
	 *pour supprimer un message
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idMessage=request.getParameter("IdMessage");
		String cleHash=request.getParameter("Cle");
		
		JSONObject json=services.Messages.supprimer(idMessage,cleHash);
		
		Writer writer=response.getWriter();
		writer.append(json.toString());
	}
	
	/**
	 *pour modifier un message
	 */
	protected void doPut(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String idMessage=request.getParameter("IdMessage");
		String message=request.getParameter("Message");
		String cleHash=request.getParameter("cle");
		
		
		JSONObject json=services.Messages.modifier(idMessage,message,cleHash);
		
		Writer writer=response.getWriter();
		writer.append(json.toString());
		
	}
	

}
