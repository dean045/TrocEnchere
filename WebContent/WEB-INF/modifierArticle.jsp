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
<title>Insert title here</title>
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

	<h2>Nouvelle vente</h2>

	<form action="modifierArticle" method="post">
		<div class="container">
			<div class="row">

				<! -- Bloc image justifier à gauche -->

				<div class="container col-5 " style="width: 500 px;">
					<div class="row justify-content-left">

						<img
							src="https://remove-white-background.imageonline.co/fr/pictureinput.jpg">

					</div>
					<label for="avatar">Photo de l'article :</label> <input type="file"
						name="photo" accept="image/png, image/jpeg">
				</div>


				<! -- Bloc Nouvelle vente justifier à droite -->

				<div class="container col-7 " style="width: 500 px;">
					<div class="row justify-content-center">


						<div class="form-group">
							<label>Titre de la vente</label> <input type="text"
								class="form-control" name="nom_article" value="<%=art.getNomArticle()%>">
						</div>

						<div class="form-group">
							<label>Description</label> <input type="text"
								class="form-control" name="description"
								value="<%=art.getDescription()%>" placeholder="Description">
						</div>

						<label>Catégories :</label> <select name="categorie">

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

						</select> <label>Prix</label> <input type="number" name="prix_initial" value="<%=art.getPrixInitial()%>">


						<div>
							<label>Début de l'enchère :</label> <input type="date"
								name="date_debut_enchere" value="<%=art.getDateDebutEnchere()%>">
						</div>


						<div>
							<label>Fin de l'enchère :</label> <input type="date"
								name="date_fin_enchere" value="<%=art.getDateFinEnchere()%>">
						</div>


						<br>
						<h4>Retrait</h4>
						<div class=" border">
							<div class="form-group">

								<label for="exampleInputStreet">Rue</label> <input type="text"
									class="form-control" name="rue" placeholder="Rue" value="<%=art.getRue()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputCodePostal">CodePostal</label> <input
									type="text" class="form-control" name="code_postal"
									placeholder="CodePostal" value="<%=art.getCode_postal()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputCity">Ville</label> <input type="text"
									class="form-control" name="ville" placeholder="Ville" value="<%=art.getVille()%>">
							</div>
						</div>
						<br>
						<div class="container">
							<button type="submit" class="btn btn-primary" name="button" value="c<%=art.getNoArticle()%>">Confirmer</button>
							<a href="index" class="btn btn-primary">Annuler</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</form>

</body>
</html>