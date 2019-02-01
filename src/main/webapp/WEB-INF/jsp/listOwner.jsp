<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Owners and their Pets</title>
</head>
<body>
<form action="listAllOwners" method="post">
	<input type="submit" value="ver listado">
</form>

<br>
<a href="addOwner">Quiero añadir un nuevo alumno</a>



<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<table border="1">
	<thead>
		<tr>
			<td>Cod Owner</td>
			<td>Name</td>
			<td>Surname</td>
			<td>Editar</td>
			<td>Borrar</td>
			<td>Añadir Macota</td>
			<td>Mascotas</td>
			<td>Añadir Casa</td>
			<td>ver lista Casas</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="owner1" items="${listAllOwners}" >
			<tr>
				<td><c:out value="${owner1.codOwner}"/> </td>
				<td><c:out value="${owner1.name}"/> </td>
				<td><c:out value="${owner1.surname}"/> </td>
				<td><a href="/editOwner?codOwner=${owner1.codOwner}">EDIT</a> </td>
				<td><a href="/confirmarEliminadoOwner?codOwner=${owner1.codOwner}">DELETE</a> </td>
				<td><a href="/recoveryAddCodOwner?codOwner=${owner1.codOwner}">ADD PET</a> </td>
	    		<td><c:forEach var="pet" items="${owner1.mascotas}">
	    				<c:out value="${pet.name}"/>
	    			</c:forEach>
	    		</td>
	    		<td><a href="/recoveryAddCodOwnerHouse?codOwner=${owner1.codOwner}">ADD HOUSE</a> </td>
	    		<td><a href="/viewHouses?codOwner=${owner1.codOwner}">VIEW HOUSES</a> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>