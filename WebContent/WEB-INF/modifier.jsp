<%@page import="fr.eni.BO.Utilisateurs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon compte</title>
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
	<%Utilisateurs user = (Utilisateurs)session.getAttribute("user"); %>

	<%
		if (request.getAttribute("message") != null)
			out.print(request.getAttribute("message"));
	%>
	<form action="modifier" method="post">
		<div class="container">
			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurPseudo">Pseudo</label> <input required
						type="text" class="form-control" name="pseudo"
						value="<%=user.getPseudo()%>">
				</div>
				<br>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputEmail1">Adresse mail</label> <input required
						type="email" class="form-control" name="email"
						aria-describedby="emailHelp" value="<%=user.getEmail()%>">

				</div>

			</div>

			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputSurName">Prénom</label> <input type="text" required
						class="form-control" name="prenom" value="<%=user.getPrenom()%>">
				</div>
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputName">Nom</label> <input type="text" required
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
						type="text" class="form-control" name="code_postal" required
						value="<%=user.getCode_postal()%>">
				</div>
			</div>
			<div class="row ">
				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputStreet">Rue</label> <input type="text" required
						class="form-control" name="rue" value="<%=user.getRue()%>">
				</div>

				<div class="form-group col-lg-6 col-sm-12">
					<label for="exampleInputCity">Ville</label> <input type="text" required
						class="form-control" name="ville" value="<%=user.getVille()%>">
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
				<a href="profil" class="btn btn-primary">Annuler</a>
			</div>

		</div>

	</form>
</body>
</html>