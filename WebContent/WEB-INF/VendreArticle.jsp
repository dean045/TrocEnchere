<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container">
    
      <h2>Nouvelle vente</h2> 

      
<div class="container">
    <div class="row">
      
       <! -- Bloc image justifier à gauche -->
 
      <div class="container col-5 " style="width: 500 px;">
           <div class="row justify-content-left">
              
                    <img src="https://remove-white-background.imageonline.co/fr/pictureinput.jpg">
               
          </div>
    </div> 
            
      
     <! -- Bloc Nouvelle vente justifier à droite -->
      
      <div class="container col-7 "  style="width: 500 px;">
          <div class="row justify-content-center">
              
                    
                    <div class="form-group">
                        <label for="exampleInputSurArticle">Article</label>
                        <input type="Article" class="form-control" id="exampleInputArticle1" placeholder="Article">
                      </div>
                    <label for="site-search">Catégories :</label>
                   <select>
                    <optgroup label="Catégories">
                        <option>Toutes</option>
                        <option>Informatique</option>
                        <option>Ameublement</option>
                        <option>Vêtements</option>
                        <option>Sports et Loisirs</option>
                    </optgroup>
                    </select>
                      <label for="avatar">Photo de l'article :</label>
                      <input type="file"
                       id="avatar" name="avatar"
                       accept="image/png, image/jpeg">

                      <form>
                      <div>
                        <label for="bday">Début de l'enchère :</label>
                        <input type="date" id="bday" name="bday">
                      </div>
                    </form>

                         <form>
                      <div>
                        <label for="bday">Fin de l'enchère :</label>
                        <input type="date" id="bday" name="bday">
                      </div>
                    </form>

                      <br>
                    <h4>Retrait</h4>
                     <div class=" border">
                      <div class="form-group">
                         
                    <label for="exampleInputStreet">Rue</label>
                    <input type="Street" class="form-control" id="exampleInputStreet1" placeholder="Rue">
                    </div>
                    <div class="form-group">
                    <label for="exampleInputCodePostal">CodePostal</label>
                    <input type="City" class="form-control" id="exampleInputCodePostal1" placeholder="CodePostal">
                  </div>

                    <div class="form-group">
                    <label for="exampleInputCity">Ville</label>
                    <input type="City" class="form-control" id="exampleInputCity1" placeholder="Ville">
                  </div> 
                    </div>
                    <br>
                    <div class="container">
                      <button type="submit" class="btn btn-primary">Confirmer</button>     
                     <button type="submit" class="btn btn-primary">Annuler</button>
                    </div>
              </div>
          </div>  
    </div>
        
</div>
  

      
</body>