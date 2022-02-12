<%@page import="com.assignment2.Scores"%>
<%@page import="com.assignment2.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.assignment2.StudentDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<%
		StudentDetails studentDetails = (StudentDetails) session.getAttribute("studentDetails");
		String firstName = studentDetails.getFirstName();
		String lastName = studentDetails.getLastName();
		String email = studentDetails.getEmail();
		String phoneNumber = studentDetails.getPhoneNumber();
		List<Address> addressList = (List<Address>) studentDetails.getAddressList();
		List<Scores> scoresList = (List<Scores>) studentDetails.getScoresList();
	
		Long areaOfSquare = (Long) session.getAttribute("areaOfSquare");
		double areaOfRectangle = (Double) session.getAttribute("areaOfRectangle");
	%>
	<div data-role="content" style="text-align: center;">
		<h2><%= firstName %> <%= lastName %></h2>
		<h3>Email: <%= email %></h3>
		<h3>Phone Number: <%= phoneNumber %></h3>
	</div>
	<div>
		<h1>Addresses</h1>
		<ol>
			<% for (Address address : addressList) { %>
				
				<li>
					<b>Street: </b><%= address.getStreet() %>&nbsp;&nbsp;&nbsp;&nbsp;
					<b>City: </b><%= address.getCity() %>&nbsp;&nbsp;&nbsp;&nbsp;
					<b>State: </b><%= address.getState() %>
				</li>
				<br>
				
			<% } %>
		</ol>
		
		<h1>Scores</h1>
		<table>
			<tr>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Score</th>
			</tr>
			<%
				for (Scores scores : scoresList) {
			%>
				<tr>
					<td><%= scores.getCourseId() %></td>
					<td><%= scores.getCourseName() %></td>
					<td><%= scores.getScore() %></td>
				</tr>
			<% } %>
		</table>
	</div>
	<br>
	<div>
		<h1>Areas</h1>
		<b>Area of Rectangle:</b> <%= areaOfRectangle %> 
		<br>
		<br>
		<b>Area of Square:</b> <%= areaOfSquare %>
	</div>
</body>
</html>