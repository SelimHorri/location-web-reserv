<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>Create Location</title>
	<%@ include file="includes/stylish.jsp"%>
</head>

<body>
	
	<%@ include file="includes/navbar.jsp"%>
	
	
	<form action='updateLoc' method='POST'>

		<div class='container container-fluid' >
			
			<br><br><br><br>
			<fieldset>
				<legend>Personal Infos</legend><br>
				
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">ID</label>
					<input name='id' type="text" class="form-control" placeholder="Default input" id="inputDefault" readonly='true' value='${location.id}'>
				</div><br><br>		
				
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">Code</label>
					<input name='code' type="text" class="form-control" placeholder="Default input" id="inputDefault" value='${location.code}'>
				</div><br><br>		
				
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">Name</label>
					<input name='name' type="text" class="form-control" placeholder="Default input" id="inputDefault" value='${location.name}'>
				</div><br><br>
				
				<legend> Type </legend>
				
				<div class="form-check">
					<label class="form-check-label">
					<input name='type' type="radio" class="form-check-input" id="optionsRadios1" value="low" ${location.type == 'low' ? 'checked' : ''}> LOW
					</label>
				</div> <br><br>
				
				<div class="form-check">
					<label class="form-check-label">
					<input name='type' type="radio" class="form-check-input" id="optionsRadios1" value="high" ${location.type == 'high' ? 'checked' : ''}> HIGH
					</label>
				</div> <br><br>
								
				<input value='Save & Update' type="submit" class="btn btn-primary" />
			</fieldset>
			
		</div>
		
	</form>
	
	<br><br><br><br><br><br>
	<%@ include file="includes/footer.jsp"%>
	
</body>
</html>
