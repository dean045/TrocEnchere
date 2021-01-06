<%@page import="fr.eni.BO.Utilisateurs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="fr.eni.BO.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni.BO.Articles"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Vendre un Article</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
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
Utilisateurs user = new Utilisateurs();
user = (Utilisateurs) session.getAttribute("user");
Articles art = (Articles) request.getAttribute("article");
List<Categories> categorie = new ArrayList<Categories>();
categorie = (List<Categories>)request.getAttribute("listeCat");
%>
	<header class="row">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<h2>Nouvelle vente</h2>

	<form action="creation_article" method="post">
		<div class="container">
			<div class="row">

				<! -- Bloc image justifier à gauche -->

				<div class="container col-5 " style="width: 500 px;">
					<div class="row justify-content-left">

						<img
							src="https://remove-white-background.imageonline.co/fr/pictureinput.jpg">

					</div>
					 <label for="avatar">Photo de l'article :</label> <input
							type="file" name="photo"
							accept="image/png, image/jpeg"> 
				</div>


				<! -- Bloc Nouvelle vente justifier à droite -->

				<div class="container col-7 " style="width: 500 px;">
					<div class="row justify-content-center">


						<div class="form-group">
							<label>Titre de la vente</label> <input
								type="text" class="form-control" name="nom"
								placeholder="Article">
						</div>

						<div class="form-group">
							<label>Description</label> <input
								type="text" class="form-control" name="descri"
								placeholder="Description">
						</div>

						<label>Catégories :</label> <select name="categorie">

							<option value="0">Toutes</option>
							<%
							for (int i = 0; i < categorie.size(); i++) {
							%>
							<option
								value="<%out.print(categorie.get(i).getNo_categorie());%>">
								<%
								out.print(categorie.get(i).getLibelle());
							%>
							</option>
							<%
							}
							%>
						<label>Prix</label>
						<input type="number" name="prix">


						<div>
							<label>Début de l'enchère :</label> <input type="date"
								name="date_debut">
						</div>


						<div>
							<label>Fin de l'enchère :</label> <input type="date"
								name="date_fin">
						</div>


						<br>
						<h4>Retrait</h4>
						<div class=" border">
							<div class="form-group">

								<label for="exampleInputStreet">Rue</label> <input type="text"
									class="form-control" name="rue" value="<%=user.getRue()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputCodePostal">CodePostal</label> <input
									type="text" class="form-control" name="codepostal"
									value="<%=user.getCode_postal()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputCity">Ville</label> <input type="text"
									class="form-control" name="ville" value="<%=user.getVille()%>" value="">
							</div>
						</div>
						<br>
						<div class="container">
							<button type="submit" class="btn btn-primary">Confirmer</button>
							<a href="index" class="btn btn-primary">Annuler</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</form>

</body>