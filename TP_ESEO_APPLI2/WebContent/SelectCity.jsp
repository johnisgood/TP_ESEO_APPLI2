<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.Math"%>
<%@ page import="java.lang.reflect.Type"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select city</title>
</head>


<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<%
		ArrayList<String> SearchRV1 = (ArrayList<String>) session.getAttribute("SearchRV1");
		ArrayList<String> SearchRV2 = (ArrayList<String>) session.getAttribute("SearchRV2");
	%>

	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav"> <a class="navbar-brand" href="Accueil.jsp">Boîte
		à outils</a> </nav>
	<!-- end navigation -->


	<!-- contenu de la page -->
	<div class="content-wrapper">
		<div class="container-fluid">


			<!-- Vue globale -->
			<h1>Calculateur distance ville</h1>
			<hr>

			<!-- formulaire -->
			<form method="post" action="ComputeDistance">
			
				<!-- 1ere ville -->
				<div class="form-group">
					<label>Ville de départ</label> 
					<select class="form-control" name="ville1">
						<%
							for (int k = 0; SearchRV1.size() > k; k++) {
						%>
						<option><%=SearchRV1.get(k)%>, <%=SearchRV1.get(k + 1)%></option> 
						<%
							k = k + 1;}
						%>
					</select>
				</div>
				
				<!-- 2e ville -->
				<div class="form-group">
					<label>Ville d'arrivée</label> 
					<select class="form-control" name="ville2">
						<%
							for (int k = 0; SearchRV2.size() > k; k++) {
						%>
						<option><%=SearchRV2.get(k)%>, <%=SearchRV2.get(k + 1)%></option>
						<%
							k = k + 1;}
						%>
					</select>
				</div>
				
				<input type="submit" value="Valider" class="btn btn-primary">
				
			</form>

		</div>
	</div>



	<%@include file="footer.jsp"%>
</body>
</html>