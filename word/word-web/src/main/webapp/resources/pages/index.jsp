<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="resources/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/datatables/DataTables-1.10.16/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="resources/js/index.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/datatables/DataTables-1.10.16/css/jquery.dataTables.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css"/>
	<title>Word</title>
	
	<script>
	$(document).ready(function() {
	    $('#bookTable').DataTable();
	});
	</script>
</head>
<body>
	<div class='container' style='margin-bottom:2rem;'>
		<nav class="navbar navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Word</a>
		</nav>
	</div>
	
	<div class='container' style='margin-top:1rem;'>
		<h3>Books:</h3>
		
		<table id="bookTable" class='display' style="width:100%;margin-bottom:1rem;">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>ISBN</th>
					<th>Functions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>0</td>
					<td>Example</td>
					<td>123456789123</td>
					<td><button type='button' class=' btn btn-success'>Open</button> <button type='button' class='btn btn-danger'>Delete</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td>Example1</td>
					<td>43523456234</td>
					<td><button type='button' class=' btn btn-success'>Open</button> <button type='button' class='btn btn-danger'>Delete</button></td>
				</tr>
				<tr>
					<td>2</td>
					<td>Example2</td>
					<td>234523452345</td>
					<td><button type='button' class=' btn btn-success'>Open</button> <button type='button' class='btn btn-danger'>Delete</button></td>
				</tr>
			</tbody>
		</table>
		<div class="row" style="margin-top:1rem">
		     <div class="col text-right"><button type='button' class='btn btn-primary'>New book</button></div>
		</div>
	</div>
</body>
</html>