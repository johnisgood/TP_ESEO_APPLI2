import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VsphereServlet
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* Connexion à la base de données */
	String url = "jdbc:mysql://127.0.0.1:8889/maven";
	String driver = "com.mysql.cj.jdbc.Driver";
	String utilisateur = "jack";
	String motDePasse = "jack";
	Connection connexion = null;
    Statement statement = null;
    ResultSet resultat = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		API_DB api = new API_DB();
		String ville1 = null;
		String ville2 = null;
		long result = 0;
		List<String> SearchRV1 = null;
		List<String> SearchRV2 = null;
		
		//Recupération des variables
		ville1 = request.getParameter("ville1");
		ville2 = request.getParameter("ville2");
		
		//Obtention des coordonnées de ces villes
		try {
			SearchRV1 = api.getVille(ville1);
			SearchRV2 = api.getVille(ville2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* -------- Save in session ----- */
		HttpSession session = request.getSession();
		session.setAttribute("SearchRV1", SearchRV1);
		session.setAttribute("SearchRV2", SearchRV2);
		
		/* -------- Renvoie vers la page dashboard----- */
        response.sendRedirect("SelectCity.jsp"); //logged-in page      	

		
	}

}