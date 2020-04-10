package servlets;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class Amis
 */
@WebServlet("/Amis")
public class Amis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Amis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Ajouter un ami
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("user");
		String userToAdd=request.getParameter("userToAdd");
		String cleHash=request.getParameter("cle");
		
		JSONObject json=services.Amis.addFriend(user,userToAdd,cleHash);
		
		Writer writer= response.getWriter();
		writer.append(json.toString());
	}
	
	/**
	 * Supprimer un ami
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("user");
		String userToRemove=request.getParameter("userToRemove");
		String cleHash=request.getParameter("cle");
		
		JSONObject json=services.Amis.removeFriend(user,userToRemove,cleHash);
		
		Writer writer= response.getWriter();
		writer.append(json.toString());
	}

}
