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
		session = request.getSession(false);
		Utilisateurs user_profil = new Utilisateurs();
		Utilisateurs user = new Utilisateurs();
		user = (Utilisateurs) session.getAttribute("user");
		if (null != request.getAttribute("profil")) {
			user_profil = (Utilisateurs) request.getAttribute("profil");
		} else {
			user_profil = (Utilisateurs) session.getAttribute("user");
		}
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
					out.print(user_profil.getPseudo());
				%>
				</p>
				<p>
					Nom :
					<%
					out.print(user_profil.getNom());
				%>
				</p>
				<p>
					Prenom :
					<%
					out.print(user_profil.getPrenom());
				%>
				</p>
				<p>
					Email :
					<%
					out.print(user_profil.getEmail());
				%>
				</p>
				<p>
					Téléphone :
					<%
					out.print(user_profil.getTelephone());
				%>
				</p>
				<p>
					Rue :
					<%
					out.print(user_profil.getRue());
				%>
				</p>
				<p>
					Code Postal :
					<%
					out.print(user_profil.getCode_postal());
				%>
				</p>
				<p>
					Ville :
					<%
					out.print(user_profil.getVille());
				%>
				</p>
			</div>
		</div>
	</div>
	<%
		if (null == request.getAttribute("profil")
				|| (null != session.getAttribute("user") && user_profil.equals(user))) {
	%>
	<div class="container">
		<div class="row">
			<div class="col-3 container mx-auto">
				<div class="row">
					<div class="col-5">
						<form method="post" action="profil">
							<button name="button" class="btn btn-secondary" type="submit"
								value="modif">Modifier</button>
						</form>
					</div>
					<div class="col-5">
						<form method="post" action="profil">
							<button name="button" class="btn btn-secondary" type="submit"
								value="suppr">Supprimer</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<%
		}
	%>

</body>
</html>