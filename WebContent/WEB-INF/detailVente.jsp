<%@page import="fr.eni.BLL.Manager"%>
<%@page import="fr.eni.BO.Utilisateurs"%>
<%@page import="fr.eni.BO.Articles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Détail vente</title>
</head>

<body>

	<header class="col-12">
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<%
	session = request.getSession(false);
	Utilisateurs user = new Utilisateurs();
	user = (Utilisateurs) session.getAttribute("user");
	Articles art = (Articles) request.getAttribute("art");
	Manager manager = new Manager();
	%>

	<div class="container">

		<h2 class="text-center">Détail vente</h2>


		<div class="row text-center">


			<div class="container img-responsive col-lg-5 col-sm-8 ">
			
				<img src="./images/img.jpg" style="max-width: 100%;">
				
			</div>


			<div class="container col-lg-7 col-sm-12 ">


				<div class="container col-12">
					<%
						if (art.getEtat().equals("FN")) {
					%>
					<h1>
						Objet remporté par
						<%
							out.print(manager.getUser(art.getNo_acheteur()).getPseudo());
						%>
					</h1>
					<%
						} else {
					%>
					<%
						}
					%>
				</div>
				
				
				<div class="border">
				
					
					<div class="container col-7 display-4">
							<strong>	<%
 										 out.print(art.getNomArticle());
 										%>
							</strong>
					</div>

					<br>
					

					<div class="container col-7">
						<div class="row">
							<strong>Description :</strong>
							<p style = "margin-left: 5px;">
								<%
								out.print(art.getDescription());
								%>
							</p>
						</div>
					</div>

					<div class="container col-7">
						<div class="row">
							<strong> Meilleure offre : </strong>
							<p style = "margin-left: 5px;">
								<%
									out.print(" " + art.getPrixVente() + " ");
								%>
								points
							</p>
						</div>
						
					<div class="row">
							<strong> Meilleure Enchérisseur : </strong>
							<p style = "margin-left: 5px;">
								<%
									Utilisateurs user1 = manager.getUser(art.getNo_acheteur());
									out.print(" " + user1.getPseudo());
								%>
							</p>
						</div>
					</div>

					<div class="container col-7">
						<div class="row">
							<strong >Mise à prix : </strong>
							<p style = "margin-left: 5px;">
								<%
									out.print(art.getPrixInitial());
								%>
								points
							</p>
						</div>
					</div>

					<div class="container col-7">
						<div class="row">
							<p>
								<strong>Fin de l'enchère :</strong>
								<%
									out.print(art.getDateFinEnchere());
								%>
							</p>
						</div>
					</div>

					<div class="container col-7">
						<div class="row">
							<p>
								<strong>Retrait : </strong>
								<%
									out.print(art.getRue() + " " );
								%> 
							</p>
						<div class = "position-relative"  style ="margin-left: -111px;">
						<br>
							<%
								out.print (art.getCode_postal() + " " + art.getVille());
							%>
						</div>	
						</div>
					</div>
					
					
					<div class="container col-7">
						<div class="row">
							<strong style ="margin-top: 12px;">Vendeur : </strong>
							<form action="profil" method="post">
								<button style ="margin-top: 5px; margin-left: -5px;" name="profil" class="btn btn-link" value="<%=art.getNoUtilisateur()%>" type="submit">
									<%
										out.print(manager.getUser(art.getNoUtilisateur()).getPseudo());
									%>
								</button>
							</form>
						</div>
					</div>
					
					
					<div class="container col-7">
						<form method="post" action="enchere">
							<div class="row"  style = "margin-top: 10px;">
								<p>
									<strong>Ma proposition :</strong>
								<p>
				
								<input class ="form-control" type="number" style="width: 100px; margin-top: -4px; margin-left: 15px;"
									name="enchere" min=<%if(art.getPrixVente() == 0) out.print(art.getPrixInitial()); else out.print(art.getPrixVente());%>
									value=<%out.print(art.getPrixVente() + 1);%>>
							</div>
							
									<%
										if (null != request.getAttribute("msg")) {
									%>
								
								<p style="color: red">
									<%
										out.print(request.getAttribute("msg"));
									%>
								</p>
									<%
										}
									%>
								<button type="submit" class="btn btn-outline-primary mb-2" style="margin-top: -90px; margin-left: 225px;"
										name="noArticle" value=<%out.print(art.getNoArticle());%>>Enchérir
								</button>	
							</form>	
					</div>		
							
					<%if(null != user && art.getNoUtilisateur() == user.getNo_utilisateur() && art.getEtat().equalsIgnoreCase("PR")) { %>
						<div class="btn-group">
							
								<form method="post" action="modifierArticle">
								<button name="button" class="btn btn-outline-primary mb-2"
										type="submit" value="m<%=art.getNoArticle()%>">Modifier
								</button>
								</form>
								<form method="post" action="modifierArticle">
								<button name="button" class="btn btn-outline-primary mb-2"
										type="submit" value="s<%=art.getNoArticle()%>">Supprimer
								</button>
								</form>
						</div>
					<% } else out.print("<br>"); %>
					
				</div>
				
			</div>
							
		</div>
				<a href="index" class="btn btn-primary btn-block mx-auto" style="width: 10em; margin-top: 10px;">Page principal</a>
	</div>	
</body>
</html>