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
	href="<%=request.getContextPath()%>/css/style.css">
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
		Articles art = (Articles) request.getAttribute("art");
	%>

	<div class="container">

		<div class="row text-center">

			<div class="container img-responsive col-lg-5 col-sm-8 ">
				<img src="./img/carotte.jpeg" style="max-width: 100%;">
			</div>

			<div class="container col-lg-7 col-sm-12 ">

				<div class="container col-12">
					<h1>Détail vente</h1>
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
								Manager manager = new Manager();
								Utilisateurs user = manager.getUser(art.getNo_acheteur());
								out.print(" " + user.getPseudo());
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
						<%user = manager.getUser(art.getNoUtilisateur()); 
						request.setAttribute("profil", user);%>
						<strong>Vendeur : </strong>
						<a href="profil">	
							<%
								out.print(user.getPseudo());
							%>
						</a>
					</div>
				</div>
				<div class="container col-7">

					<form method="post" action="enchere">
						<div class="row">

							<p>
								<strong>Ma proposition : </strong>
							<p>
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
</body>
</html>