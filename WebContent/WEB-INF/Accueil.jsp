<%@page import="fr.eni.BO.Utilisateurs"%>
<%@page import="fr.eni.BO.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni.BO.Articles"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="style.css">
<head>
<meta charset="utf-8">
<title>Accueil</title>
<meta name="description">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body class="container-fluid">

	<%
		List<Articles> liste = new ArrayList<Articles>();
		liste = (List<Articles>) request.getAttribute("liste");
		List<Categories> categorie = new ArrayList<Categories>();
		categorie = (List<Categories>) request.getAttribute("listeCat");
	%>
	<header class="row">
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<div class="row "
		style="min-height: 250px; background-image: url(images/banniere2.png); background-size: cover; background-repeat: no-repeat;">
		<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 my-auto"
			style="width: 100%; height: 60%; max-height: 250px;">
			<form action="index" method="post">
				<div
					class="row col-sm-3 col-md-4 col-lg-4 col-xl-4 d-flex justify-content-center">
					<label class="font-weight-bold "
						style="color: white; margin-right: 2%">Categorie : </label> <select
						name="nom_select">
						<option value="0">Toutes</option>
						<%
							for (int i = 0; i < categorie.size(); i++) {
						%>
						<option value="<%out.print(categorie.get(i).getNo_categorie());%>">
							<%
								out.print(categorie.get(i).getLibelle());
							%>
						</option>
						<%
							}
						%>
					</select>
				</div>
				<%
					if (null != session.getAttribute("user")) {
						Utilisateurs user = (Utilisateurs) session.getAttribute("user");
				%>
				<script src="asset/js.js"></script>
				<div
					class="row container d-flex justify-content-center col-sm-4 col-md-4 col-lg-4 col-xl-4">
					<div class="col-3">
						<input type="radio" id="radio_a" name="radio" value="achat"
							checked="checked"> <label>Achat</label>
					</div>
					<div class="col-3">
						<input type="radio" id="radio_v" name="radio" value="vente">
						<label>Vente</label>
					</div>

				</div>

				<div class="row d-flex justify-content-center col-sm-4 col-md-4 col-lg-4 col-xl-4 border rounded" 
				style="width: 250px; margin-left: 5%;">
					<div id="achat">
						<div class="row d-flex justify-centent-center">
							<div style="margin-right: 5px;">
								<input type="radio" name="check" value="0" checked="checked">
							</div>
							<label for="scales">enchères en cours</label>
						</div>

						<div class="row d-flex justify-centent-center">
							<div style="margin-right: 5px;">
								<input type="radio" name="check" value="1">
							</div>
							<label>mes enchères en cours</label>
						</div>

						<div class="row d-flex justify-centent-center">
							<div style="margin-right: 5px;">
								<input type="radio" name="check" value="2">
							</div>
							<div>
								<label>mes enchères remportées</label>
							</div>
						</div>

					</div>
					<div id="vente" style="display: none;">
						<div class="row d-flex justify-centent-center">
							<div style="margin-right: 5px;">
								<input type="radio" name="check2" value="0" checked>
							</div>
							<label for="scales">mes ventes en cours</label>
						</div>

						<div class="row d-flex justify-centent-center">
							<div style="margin-right: 5px;">
								<input type="radio" name="check2" value="1">
							</div>
							<label for="scales">ventes non débutées</label>
						</div>

						<div class="row d-flex justify-centent-center">
							<div style="margin-right: 5px;">
								<input type="radio" name="check2" value="2">
							</div>
							<label for="scales">ventes terminées</label>
						</div>
					</div>
				</div>
				<script src="asset/js.js"></script>
				<%
					}
				%>
				<div
					class="row col-sm-4 col-md-4 col-lg-4 col-xl-4 d-flex justify-content-center" style="margin-top: 2%;">
					<button type="submit" class="btn btn-primary" name="chercher">Chercher</button>
				</div>
			</form>
		</div>
	</div>


	<br>


	<div class="container row col-12 border " style="margin-bottom: 1%;">
		<div class="row d-flex justify-content-center mx-auto">
			<%
				for (int i = 0; i < liste.size(); i++) {
			%>
			<div class="d-flex justify-content-center mt-4"
				style="min-width: 300px;">
				<div class="card p-2 bg-white">
					<i class="fa fa-apple"></i>
					<div class="about-product text-center mt-2">
						<img src="images/img.jpg" width="200">
						<div>
							<h4>
								<%
									out.print(liste.get(i).getNomArticle());
								%>
							</h4>
						</div>
					</div>
					<div class="stats mt-2">
						<%
							if (liste.get(i).getPseudo() != null) {
						%>
						<div class="d-flex justify-content-between p-price">
							<span>Vendeur : </span><span> <%
 	out.print(liste.get(i).getPseudo());
 %>
							</span>
						</div>
						<%
							}
						%>
						<div class="d-flex justify-content-between p-price">
							<span>Date de fin</span><span> <%
 	out.print(liste.get(i).getDateFinEnchere().toString());
 %>
							</span>
						</div>
					</div>
					<div
						class="d-flex justify-content-between total font-weight-bold mt-4">
						<span>Prix</span><span> <%
 	out.print(liste.get(i).getPrixVente());
 %>
						</span>
					</div>
					<div>
						<form action="vente" method="get">
							<div class="d-flex justify-content-center">
								<button class="btn btn-secondary btn-sm mx-auto"
									name="no_article" type="submit"
									value="<%out.print(liste.get(i).getNoArticle());%>">Voir
									l'annonce</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
<body />