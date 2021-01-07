<%@page import="fr.eni.BO.Utilisateurs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="style.css">
<head>
<meta charset="utf-8">
<title>Inscription</title>
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

	<header class="row">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<h2>Inscriptions</h2>
	<%
		if (request.getAttribute("message") != null)
			out.print(request.getAttribute("message"));
	%>
	<form action="inscription" method="post">
		<div class="container">
			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurPseudo">Pseudo</label> <input required
						type="Pseudo" class="form-control" name="pseudo"
						placeholder="Pseudo">
				</div>
				<br>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputEmail1">Adresse mail</label> <input required
						type="email" class="form-control" name="email"
						aria-describedby="emailHelp" placeholder="Renseignez votre Email">

				</div>

			</div>

			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurName">Prénom</label> <input required
						type="Prenom" class="form-control" name="prenom"
						placeholder="Prenom">
				</div>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputName">Nom</label> <input type="text" required
						class="form-control" name="nom" placeholder="Nom">
				</div>
			</div>

			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurPhoneNumber">Numéro de téléphone</label>
					<input type="PhoneNumber" class="form-control" name="telephone"
						placeholder="Numéro de téléphone">
				</div>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurPostalCode">Code Postal</label> <input required
						type="PostalCoder" class="form-control" name="code_postal"
						placeholder="Code Postal">
				</div>
			</div>
			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputStreet">Rue</label> <input type="text" required
						class="form-control" name="rue" placeholder="Rue">
				</div>

				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputCity">Ville</label> <input type="text" required
						class="form-control" name="ville" placeholder="Ville">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputPassword1">Mot de passe</label> <input required
						type="password" class="form-control" name="mot_de_passe"
						placeholder="Mot de passe">
				</div>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputConfirmPassword1">Confirmation</label> <input required
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
				<a href="login" class="btn btn-primary">Annuler</a>
			</div>

		</div>

	</form>