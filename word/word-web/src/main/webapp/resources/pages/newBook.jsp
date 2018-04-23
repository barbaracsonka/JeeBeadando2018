<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file = "header.jsp" %>

		<div class='container'>
			<form action="/newbook" method="post">
			  <div class="form-group">
			    <label for="name">Name:</label>
			    <input type="text" class="form-control" id="name">
			  </div>
			  <div class="form-group">
			    <label for="isbn">ISBN:</label>
			    <input type="text" class="form-control" id="isbn">
			  </div>
			  <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</body>
</html>