<%@page import="fr.eni.BO.Utilisateurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon compte</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body class="container">
	<header class="row">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<%Utilisateurs user = (Utilisateurs)session.getAttribute("user"); %>
	<form action="inscription" method="post">
		<div class="container">
			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurPseudo">Pseudo</label> <input
						type="text" class="form-control" name="pseudo"
						value="<%=user.getPseudo()%>">
				</div>
				<br>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputEmail1">Adresse mail</label> <input
						type="email" class="form-control" name="email"
						aria-describedby="emailHelp" value="<%=user.getEmail()%>">

				</div>

			</div>

			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurName">Prénom</label> <input type="text"
						class="form-control" name="prenom" value="<%=user.getPrenom()%>">
				</div>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputName">Nom</label> <input type="text"
						class="form-control" name="nom" value="<%=user.getNom()%>">
				</div>
			</div>

			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurPhoneNumber">Numéro de téléphone</label>
					<input type="tel" class="form-control" name="telephone"
						value="<%=user.getTelephone()%>">
				</div>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurPostalCode">Code Postal</label> <input
						type="number" class="form-control" name="code_postal"
						value="<%=user.getCode_postal()%>">
				</div>
			</div>
			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputStreet">Rue</label> <input type="text"
						class="form-control" name="rue" value="<%=user.getRue()%>">
				</div>

				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputCity">Ville</label> <input type="text"
						class="form-control" name="ville" value="<%=user.getVille()%>">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputPassword1">Mot de passe</label> <input
						type="password" class="form-control" name="mot_de_passe"
						placeholder="Mot de passe">
				</div>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputConfirmPassword1">Confirmation</label> <input
						type="password" class="form-control" name="confirm"
						placeholder="Confirmation">
				</div>
			</div>
		</div>

		<br>
		<div class="row mx-auto">
			<div class="col-lg-1 col-sm-1 mx-auto">
				<button type="submit" class="btn btn-primary ">Confirmer</button>
			</div>
			<div class="col-lg-1 col-sm-1 mx-auto">
				<a href="profil" class="btn btn-primary">Annuler</a>
			</div>

		</div>

	</form>
</body>
</html>