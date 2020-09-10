<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "/WEB-INF/tld/custom.tld" prefix = "w" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>

<style>
th, td {
  border: 1px solid black;
  padding: 5px;
}
</style>

	
	<form action="/" method="POST">
		<label for="firstName">First Name</label> <br>
		<input type="text" id="firstName" name="firstName" placeholder="First Name..."> <br>
		
		<label for="lastName">Last Name</label> <br>
		<input type="text" id="lastName" name="lastName" placeholder="Last Name..."> <br>
		
		<label for="phoneNumber">Phone Number</label> <br>
		<input type="text" id="phoneNumber" name="phoneNumber" placeholder="Phone Number..."> <br>
	
		<label for="addressType">Address Type</label> <br>
		<select id="addressType" name="addressType"> 
			<option value="home">Home</option>
			<option value="work">Work</option>
		</select> <br>
		
		<label for="addressLine1">Address Line 1</label> <br>
		<input type="text" id="addressLine1" name="addressLine1" placeholder="Address Line 1..."> <br>
		<label for="addressLine2">Address Line 2</label> <br>
		<input type="text" id="addressLine2" name="addressLine2" placeholder="Address Line 2..."> <br>
		<label for="city">City</label> <br>
		<input type="text" id="city" name="city" placeholder="City..."> <br>
		<label for="state">State</label> <br>
		<input type="text" id="state" name="state" placeholder="State..."> <br>
		<label for="country">Country</label> <br>
		<input type="text" id="country" name="country" placeholder="Country..."> <br>
		<label for="zipCode">Zip Code</label> <br>
		<input type="text" id="zipCode" name="zipCode" placeholder="Zip Code..."> <br>
		 <br>
		<input type="submit" value="Submit"> <br>
	</form>
	
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Phone Number</th>
			<th>Home Address</th>
			<th>Home City</th>
			<th>Home State</th>
			<th>Home Country</th>
			<th>Home Zip Code</th>
			<th>Business Address</th>
			<th>Business City</th>
			<th>Business State</th>
			<th>Business Country</th>
			<th>Business Zip Code</th>
		</tr>
		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>
					<c:out value="${contact.firstName}"/>
				</td>
				<td>
					<c:out value="${contact.lastName}"/>
				</td>
				<td>
					<c:out value="${contact.phoneNumber}"/>
				</td>
				<td>
					<c:out value="${contact.getHomeAddress().getAddressLine1()} ${contact.getHomeAddress().getAddressLine2()}"/>
				</td>
				<td>
					<c:out value="${contact.getHomeAddress().getCity()}"/>
				</td>
				<td>
					<c:out value="${contact.getHomeAddress().getState()}"/>
				</td>
				<td>
					<c:out value="${contact.getHomeAddress().getCountry()}"/>
				</td>
				<td>
					<c:out value="${contact.getHomeAddress().getZipCode()}"/>
				</td>
				<td>
					<c:out value="${contact.getBusinessAddress().getAddressLine1()} ${contact.getBusinessAddress().getAddressLine2()}"/>
				</td>
				<td>
					<c:out value="${contact.getBusinessAddress().getCity()}"/>
				</td>
				<td>
					<c:out value="${contact.getBusinessAddress().getState()}"/>
				</td>
				<td>
					<c:out value="${contact.getBusinessAddress().getCountry()}"/>
				</td>
				<td>
					<c:out value="${contact.getBusinessAddress().getZipCode()}"/>
				</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>