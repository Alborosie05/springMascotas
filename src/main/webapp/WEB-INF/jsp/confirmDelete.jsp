<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmar eliminado</title>
</head>
<body>
<%
request.getAttribute("codOwner");
%>

<form action="/deleteOwner" method="post">
		<div>¿Está seguro de que desea borrar el propietario?</div>
		<input type="hidden" name="codOwner" path="codOwner" value="${codOwner}"/>
		<input type="submit" name="answer" path="answer" value="SI">
		<input type="submit" name="answer" path="answer" value="NO">
	</form>

</body>
</html>