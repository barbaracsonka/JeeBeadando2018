<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file = "header.jsp" %>
	
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
			     <div class="col text-right"><a href="newbook" class='btn btn-primary'>New book</a></div>
			</div>
		</div>
	</body>
</html>