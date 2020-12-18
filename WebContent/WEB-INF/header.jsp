<div class="container border rounded"
	style="margin-top: 1%; margin-bottom: 2%;">
	<div class="row">
		<%
			session = request.getSession();
		%>
		<a class="col-8 navbar-brand" href="index">Eni-Enchère</a>
		<%
			if (null == session.getAttribute("user")) {
		%>
		<div class="col-3">
			<a class="navbar-brand" href="login">Se connecter</a>
		</div>

		<%
			} else {
		%>
		<div class="col-3">
			<div class="row">
				<a class="navbar-brand col-5" href="profil">Mon Profil</a>
				<form action="index" method="post" class="col-5">
					<button class="btn btn-primary" name="log" value="off">Déconnexion</button>
				</form>
			</div>
		</div>

		<%
			}
		%>
	</div>
</div>