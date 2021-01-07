<%@page import="java.util.List"%>
<%@page import="fr.eni.BO.Articles"%>
<%@page import="fr.eni.BO.Utilisateurs"%>
<%@page import="fr.eni.BO.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Modifier Article</title>
</head>
<body class="container">
	<header class="row">
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<%
		Articles art = (Articles) request.getAttribute("article");
		List<Categories> categorie = new ArrayList<Categories>();
		categorie = (List<Categories>)request.getAttribute("listeCat");
	%>

	<form action="modifierArticle" method="post">

		<div class="container">

			<h2 class="text-center text-uppercase m-4">Modifier article</h2>

			<br>

			<div class="row text-left">


				<div class="container img-responsive col-lg-5 col-sm-8 ">

					<img src="./images/img.jpg" style="max-width: 100%;"> <label
						for="avatar">Upload image</label> <input type="file" name="photo"
						accept="image/png, image/jpeg">
				</div>

				<div class="container col-lg-7 col-sm-12 row mx-auto	">

					<div class="container col-7">

						<div class="row mt-2">
							<strong>Article :</strong> <input required type="text"
								class="form-control" name="nom" value="<%=art.getNomArticle()%>">
						</div>

						<div class="row mt-2">
							<strong>Description</strong>
							<textarea style="resize: none;" rows="5" cols="33" type="text"
								class="form-control" name="descri" value="<%=art.getDescription()%>"></textarea>
						</div>

						<div class="row mt-2">
							<strong style="width: 200px;">Catégories :</strong> <select
								name="categorie" required>

								<option value="0">Toutes</option>

								<%
								for (int i = 0; i < categorie.size(); i++) {
								%>
								<option <% if(String.valueOf(categorie.get(i).getNo_categorie()).equalsIgnoreCase(art.getCategorie())){ %>
								selected = "selected"
							<% 
								}
							%>
							}
									value="<%out.print(categorie.get(i).getNo_categorie());%>">
									<%
									out.print(categorie.get(i).getLibelle());
									%>
								</option>
								<%
								}
								%>
							</select>
						</div>
						<div class="row mt-2">
							<strong style="width: 200px">Prix</strong> <input type="number"
								class="form-control" required name="prix_initial" value="<%=art.getPrixInitial()%>" style="width: 100px">
						</div>

						<div class="row mt-2">
							<strong style="width: 200px">Début de l'enchère :</strong> <input
								type="date" name="date_debut_enchere" value="<%=art.getDateDebutEnchere()%>" required>
						</div>

						<div class="row mt-2">
							<strong style="width: 200px">Fin de l'enchère :</strong> <input
								type="date" name="date_fin_enchere" required value="<%=art.getDateFinEnchere()%>">
						</div>

						<br>


						<div class="row">
							<strong>Retrait</strong>
						</div>
						<div class="border row">


							<div class="form-group mx-auto">
								<label for="exampleInputStreet">Rue</label> <input type="text"
									required class="form-control" name="rue"
									 value="<%=art.getRue()%>">
							</div>

							<div class="form-group mx-auto">
								<label for="exampleInputCodePostal">CodePostal</label> <input
									required type="text" class="form-control" name="code_postal"
									value="<%=art.getCode_postal()%>">
							</div>

							<div class="form-group mx-auto">
								<label for="exampleInputCity">Ville</label> <input type="text"
									required class="form-control" name="ville"
									value="<%=art.getVille()%>" >
							</div>

						</div>
					</div>

					<br>

					<div class="container d-flex justify-content-center" style="margin-top: 2%">
						<button type="submit" class="btn btn-primary" name="button" value="c<%=art.getNoArticle()%>">Confirmer</button>
						<a href="index" class="btn btn-primary">Annuler</a>
					</div>
				</div>
			</div>

		</div>
	</form>

</body>
</html>