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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Accueil</title>
<meta name="description">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body class="container">
	<%
		List<Articles> liste = new ArrayList<Articles>();
		liste = (List<Articles>) request.getAttribute("liste");
	%>
	<header class="col-12">
		<div class="container d-flex justify-content-between">
			<h1>ENI-Enchère</h1>
			<a href="login">S'inscrire - Se connecter</a>
		</div>

	</header>

	<div class="container col-10 ">
		<h2 class="col-12" style="text-align: center;">Liste des enchères</h2>
		<div class="container col-12 d-flex justify-content-between">
			<div class="col-6 container">
				<label for="site-search" class="col-12">Filtres:</label> <input
					type="search" id="site-search" name="q"
					aria-label="Search through site content">
			</div>

			<button class="col-6 btn btn-dark" style="height: 100px;">Rechercher</button>
		</div>

	</div>

	<label for="site-search">Catégories :</label>
	<select>
		<optgroup label="Catégories">
			<option>Toutes</option>
			<option>Informatique</option>
			<option>Ameublement</option>
			<option>Vêtements</option>
			<option>Sports et Loisirs</option>
		</optgroup>

	</select>

	<div class="container col-12 border d-flex justify-content-around">
		<%
			for (int i = 0; i < liste.size(); i++) {
		%>
		<div class="card col-sm-12 col-lg-6"
			style="max-width: 250px; max-height: 450px;">
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
					out.print(liste.get(i).getPrixInitial());
				%><br> Fin de l'enchère : <br>
					<%
						out.print(liste.get(i).getDateFinEnchere().toString());
					%><br> Vendeur :
					<%
						out.print(liste.get(i).getNoUtilisateur());
					%>
					<br>
				</p>
			</div>
			<form action="vente" method="get">
				<button name="no_article" type="submit" value="<%out.print(liste.get(i).getNoUtilisateur()); %>">Voir l'annonce</button>
			</form>
		</div>
		<%}%>

	</div>
<body />