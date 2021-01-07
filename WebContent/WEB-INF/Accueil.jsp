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

	<div class="row"
		style="min-height: 250px; background-image: url(images/Bannière.png); background-size: cover; background-repeat: no-repeat;">
		<div class="col-4 border my-auto"
			style="margin-left: 3%; width: 80%; height: 60%; max-height: 250px;">

			<form action="index" method="post">
				<div class="row">
					<label style="color: white;">Categorie : </label> <select
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
				<%if(null != session.getAttribute("user")){
					Utilisateurs user = (Utilisateurs) session.getAttribute("user");	
				%>
					<script src="asset/js.js"></script>
					<div class="row">
						<input type="radio" id="radio_a" name="radio" value="achat" checked> 
						<label for="vente">Achat</label> 
						<input type="radio" id="radio_v" name="radio" value="vente" >
						<label for="huey">Vente</label>
					</div>
					
					<div class="row">
						<div class="col-6" id="achat">
							<div class="row">
								<input type="radio" id="all" name="check" value="0" checked> 
								<label for="scales">enchères en cours</label> 
							</div>
							
							<div class="row">
								<input type="radio" id="scales" name="check" value="1"> 
								<label for="scales">mes encères en cours</label> 
							</div>
							
							<div class="row">
								<input type="radio" id="scales" name="check" value="2">
								<label for="scales">mes enchères remportées</label>
							</div>
							
						</div>
						<div class="col-6" id="vente" style="display: none;">
							<div class="row">
								<input type="radio" id="all" name="check" checked> 
								<label for="scales">mes ventes en cours</label>
							</div>
							
							<div class="row">
								<input type="radio" id="scales"name="check"> 
								<label for="scales">ventes non débutées</label> 
							</div> 
							
							<div class="row">
								<input type="radio" id="scales" name="check">
								<label for="scales">ventes terminées</label>
							</div>
							
						</div>
						
					</div>
					<script src="asset/js.js"></script>
				<%}%>
				<div class="row">
					<button type="submit" class="btn btn-primary m-auto"
						name="chercher">Chercher</button>
				</div>

			</form>

		</div>
	</div>


	<br>


	<div class="container col-12 border d-flex justify-content-around"
		style="margin-bottom: 1%;">
		<div class="row">
			<%
				for (int i = 0; i < liste.size(); i++) {
			%>
			<div class="card col-sm-12 col-lg-6"
				style="max-width: 250px; max-height: 420px;">
				<img class="card-img-top"
					src="https://png.pngtree.com/png-vector/20190626/ourlarge/pngtree-math-in-computer-line-black-icon-png-image_1507318.jpg"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">
						<%
							out.print(liste.get(i).getNomArticle());
						%>
					</h5>
					<p class="card-text">
						Prix :
						<%
						out.print(liste.get(i).getPrixVente());
					%><br>Fin de l'enchère : <br>
						<%
							out.print(liste.get(i).getDateFinEnchere().toString());
						%>
						<%if(liste.get(i).getPseudo() != null){ %>
						<br> Vendeur :
						<%
							out.print(liste.get(i).getPseudo());
						%>
						<br>
						<%} %>
					</p>
				</div>
				<form action="vente" method="get">
					<div class="d-flex justify-content-center">
						<button class="btn btn-secondary btn-sm mx-auto" name="no_article"
							type="submit" value="<%out.print(liste.get(i).getNoArticle());%>">Voir
							l'annonce</button>
					</div>
				</form>
			</div>
			<%
				}
			%>
		</div>
	</div>
<body />