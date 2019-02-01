<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Propietario editado</title>
</head>
<body>
<%
 request.getAttribute("owner");

List<Pet> pets = (List<Pet>)request.getAttribute("listAllPets");
//pageContext.setAttribute("pets", pets);

%>
	<form:form action="/updateOwner" method="post" modelAttribute="owner">
		<form:input type="text" name="codOwner" path="codOwner"  style="display:none"/> <br/>
		<span>nombre:</span> 
		<form:input type="text" name="name" path="name" /> <br/>
		<span>apellido:</span> 
		<form:input type="text" name="surname" path="surname"/> <br/>
		<br>
		<input type="submit">
	</form:form>
	
	<form action="/cargarListadoMascotas" method="post">
		<input type="hidden" id="codOwner" name="codOwner" value="<c:out value="${owner.codOwner}" />" > <br/>
		<input type="submit" value="ver listado mascotas">
	</form>
	<br>
	<br>
	
	<table border="1">
		<thead>
		<tr>
			<td>Mascota</td>
			<td>Eliminar</td>
			<td>Modificar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="pet" items="${listAllPets}">
			<tr>
				<td><c:out value="${pet.name}"/></td>
				<td><a href="/deletePet?codOwner=${pet.codOwner}&nombre=${pet.name}">DELETE</a> </td>
				<td><a href="/editPet?codOwner=${pet.codOwner}&nombre=${pet.name}">EDIT</a> </td>
	    	</tr>
		</c:forEach>
			
	</tbody>
	</table>
</body>
</html>