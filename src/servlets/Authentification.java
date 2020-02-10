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
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * effectue le LogOut d'un utilisateur
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hash=request.getParameter("Cle");
		Calendar date=(Calendar)request.getAttribute("Date");
		tools.Cle cle=new tools.Cle(hash,date);
		
		JSONObject json=services.Authentification.logOut(cle);
		
		Writer writer= response.getWriter();
		writer.append(json.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * effectue le LogIn d'un utilisateur
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomUtilisateur = request.getParameter("NomUtilisateur");
		String motDePasse=request.getParameter("MotDePasse");
		
		JSONObject json=services.Authentification.logIn(nomUtilisateur, motDePasse);
		
		Writer writer=response.getWriter();
		writer.append(json.toString());
		
	}

}
