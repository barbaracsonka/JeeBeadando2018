<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file = "header.jsp" %>

		<div class='container'>
			<form action="edittranslation" method="post">
			  <input type="hidden" class="form-control" name="dictionaryid" id="dictionaryid" value="${dictionaryid}">
			  <input type="hidden" class="form-control" name="id" id="id" value="${id}">
			  <div class="form-group">
			    <label for="name">Original:</label>
			    <input type="text" class="form-control" name="from" id="from" value="${translation.original}">
			  </div>
			  <div class="form-group">
			    <label for="type">Translated:</label>
			    <input type="text" class="form-control" name="to" id="to" value="${translation.translation}">
			  </div>
			  <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</body>
</html>