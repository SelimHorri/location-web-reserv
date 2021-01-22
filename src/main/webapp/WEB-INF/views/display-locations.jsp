<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>List of Locations</title>
	
	<%@ include file="includes/stylish.jsp" %>
	
</head>

<body>
	
	<%@ include file="includes/navbar.jsp" %>
	
	<br><br>
	
	<div class='container container-fluid'>
		
		<h2>List of Locations from Database</h2> <br>
		
		<br><br>
		
		<table class='table table-hover text-center'>
			
			<thead>
				<tr class=''>
					
					<th scope='col'>ID</th>
					<th scope='col'>Code</th>
					<th scope='col'>Name</th>
					<th scope='col'>Type</th>
					<th scope="col"></th>
				    <th scope="col"></th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${locations}" var="l" >
					
					<tr class=''>
						<td> ${l.id} </td>
						<td> ${l.code} </td>
						<td> ${l.name} </td>
						<td> ${l.type} </td>
						<td> <a href='showUpdate?id=${l.id}' class='btn btn-outline-info'>Edit</a> </td>
						<td> <a href='deleteLocation?id=${l.id}' class='btn btn-outline-danger' onclick=" if (!(confirm('Are you sure you wanna delete this location record ?'))) return false" >Delete</a> </td>
					</tr>
					
				</c:forEach>
			</tbody>
			
		</table>
		
		<br><br>
		
		<center><h3><a href='showCreate' class='btn btn-outline-success'>Add location ?</a></h3></center>
		
	</div>
	
	<br><br><br><br>
	
	<%@ include file="includes/footer.jsp" %>
	
</body>
</html>
