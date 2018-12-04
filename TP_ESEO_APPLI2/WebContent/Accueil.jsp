<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
    
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="java.lang.Math"%>
<%@ page import = "java.lang.reflect.Type"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Distance Calculateur</title>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

 <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="Accueil.jsp">Boîte à outils</a>
  </nav><!-- end navigation -->
  
  
  <!-- contenu de la page -->
  <div class="content-wrapper">
    <div class="container-fluid">
   
 
 <!-- Vue globale -->     
      <h1>Calculateur distance ville</h1>
      <hr>
      
      <!-- Icon Cards-->
      <div class="row">
        <div class="card col-xl-8 col-sm-10 mb-8">
            <div class="card-body">
              <h5 class="card-title">Hello, Saisie le nom d'une ville</h5>       
            	<!-- formulaire -->
            	<div class="card-text">
            	<form method="post" action="Search">
  					<p>Ville 1 <input type="text" name="ville1"></p>
  					<p>Ville 2 <input type="text" name="ville2"></p>
  					<input type="submit" value="Submit" class="btn btn-primary">
				</form>
				</div>
			</div> <!-- end card body -->
          </div>    
     </div><!-- end row -->

	</div>
	</div>


<%@include file="footer.jsp" %>

</body>
</html>