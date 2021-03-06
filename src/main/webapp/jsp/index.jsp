<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "/WEB-INF/tld/custom.tld" prefix = "w" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body onload="load()">




	
	<form action="/" method="POST">
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="firstName">First Name</label> 
				<input class="form-control" type="text" id="firstName" name="firstName" placeholder="<c:out value="${missedForms['firstName']}"/>"> 
			</div>
			<div class="form-group col-md-4">
				<label for="lastName">Last Name</label> 
				<input class="form-control" type="text" id="lastName" name="lastName" placeholder="<c:out value="${missedForms['lastName']}"/>"> 
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-8">
				<label for="phoneNumber">Phone Number</label> 
				<input class="form-control" type="text" id="phoneNumber" name="phoneNumber" placeholder="<c:out value="${missedForms['phoneNumber']}"/>"> 
			</div>
		</div>
		<div class="form-row">
		
			<div class="form-group col-md-3">
				<label for="addressType">Address Type</label> 
				<select class="form-control" id="addressType" name="addressType" onChange="changeDisplay()">
					<option disabled selected value style="display:none;"><c:out value="${missedForms['address']}"/></option> 
					<option value="home">Home</option>
					<option value="business">Business</option>
				</select> 
			</div>
		</div>
		<div id = "homeAddress" style = "visibility:hidden;">
			<div class="form-row">
				<div class="form-group col-md-8">
					<label for="homeAddressLine1">Address Line 1</label> 
					<input class="form-control" type="text" id="homeAddressLine1" name="homeAddressLine1" placeholder="Address Line 1..."> 
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-8">
					<label for="homeAddressLine2">Address Line 2</label> 
					<input class="form-control" type="text" id="homeAddressLine2" name="homeAddressLine2" placeholder="Address Line 2..."> 
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="homCcity">City</label> 
					<input class="form-control" type="text" id="homeCity" name="homeCity" placeholder="City..."> 
				</div>
				<div class="form-group col-md-4">
					<label for="homeState">State</label> 
					<input class="form-control" type="text" id="homeState" name="homeState" placeholder="State..."> 
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="homeCountry">Country</label> 
					<input class="form-control" type="text" id="homeCountry" name="homeCountry" placeholder="Country..."> 
				</div>
				<div class="form-group col-md-4">
					<label for="homeZipCode">Zip Code</label> 
					<input class="form-control" type="text" id="homeZipCode" name="homeZipCode" placeholder="Zip Code..."> 
				</div>
			</div>
		</div>
		<div id="businessAddress" style = "display:none;">
			<div class="form-row">
				<div class="form-group col-md-8">
					<label for="businessAddressLine1">Address Line 1</label> 
					<input class="form-control" type="text" id="businessAddressLine1" name="businessAddressLine1" placeholder="Address Line 1..."> 
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-8">
					<label for="businessAddressLine2">Address Line 2</label> 
					<input class="form-control" type="text" id="businessAddressLine2" name="businessAddressLine2" placeholder="Address Line 2..."> 
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="businessCity">City</label> 
					<input class="form-control" type="text" id="businessCity" name="businessCity" placeholder="City..."> 
				</div>
				<div class="form-group col-md-4">
					<label for="businessState">State</label> 
					<input class="form-control" type="text" id="businessState" name="businessState" placeholder="State..."> 
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="businessCountry">Country</label> 
					<input class="form-control" type="text" id="businessCountry" name="businessCountry" placeholder="Country..."> 
				</div>
				<div class="form-group col-md-4">
					<label for="businessZipCode">Zip Code</label> 
					<input class="form-control" type="text" id="businessZipCode" name="businessZipCode" placeholder="Zip Code..."> 
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-4 justify-content-center">
				<input class="form-control" type="submit" value="Submit"> 
			</div>
		</div>
	</form>
	
	<table class="table table-striped">
		
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

<script>
	function changeDisplay(){
		var chosenAddress = document.getElementById("addressType").value;
		var homeAddress = document.getElementById("homeAddress");
		
		homeAddress.style.visibility = "visible";
		var businessAddress = document.getElementById("businessAddress");
		
		if(chosenAddress == "home"){
			homeAddress.style.display = "block";
			businessAddress.style.display = "none";

		}else{
			homeAddress.style.display = "none";
			businessAddress.style.display = "block";
		}
	}
	
	function load(){
		
		
	}
</script>
</html>