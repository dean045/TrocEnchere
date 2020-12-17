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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body class="container">
	<%
		List<Articles> liste = new ArrayList<Articles>();
		liste = (List<Articles>) request.getAttribute("liste");
	%>
	<header class="row">
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<nav class="navbar navbar-expand-sm bg-light navbar-light rounded">
		<ul class="navbar-nav">
			<li class="nav-item">
				<form class="form-inline" action="/action_page.php">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
            <path fill-rule="evenodd"
										d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z" />
            <path fill-rule="evenodd"
										d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z" />
          </svg>
							</span>
						</div>
						<input type="text" class="form-control" placeholder="Rechercher">
					</div>
				</form>
			</li>

			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> Catégories </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Ameublement</a> <a
						class="dropdown-item" href="#">Informatique</a> <a
						class="dropdown-item" href="#">Vêtements</a>
				</div></li>
		</ul>
	</nav>
	<br>


	<div class="container col-12 border d-flex justify-content-around"
		style="margin-bottom: 1%;">
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
<body />