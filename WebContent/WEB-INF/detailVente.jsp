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


	<div class="text-center" id="titre">
		<h1 id="titre">
			<b>Détail vente</b>
		</h1>
	</div>

	<div class="col-xs-4 col-xl-12 col-md-12"></div>

	<strong>Nom de l'article :</strong>
	<%
		out.print(art.getNomArticle());
	%><br>
	<strong>Description : </strong>
	<%
		out.print(art.getDescription());
	%><br />
	<br>
	<img src="./lib/image.jpg" class="img-fluid" alt="Responsive image">
	<%
		out.print(art.getImg());
	%><br />
	<br>


	<strong> Meilleure offre : <%
		out.print(art.getPrixVente());
	%></strong>$
	par :
	<a href="AutreProfil=${pseudoEnchere}">${pseudoEnchere}</a>
	<br />
	<br>
	<strong>Mise à prix : </strong>
	<%
		out.print(art.getPrixInitial());
	%><br />
	<strong><br>Fin de l'enchère :</strong>
	<%
		out.print(art.getDateFinEnchere());
	%><br />
	<br>
	<strong>Retrait : </strong>
	<br>

	<div class="col-xl-4">
		<%
			out.print(art.getRetrait());
		%>
	</div>

	<br>
	<strong>Vendeur : </strong>
	<%
		out.print(art.getNoUtilisateur());
	%>
	<a href="AutreProfil?pseudo=${pseudoVente}"><br> <br></a>


	<div class="row">
		<div class="col-xs-6">
			<strong>Ma proposition : </strong>
		</div>
		<div class="col-xs-4">
			<input type="number" class="" id="propoEnchere" name="sPropoEnchere"
				min=<%out.print(art.getPrixInitial());%>
				value=<%out.print(art.getPrixVente() + 1);%>>
		</div>

		<div class="col-xs-2">
			<button type="submit" class="btn btn-primary" name="Encherir"
				value="Encherir">Enchérir</button>
			<br> <br>
		</div>
	</div>

	</form>
	</div>

	<div class="col-xs-8 xl-4">
		<br /> <a href="./index"><button type="submit"
				class="btn btn-primary btn-block">Retour à la page
				principale</button></a><br> <br />
	</div>
	</div>
	</div>



</body>
</html>