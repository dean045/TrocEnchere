<%@page import="fr.eni.BO.Utilisateurs"%>
<% int timeout = session.getMaxInactiveInterval(); response.setHeader("Refresh", timeout + "; URL = index.jsp"); %>

<div class="container-fluid" style="margin-top: 1%; margin-bottom: 2%;">


	<div class="row d-flex justify-content-between">
		<%
			session = request.getSession();
		%>
		<a class="navbar-brand col-3" href="index" style="margin-left: 2%"> <img
			src="images/logo.png" width="70" height="70" alt="">
		</a>
		<h1 class="col-5" style="text-align: center;">Liste des enchères</h1>
		<%
			if (null == session.getAttribute("user")) {
		%>
		<a class="" href="creation_article">Vendre</a>
		<div class="col-lg-3 col-sm-5 d-flex flex-column justify-content-center">
			<a href="login" class="m-auto"> <img
				src="images/picto_eniEnchere.png" width="40">	
			</a>
			
			<a href="login"  class="m-auto">S'inscrire / Se connecter</a>
		</div>
		

		<%
			} else {
			Utilisateurs user = (Utilisateurs)session.getAttribute("user");	
		%>
		
		<div class="col-3">
			<div class="row">
				<a class="navbar-brand col-5" href="creation_article">Vendre</a>
				<div>
					<a class="navbar-brand col-5" href="profil">Mon Profil</a>
					<p>Crédit : <%out.print(user.getCredit());%> points</p>
				
				<form action="index" method="post" class="col-5">
				<button class="btn btn-primary" name="log" value="off">Déconnexion</button>
				</form>
				</div>	
			</div>
			
		</div>

		<%
			}
		%>
	</div>
</div>