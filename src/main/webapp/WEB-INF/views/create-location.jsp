<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>Create Location</title>
	<%@ include file="includes/stylish.jsp"%>
</head>

<body>
	
	<%@ include file="includes/navbar.jsp"%>
	
	
	<form class='login-form' action='saveLoc' method='POST'>

		<div class='container container-fluid' >
			
			<br><br><br><br>
			<fieldset>
				<legend>Personal Infos</legend><br>
				
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">ID</label>
					<input name='id' type="text" class="form-control" placeholder="Default input" id="inputDefault">
				</div><br><br>		
				
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">Code</label>
					<input name='code' type="text" class="form-control" placeholder="Default input" id="inputDefault">
				</div><br><br>		
				
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">Name</label>
					<input name='name' type="text" class="form-control" placeholder="Default input" id="inputDefault">
				</div><br><br>
				
				<legend> Type </legend>
				
				<div class="form-check">
					<label class="form-check-label">
					<input name='type' type="radio" class="form-check-input" id="optionsRadios1" value="low" checked=""> LOW
					</label>
				</div> <br><br>
				
				<div class="form-check">
					<label class="form-check-label">
					<input name='type' type="radio" class="form-check-input" id="optionsRadios1" value="high" checked=""> HIGH
					</label>
				</div> <br><br>
				
				<div class='alert alert-dismissible'>
					<span class="badge badge-secondary"> <strong><i class='text-success'> ${msg} </i><br><br></strong> </span>
				</div>
				
				<input value='Save' type="submit" class="btn btn-primary" /> <br><br>
				<a href='displayLocations' class='btn' > View All ? </a>
			</fieldset>
			
		</div>
		
	</form>
	
	<br><br><br><br><br><br>
	<%@ include file="includes/footer.jsp"%>
	
</body>
</html>
