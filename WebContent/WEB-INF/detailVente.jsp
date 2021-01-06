<%@page import="fr.eni.BLL.Manager"%>
<%@page import="fr.eni.BO.Utilisateurs"%>
<%@page import="fr.eni.BO.Articles"%>
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
<title>Détail vente</title>
</head>

<body>

	<header class="col-12">
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<%
		session = request.getSession(false);
		Utilisateurs user = new Utilisateurs();
		user = (Utilisateurs) session.getAttribute("user");
		Articles art = (Articles) request.getAttribute("art");
		Manager manager = new Manager();
	%>

	<div class="container">

		<div class="row text-center">

			<div class="container img-responsive col-lg-5 col-sm-8 ">
				<img src="./img/carotte.jpeg" style="max-width: 100%;">
			</div>

			<div class="container col-lg-7 col-sm-12 ">

				<div class="container col-12">
					<%
						if (art.getEtat().equals("FN")) {
					%>
					<h1>
						Objet remporté par
						<%
						out.print(manager.getUser(art.getNo_acheteur()).getPseudo());
					%>
					</h1>
					<%
						} else {
					%>
					<h1>Détail vente</h1>
					<%
						}
					%>
				</div>

				<div class="container col-7">
					<div class="row">
						<strong>Nom de l'article :</strong>
						<p>
							<%
								out.print(art.getNomArticle());
							%>
						</p>
					</div>
				</div>

				<div class="container col-7">
					<div class="row">
						<strong>Description : </strong>
						<p>
							<%
								out.print(art.getDescription());
							%>
						</p>
					</div>
				</div>

				<div class="container col-7">
					<div class="row">
						<strong> Meilleure offre : </strong>
						<p>
							<%
								out.print(" " + art.getPrixVente() + " ");
							%>
						</p>
					</div>
					<div class="row">
						<strong> Meilleure Enchérisseur : </strong>
						<p>
							<%
								Utilisateurs user1 = manager.getUser(art.getNo_acheteur());
								out.print(" " + user1.getPseudo());
							%>
						</p>
					</div>
				</div>


				<div class="container col-7">
					<div class="row">
						<strong>Mise à prix : </strong>
						<p>
							<%
								out.print(art.getPrixInitial());
							%>
						</p>
					</div>
				</div>

				<div class="container col-7">
					<div class="row">
						<p>
							<strong>Fin de l'enchère :</strong>
							<%
								out.print(art.getDateFinEnchere());
							%>
						</p>
					</div>
				</div>

				<div class="container col-7">
					<div class="row">
						<p>
							<strong>Retrait : </strong>
							<%
								out.print(art.getRue() + " " + art.getCode_postal() + " " + art.getVille());
							%>
						</p>
					</div>
				</div>
				<div class="container col-7">
					<div class="row">
						<strong>Vendeur : </strong>
						<form action="profil" method="post">
							<button name="profil" class="btn btn-outline-dark"
								value="<%=art.getNoUtilisateur()%>" type="submit">
								<%
									out.print(manager.getUser(art.getNoUtilisateur()).getPseudo());
								%>
							</button>
						</form>

					</div>
				</div>
				<div class="container col-7">

					<form method="post" action="enchere">
						<div class="row">

							<p>
								<strong>Ma proposition : </strong>
							<p>
								<%
									if (null != request.getAttribute("msg")) {
								%>
							
							<p style="color: red">
								<%
									out.print(request.getAttribute("msg"));
								%>
							</p>
							<%
								}
							%>
							<input type="number" style="width: 75px; margin-left: 20px;"
								name="enchere" min=<%out.print(art.getPrixInitial());%>
								value=<%out.print(art.getPrixVente() + 1);%>>
						</div>

						<div class="container row">

							<button type="submit" class="btn btn-primary m-auto"
								name="noArticle" value=<%out.print(art.getNoArticle());%>>Enchérir</button>
						</div>
					</form>
				</div>

				<div class="container row" style="margin-top: 1%">

					<a href="index" class="btn btn-primary btn-block mx-auto"
						style="width: 13em">Retour à la page principale </a>

				</div>
			</div>

		</div>
	</div>

	<%
		if (null != session.getAttribute("user") && art.getNoUtilisateur() == user.getNo_utilisateur()) {
	%>
	<div class="container">
		<div class="row">
			<div class="col-3 container mx-auto">
				<div class="row">
					<div class="col-5">
						<form method="post" action="modifierArticle">
							<button name="button" class="btn btn-secondary" type="submit"
								value="m<%=art.getNoArticle()%>">Modifier</button>
						</form>
						<form method="post" action="modifierArticle">
							<button name="button" class="btn btn-secondary" type="submit"
								value="s<%=art.getNoArticle()%>">Supprimer</button>
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