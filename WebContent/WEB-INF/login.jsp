<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Login</title>
</head>
<body>
	<header class="col-12">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<%
		String resultat = (String) request.getAttribute("resultat");
	%>
	<form action="login" method="post">

		<div class="border m-auto d-flex flex-column justify-content-center"
			style="padding: 2%; height: 400px; width: 300px;">
			<h5 class="my-auto" style="text-align: center">LOGIN</h5>
			<div class="form-group ">
				<label>Nom d'utilisateur</label> <input type="text"
					class="form-control" name="pseudo" aria-describedby="emailHelp"
					placeholder="Entrez pseudo">
			</div>
			<div class="form-group">
				<label>Mot de passe</label> <input type="password"
					class="form-control" name="mdp" placeholder="Mot de passe">
			</div>
			<div class="form-check">
				<input type="checkbox" class="form-check-input" name="memo">
				<label class="form-check-label" for="exampleCheck1">Mémoriser</label>
			</div>
			<button type="submit" class="btn btn-primary ">Se connecter</button>
			<%
				if (resultat != null)
					out.print("<p style=\"color:red; text-align : center;\">" + resultat + "</p>");
			%>
			<p style="text-align: center; margin-top: 10px;">Vous n'avez pas
				de compte ?</p>
			<a style="text-align: center" href="inscription">Creer un compte</a>
		</div>

	</form>
</body>
</html>