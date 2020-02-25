package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.Connection;
import tools.Date;
import tools.String;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
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
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username= request.getParameter("username");
		String password=request.getParameter("password");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		Date dateNaiss=request.getParameter("dateNaissance");
		
		JSONObject json=services.User.createUser(username,password,nom,prenom,email,dateNaiss);
		
		Writer writer=response.getWriter();
		writer.append(json.toString());
	}
	
	protected void doDelete (HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password=request.getParameter("password");
		
		JSONObject json=services.User.deleteUser(username,password);
		
		Writer writer=response.getWriter();
		writer.append(json.toString());
	}

}
