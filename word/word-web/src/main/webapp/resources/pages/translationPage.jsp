<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file = "header.jsp" %>

	<script>
		$(document).ready(function() {
		    $('#translationTable').DataTable();
		});
	</script>
		<div class='container' style='padding:1rem;'>
			<h3>Translations:</h3>
			
			<table id="translationTable" class='display' style="width:100%;margin-bottom:1rem;">
				<thead>
					<tr>
						<th>Id</th>
						<th>From</th>
						<th>To</th>
						<th>Functions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${translations}" var="element"> 
					  <tr>
					    <td>${element.id}</td>
					    <td>${element.original}</td>
					    <td>${element.translation}</td>
						<td>
							<a href='deletetranslation?id=${element.id}&dictionaryid=${dictionaryId}'><button name='id' value='${element.id}' type='button' class='btn btn-danger'>Delete</button></a>
						</td>
					  </tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row" style="margin-top:1rem">
			     <div class="col text-right"><a href="newtranslation?dictionaryid=${dictionaryId}" class='btn btn-primary'>New word</a></div>
			</div>
			
		</div>
	</body>
</html>