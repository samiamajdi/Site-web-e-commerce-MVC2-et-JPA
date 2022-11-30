<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des categories</title>
</head>
<body>
<c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">
<p>  ${sessionScope.iduser }  ${sessionScope.nom }</p>

</c:if>
<table border="1" width="80%">
<h1>Liste des categories </h1>
 <tr><th>ID</th><th>Name</th>
 </tr>
 
 <c:forEach items="${listeC}" var="p">
  <tr><th><a href="InscriptionServlet?action=consulterC&idc=${p.id_ctg}">${p.id_ctg}</a></th><th>${p.nom_ctg}</th>
 </tr>
 </c:forEach>
</body>
</html>