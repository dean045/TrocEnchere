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
		Utilisateurs user = (Utilisateurs) session.getAttribute("user");
	%>

	<header class="col-12">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<div class="container d-flex justify-content-center">
		<div class="row font-weight-bold">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<p>
					Pseudo :
					<%
					out.print(user.getPseudo());
				%>
				</p>
				<p>
					Nom :
					<%
					out.print(user.getNom());
				%>
				</p>
				<p>
					Prenom :
					<%
					out.print(user.getPrenom());
				%>
				</p>
				<p>
					Email :
					<%
					out.print(user.getEmail());
				%>
				</p>
				<p>
					Téléphone :
					<%
					out.print(user.getTelephone());
				%>
				</p>
				<p>
					Rue :
					<%
					out.print(user.getRue());
				%>
				</p>
				<p>
					Code Postal :
					<%
					out.print(user.getCode_postal());
				%>
				</p>
				<p>
					Ville :
					<%
					out.print(user.getVille());
				%>
				</p>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row text-center">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<form method="post" action="profil">
				<button name="button" class="btn btn-secondary" type="submit" value="modif">Modifier</button>
			</form>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row text-center">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<form method="post" action="profil">
				<button name="button" class="btn btn-secondary" type="submit" value="suppr">Supprimer</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>