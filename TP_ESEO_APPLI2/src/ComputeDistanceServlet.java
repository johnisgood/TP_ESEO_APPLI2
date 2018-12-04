import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VsphereServlet
 */
@WebServlet("/ComputeDistance")
public class ComputeDistanceServlet extends HttpServlet {
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
    public ComputeDistanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		API_DB api = new API_DB();
		Double V1lat = null;
		Double V1lng = null;
		Double V2lat = null;
		Double V2lng = null;
		
		String ville1 = null;
		String ville2 = null;
		String[] V1;
		String[] V2;
		String V1name;
		String V2name;
		String V1code;
		String V2code;
		long result = 0;
		
		//Recupération des variables
		ville1 = request.getParameter("ville1");
		ville2 = request.getParameter("ville2");
		V1 = ville1.split(",");
		V2 = ville2.split(",");
		V1name = V1[0];
		V1code = V1[1].replaceAll(" ", "");
		V2name = V2[0];
		V2code = V2[1].replaceAll(" ", "");
		System.out.println(V1name);
		System.out.println(V1code);
		
		//Obtention des coordonnées de ces villes
		try {
			V1lat = api.getLatitue(V1name, V1code);
			System.out.println(V1lat);
			V1lng = api.getLongitude(V1name, V1code);
			V2lat = api.getLatitue(V2name, V2code);
			V2lng = api.getLongitude(V2name, V2code);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = api.distanceInKmBetweenEarthCoordinates(V1lat, V1lng, V2lat, V2lng);

		/* -------- Save in session ----- */
		HttpSession session = request.getSession();
		session.setAttribute("result", result);
		session.setAttribute("ville1", V1name);
		session.setAttribute("ville2", V2name);
		
		/* -------- Renvoie vers la page dashboard----- */
        response.sendRedirect("AfficheResult.jsp"); //logged-in page      	

		
	}

}