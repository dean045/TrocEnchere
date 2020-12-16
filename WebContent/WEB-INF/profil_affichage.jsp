<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
     <link rel="stylesheet" href="style.css">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Page profil</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
  <body class="container">
        <header class="col-12 d-flex  ">
           <div> 
               <h1>ENI-Enchère </h1>
        </div>
        </header>
            <h2>Mon profil</h2>
           <form>
            <div class="container d-flex">
               <div class="container  col-sm-6 d-flex p-2 bd-highlight mx-auto">
                    <div class="row" >
                  
                         <div class="form-group">
                        <label for="exampleInputSurPseudo">Pseudo</label>
                        <input type="Pseudo" class="form-control" id="exampleInputPseudo1" placeholder="Pseudo">
                      </div>

                        <div class="form-group">
                        <label for="exampleInputSurName">Prénom</label>
                        <input type="Prenom" class="form-control" id="exampleInputSurnameName1" placeholder="Prenom">
                      </div>

                       <div class="form-group">
                        <label for="exampleInputSurPhoneNumber">Numéro de téléphone</label>
                        <input type="PhoneNumber" class="form-control" id="exampleInputPhoneNumber1" placeholder="Numéro de téléphone">
                      </div>

                       <div class="form-group">
                        <label for="exampleInputSurPostalCode">Code Postal</label>
                        <input type="PostalCoder" class="form-control" id="exampleInputPostalCode1" placeholder="Code Postal">
                      </div>

                       <div class="form-group">
                        <label for="exampleInputPassword1">Mot de passe</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Mot de passe">
                      </div>
                </div>     
            </div>
               
               <div class="container  col-sm-6 d-flex p-2 bd-highlight mx-auto">
                    <div class="row">
                        <div class="form-group" >
                        <label for="exampleInputName">Nom</label>
                        <input type="nom" class="form-control" id="exampleInputName1" placeholder="Nom">
                      </div>   

                        <div class="form-group">
                        <label for="exampleInputEmail1">Adresse mail</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Renseignez votre Email">
                        <small id="emailHelp" class="form-text text-muted">Votre email est protégé</small>
                      </div>

                        <div class="form-group">
                        <label for="exampleInputStreet">Rue</label>
                        <input type="Street" class="form-control" id="exampleInputStreet1" placeholder="Rue">
                      </div>

                        <div class="form-group">
                        <label for="exampleInputCity">Ville</label>
                        <input type="City" class="form-control" id="exampleInputCity1" placeholder="Ville">
                      </div> 

                        <div class="form-group">
                        <label for="exampleInputConfirmPassword1">Confirmation</label>
                        <input type="ConfirmPassword" class="form-control" id="exampleInputConfirmPassword1" placeholder="Confirmation">
                      </div>
                    </div>    
            </div>   
          <br>
          </div>
                <div class="container">
                  <button type="submit" class="btn btn-primary">Confirmer</button>     
                 <button type="submit" class="btn btn-primary">Annuler</button>
         </div>
        
        </form>