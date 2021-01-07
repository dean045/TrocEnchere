
<%@page import="fr.eni.BO.Utilisateurs"%>
<%
	int timeout = session.getMaxInactiveInterval();
	response.setHeader("Refresh", timeout + "; URL = index.jsp");
%>

<div class="container-fluid" style="margin-top: 1%; margin-bottom: 2%;">

	<%
		session = request.getSession();
		Utilisateurs user_profil = new Utilisateurs();
		if (null != request.getAttribute("profil")) {
			user_profil = (Utilisateurs) request.getAttribute("profil");
		} else {
			user_profil = (Utilisateurs) session.getAttribute("user");
		}
	%>


	<div class="row d-flex justify-content-between">
		<%
			session = request.getSession();
		%>
		<a class="navbar-brand col-sm-12 col-md-12 col-lg-12 col-xl-3" href="index" style="margin-left: 2%">
			<img src="images/logo.png" width="70" height="70" alt="">
		</a>
		
		<h1 class="col-sm-12 col-md-12 col-lg-6 col-xl-3" style="text-align: center; text-transform: uppercase;">Eni-Enchères</h1>
		<%
			if (null == session.getAttribute("user")) {
		%>
		<!--  <a class="" href="creation_article">Vendre</a>-->
		<div class="col-sm-12 col-md-12 col-lg-6 col-xl-3 d-flex flex-column justify-content-center">
			<a href="login" class="m-auto"> <img src="images/picto_eniEnchere.png" width="40"></a>
			<a href="login" class="m-auto">S'inscrire / Se connecter</a>
		</div>
		
		<%
			} else {
				Utilisateurs user = (Utilisateurs) session.getAttribute("user");
		%>

		<div class="col-sm-12 col-md-12 col-lg-6 col-xl-3 center">			
			<div class="row d-flex justify-content-center">
				<p style="text-align: center;">
					Bonjour <% out.print(user_profil.getPseudo());%><br>  
					Crédit disponible : <% out.print(user.getCredit());%> points <br>														
				</p>
			</div>
			<div class="row d-flex justify-content-center">
					<a class="btn btn-primary btn-sm" href="profil" role="button" style="height: 30px; margin-right: 2%;">Profil</a> 						
					<a class="btn btn-primary btn-sm" href="creation_article" role="button" style="height: 30px ; margin-right: 2%;">Vendre</a>	
					<form action="index" method="post">
					<button class="btn btn-primary btn-sm" name="log" value="off" style="height: 30px ; margin-right: 2%;">Déconnexion</button>
					</form>	
			</div>
				
		</div>

		<%
			}
		%>
	</div>
</div>