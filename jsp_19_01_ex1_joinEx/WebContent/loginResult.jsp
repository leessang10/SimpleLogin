<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%!
   	String name, id, pw;
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		name = (String)session.getAttribute("name");
		id = (String)session.getAttribute("id");
		pw = (String)session.getAttribute("pw");
	%>
	Hello, <%= name %>님.<br/><br/>
	
	<a href="modify.jsp">Modify Account</a><br/>
	<a href="mainPage.html">To the Main Page</a><br/>
</body>
</html>