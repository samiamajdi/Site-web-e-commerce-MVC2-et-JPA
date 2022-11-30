<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des articles</title>
<script src="https://kit.fontawesome.com/801aade464.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/bootstrap.css"> </link>
<style>
.dropbtn {
  background-color: #185310c9;
  color: white;
  padding: 10px;
  font-size: 16px;
  font-family:"Roboto", sans-serif;
  border: none;
  border-radius: 13px;
  cursor: pointer;

}
.dropdown:hover {
  background-color: #9ea9c887;


}

.dropdown {
  position: relative;
  display: inline-block;
  
}

.dropdown-content {
  display: none;
  position: absolute;
  right: 0;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.326);
  z-index: 1;
  font-family:"Roboto", sans-serif;
  border-radius: 7px;
}

.hre{
color: rgba(88, 67, 6, 0.962); 

}
.hre:hover{
color: rgba(88, 67, 6, 0.962); 
}

.dropdown-content a:hover {  color:rgb(0, 0, 0)}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
   background-color: #428c32d2;
}
.dropdown input{
  min-width: 160px;
  padding-top: 5px;
  padding-bottom: 5px;
background-color: #f9f9f9;
border: none;
color: #051A53;
}
.dropdown input:hover {

  color: #ff006a;

}
.log{
  min-width: 160px;
  padding-top: 5px;
  padding-bottom: 5px;
background-color: #f9f9f9;
border: none;
color: #185310c9;
}

.log:hover{
  /* background-color: #4c7d245c */
  color:rgb(0, 0, 0)
}
#id{
margin-left:5200%;
}

</style>
</head>




<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#"><i Style="color:white" class="fa-solid fa-b"></i>shop</a>
 
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#"> <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="PanierServlet?action=consulterPanier"><i id="id" style="color: white"class="fa-solid fa-cart-shopping"></i></a>
      </li>
     
    </ul>
  </div>

  <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">

  <div  style="float:right;" class="dropdown">
          <button class="btn btn-warning  " class="dropbtn">${sessionScope.nom }  ${sessionScope.prenom }  <i class="fa-solid fa-chevrons-down"></i></button>
          <div class="dropdown-content">

        <button class=" btn btn-light" style=" padding-left:25%;padding-right:19%"> <a class="hre"href="ServletInternaute?action=deconnex" >déconnexion</a></button> 
         

          </div>
        </div>
</c:if>
</nav>


<h1 style="margin-left:10%;margin-top:5%; font-family:  Verdana, sans-serif;">Liste des articles </h1>

 
<table style ="width:60% ; margin-left:20%; margin-top:5%" class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nom Article</th>
       <th scope="col">Prix</th>
      <th scope="col">Image Article</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  
 <c:forEach items="${listeA}" var="p">
    <tr>
      <th scope="row">${p.id_article}</th>
      <td>${p.nom_article}</td>
       <td>${p.prix_article}</td>
       
       <td><img src="resources/${p.imageFileName }" width="200px"/></td>
       <td><form method="post" action="PanierServlet?action=commander">
       <input type="hidden" name="id_article" value="${p.id_article}">
       <input type="hidden" name="id_categorie" value="${p.categorie.id_ctg}"><input name="qte" class="form-control rounded-pill" style="width:40%" type="text"/><input type="submit"  style=" margin-top:-20%; margin-left:50%"class="btn btn-warning"value="commander"></form></td>
      
    </tr>
   
 </c:forEach>
  </tbody>
</table>
</body>
</html>