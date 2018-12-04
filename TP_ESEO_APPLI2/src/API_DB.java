
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class API_DB {

	/* Connexion à la base de données */
	String url = "jdbc:mysql://127.0.0.1:8889/maven";
	String driver = "com.mysql.cj.jdbc.Driver";
	String utilisateur = "jack";
	String motDePasse = "jack";
	Connection connexion = null;
    Statement statement = null;
    ResultSet resultat = null;
    
    Double latitude;
    Double longitude;

	public Double getLatitue(String ville, String code) throws SQLException {
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( driver );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery( "SELECT Latitude FROM ville_france WHERE Nom_commune='"+ville+"' AND Code_postal='"+code+"' ;" );
		    
		    while (resultat.next()) {
		    	latitude = Double.parseDouble(resultat.getString("Latitude"));
		    }
		    return latitude;
	}
	
	public Double getLongitude(String ville, String code) throws SQLException {
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( driver );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery( "SELECT Longitude FROM ville_france WHERE Nom_commune='"+ville+"' AND Code_postal='"+code+"' ;");
		    
		    while (resultat.next()) {
		    	longitude = Double.parseDouble(resultat.getString("Longitude"));
		    }
		    return longitude;
	}
	
	
	public List<String> getVille(String ville) throws SQLException {
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( driver );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery( "SELECT Nom_commune, Code_postal FROM ville_france WHERE Nom_commune LIKE '%"+ ville+"%' ;");
		    ArrayList<String> array = new ArrayList<String>();
		    while (resultat.next()) {
		    	String nomCommune = resultat.getString( "Nom_commune" );
		    	String codePostal = resultat.getString( "code_postal" );
		    	array.add(nomCommune);
		    	array.add(codePostal);
		    }
		    return array;
	}
	
    
    public double degreesToRadians(double degrees) {
    	  return degrees * Math.PI / 180;
    }

    public long distanceInKmBetweenEarthCoordinates(double lat1, double lon1, double lat2, double lon2) {
    	  int earthRadiusKm = 6371;

    	  double dLat = degreesToRadians(lat2-lat1);
    	  double dLon = degreesToRadians(lon2-lon1);

    	  lat1 = degreesToRadians(lat1);
    	  lat2 = degreesToRadians(lat2);

    	  double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
    	          Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
    	  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
    	  return (long)Math.floor(earthRadiusKm * c + 0.5d);
    	}

}
