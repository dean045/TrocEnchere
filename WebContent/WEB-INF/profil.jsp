<%@page import="fr.eni.BO.Utilisateurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Profil</title>
</head>
<body>
	<%
		Utilisateurs user = (Utilisateurs) request.getAttribute("user");
	%>
	
	
	<div class="container" style="border: solid black 1px">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				
				<p>nom user: <%=user.getNom() %></p>
				
			</div>
		</div>
	</div>
</body>
</html>