<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>DBH Containers</title>

  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
  <style>
  .header {
  padding: 60px;
  text-align: center;
  background: url(template/images/banner.jpg);
  color: white;
  font-size: 30px;
}

  </style>
  <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">


  <!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="templateTable/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="templateTable/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="templateTable/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="templateTable/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="templateTable/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="templateTable/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="templateTable/css/util.css">
	<link rel="stylesheet" type="text/css" href="templateTable/css/main.css">
<!--===============================================================================================-->
</head>

<body>

<div class="header">
  <h1>G?rer Les Clients</h1>
 <div  align = center>
    <br>
  <button type="button" class="btn btn-primary" onclick="window.location.href = 'HomeAdmin.jsp';" align = left><font color="white" size = 6>Accueil</font></button></div>
</div>
  	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
					<div class="table">
					
  		<table class="table table-bordered">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Nom</th>
		      <th scope="col">Prenom</th>
		      <th scope="col">Email</th>
		      <th scope="col">Adresse</th>
		      <th scope="col">Telephone</th>
		      <th scope="col">Fax</th>
		      <th scope="col">Password</th>
		    </tr>
		  </thead>
		  <tbody> 
		  <c:forEach items="${model.clients}" var="c">
		    <tr>
		      <th scope="col">${c.id}</th>
		      <th scope="col">${c.nom}</th>
		      <th scope="col">${c.prenom}</th>
		      <th scope="col">${c.email}</th>
		      <th scope="col">${c.adresse}</th>
		      <th scope="col">${c.tel}</th>
		      <th scope="col">${c.fax}</th>		  
		      <th scope="col">${c.password}</th>    
		      <th><a  href="supprimer.php?id=${c.id}" class="btn btn-default" onclick="return confirm('?tes-vous s?r de bien vouloir supprimer cet ?l?ment?');">Suprimer</a></th>
		      <th><a href="Editer1.php?id=${c.id}&nom=${c.nom}&prenom=${c.prenom}&adresse=${c.adresse}&email=${c.email}&tel=${c.tel}&fax=${c.fax}&password=${c.password}" class="btn btn-default" >Edit</a></th>
		    </tr>
		   </c:forEach> 
		  </tbody>
		</table>
		</div>
		</div>
		</div>
		</div>
		
  
  <!--===============================================================================================-->	
	<script src="templateTable/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="templateTable/vendor/bootstrap/js/popper.js"></script>
	<script src="templateTable/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="templateTable/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="templateTable/js/main.js"></script>

</body>

</html>
