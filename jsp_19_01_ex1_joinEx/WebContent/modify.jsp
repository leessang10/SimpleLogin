<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%!
	    Connection connection;
	    Statement stmt;
	    ResultSet resultSet;
	    String name, id, pw, phone1, phone2, phone3, gender;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		id = (String)session.getAttribute("id");
		String query = "SELECT * FROM member WHERE ID = '" + id + "'";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "woojoo", "woojoo");
		stmt = connection.createStatement();
		resultSet = stmt.executeQuery(query);
		
		while(resultSet.next()) {
			name = resultSet.getString("name");
			id = resultSet.getString("id");
			pw = resultSet.getString("pw");
			phone1 = resultSet.getString("phone1");
			phone2 = resultSet.getString("phone2");
			phone3 = resultSet.getString("phone3");
			gender = resultSet.getString("gender");
		}
	%>
	
	<form action="ModifyOk" method="post">
		Name: <input type="text" name="name" size="10"><br/>
		ID: <%=id %><br/>
		PW: <input type="password" name="pw" size="10"><br/>
		PhoneNum: 	<select name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
					</select> -
					<input type="text" name="phone2" size="5"> - 
					<input type="text" name="phone3" size="5"><br/>
					
		<%
			if(gender.equals("man")){
		%>
					
		Sex: 	<input type="radio" name="gender" value="man" checked="checked">남자
				<input type="radio" name="gender" value="woman">여자<br/>
		
		<%
			} else {
		%>
		
		Sex: 	<input type="radio" name="gender" value="man">남자
				<input type="radio" name="gender" value="woman" checked="checked">여자<br/>
		
		<%
			}
		%>
		
		<input type="submit" value="Modify"> <input type="reset" value="Reset">
	</form>
	
	
</body>
</html>