<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BlissWebApp</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link href="/blissWebApp/static/css/fontello-embedded.css" rel="stylesheet" >
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link href="/blissWebApp/static/css/animation.css" rel="stylesheet" >
	<link href="/blissWebApp/static/css/style.css" rel="stylesheet" >
	<link href="/blissWebApp/static/css/draganddrop.css" rel="stylesheet" >
</head>
<body>
<div class="container">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index">BlissWebApp</a>
			</div>
			<ul class="nav navbar-nav">
				<c:if test="${sessionScope.USER != null}">
					<li><a href="ajoutsalle">Ajout Salle</a></li>
					<li><a href="managementmachine">Gestion machine</a></li>
					<li><a href="logs">Historique</a></li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.USER == null}">
					<li><a href="connexion"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
				</c:if>
				<c:if test="${sessionScope.USER != null}">
					<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
				</c:if>
			</ul>
		</div>
	</nav>