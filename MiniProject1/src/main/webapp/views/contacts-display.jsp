<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function confirmDelete()
{
return confirm("Are you sure to delete?");

}
</head>
<body>
	<h3>view contacts</h3>
	
	<a href="load-form">+Add New Contact</a>
	<table border=1>
	<thead>
	<tr>
	<th>Contact Id </th>
	<th>Contact Name </th>
	<th>Contact Number </th>
	<th>Contact Email </th>
	<th>Action</th>
	</tr>
	
	</thead>
	<tbody>
	<c:foreach items="${contacts}" var="contact">
	<tr>
<td>  ${contact.contactId} </td>
<td>  ${contact.contactName} </td>
<td>  ${contact.contactNubmer} </td>
<td>  ${contact.contactEmail} </td>
<td> <a href="/edit?cid=${contact.contactId}">Edit</a> <a href="delete?cid=${contact.contactId}" onclick="return confirmDelete()">Delete</a></td>
	</tr>
	</c:foreach>

	</tbody>
	
	
	</table>
	
</body>
</html>