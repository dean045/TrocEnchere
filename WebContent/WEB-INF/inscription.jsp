<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="style.css">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Page profil</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body class="container">
	<%session = request.getSession(); %>
	<header class="col-12 d-flex  ">
		<div>
			<h1>ENI-Enchère</h1>
		</div>
	</header>
	<h2><%if(session.isNew()) out.print("Inscription"); 
	else out.print("Mon profil");%></h2>
	<form action="inscription" method="post">
		<div class="container d-flex">
			<div class="container  col-sm-6 d-flex p-2 bd-highlight mx-auto">
				<div class="row">

					<div class="form-group">
						<label for="exampleInputSurPseudo">Pseudo</label> <input
							type="Pseudo" class="form-control" name="pseudo"
							placeholder="Pseudo">
					</div>

					<div class="form-group">
						<label for="exampleInputSurName">Prénom</label> <input
							type="Prenom" class="form-control" name="pernom"
							placeholder="Prenom">
					</div>

					<div class="form-group">
						<label for="exampleInputSurPhoneNumber">Numéro de
							téléphone</label> <input type="PhoneNumber" class="form-control"
							name="telephone" placeholder="Numéro de téléphone">
					</div>

					<div class="form-group">
						<label for="exampleInputSurPostalCode">Code Postal</label> <input
							type="PostalCoder" class="form-control"
							name="code_postal" placeholder="Code Postal">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">Mot de passe</label> <input
							type="password" class="form-control" name="mot_de_passe"
							placeholder="Mot de passe">
					</div>
				</div>
			</div>

			<div class="container  col-sm-6 d-flex p-2 bd-highlight mx-auto">
				<div class="row">
					<div class="form-group">
						<label for="exampleInputName">Nom</label> <input type="text"
							class="form-control" name="nom" placeholder="Nom">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Adresse mail</label> <input
							type="email" class="form-control" name="email"
							aria-describedby="emailHelp" placeholder="Renseignez votre Email">
					</div>

					<div class="form-group">
						<label for="exampleInputStreet">Rue</label> <input type="text"
							class="form-control" name="rue" placeholder="Rue">
					</div>

					<div class="form-group">
						<label for="exampleInputCity">Ville</label> <input type="text"
							class="form-control" name="ville" placeholder="Ville">
					</div>

					<div class="form-group">
						<label for="exampleInputConfirmPassword1">Confirmation</label> <input
							type="password" class="form-control"
							name="confirm" placeholder="Confirmation">
					</div>
				</div>
			</div>
			<br>
		</div>
		<div class="container">
			<button type="submit" class="btn btn-primary">Confirmer</button>
			<a href="login" class="btn btn-primary">Annuler</a>
		</div>

	</form>