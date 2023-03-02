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
  <h1>Gérer Les Demandes</h1>
  <br>
    <div  align = center>
    
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
		      <th scope="col">ID Client</th>
		      <th scope="col">ID Contenaire</th>
		      <th scope="col">Date Demande</th>
		      <th scope="col">Date Début</th>
		      <th scope="col">Date Fin</th>
		      <th scope="col">Quantité</th>
		      <th scope="col">Adresse Livraison</th>
		      <th scope="col">Code Postal</th>
		      <th scope="col">Ville</th>
		    </tr>
		  </thead>
		  <tbody> 
		  <c:forEach items="${model.demandes}" var="c">
		    <tr>
		      <th scope="col">${c.id_demande}</th>
		      <th scope="col">${c.id_client}</th>
		      <th scope="col">${c.id_conteneur}</th>
		      <th scope="col">${c.date_demande_loc}</th>
		      <th scope="col">${c.date_debut_loc}</th>
		      <th scope="col">${c.date_fin_loc}</th>
		      <th scope="col">${c.quantite}</th>
		      <th scope="col">${c.adresse_livraison}</th>
		      <th scope="col">${c.code_postal}</th>
		      <th scope="col">${c.ville}</th>   	
		      <th><a  href="suprimer_dem_location.php?id=${c.id_demande}"  class="btn btn-default" onclick="return confirm('Êtes-vous sûr de bien vouloir supprimer cet élément?');">Supprimer</a></th>
		      <th><a href="edit_dem_Location.php?id=${c.id_demande}" class="btn btn-default" >Modifier</a></th>
		    </tr>
		   </c:forEach>
		    
		  </tbody>
		</table>