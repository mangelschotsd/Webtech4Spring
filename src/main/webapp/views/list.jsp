<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<%-- <%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%> --%>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>

<link rel='stylesheet' href='/resources/css/bootstrap.min.css'>

<title>Exam List for student</title>
</head>

<body>

<div class='well'>
<h1>Exam List</h1>
<br/><br/>
<table  class='table'>
	<tr>
		<th>Exam</th>
		<th>Reason</th>
		<th>Date</th>
	</tr>
	<c:if test='${not empty inhaalExamens}'>
		<c:forEach var='inhaalExamen' items='${inhaalExamens}'>
			<tr><td>${inhaalExamen.exam}</td><td>${inhaalExamen.reason}</td><td>${inhaalExamen.date}</td></tr>
		</c:forEach>
	</c:if>
</table>


</div>

</body>
</html>

