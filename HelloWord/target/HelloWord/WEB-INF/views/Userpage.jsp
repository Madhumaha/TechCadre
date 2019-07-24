<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="Navbar.jsp" /> 
<form:form  method="post" action="adduser" style="border:1px solid #ccc">



  <div class="container">
    <h1>User Details</h1>
    
    


<div class="form-group row">
    <form:label path="firstname"><b>First name</b></form:label>
    <form:input path="firstname" type="text" class="form-control" placeholder=" " name="First name" required="true"/><br>
     <form:errors path="firstname"></form:errors>
</div>

<div class="form-group row">
    <form:label path="lastname"><b>last name</b></form:label>
    <form:input path="lastname" type="text" class="form-control" placeholder="" name="last name" required="true"/><br>
     <form:errors path="lastname"></form:errors>
</div>

<div class="form-group row">
    <form:label path="contactnumber"><b>Contact number</b></form:label>
    <form:input path="contactnumber" type="number" class="form-control" placeholder="" name="Contact number" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="email_id"><b>User emailId</b></form:label>
    <form:input path="email_id" type="text" class="form-control" placeholder="" name="User emailId" required="true"/><br>
     <form:errors path="email_id"></form:errors>
</div>

<div class="form-group row">
    <form:label path="password"><b>Password</b></form:label>
    <form:input path="password" type="password" class="form-control" placeholder="" name="Password" required="true"/><br>
     <form:errors path="password"></form:errors>
</div>

<div class="form-group row">
    <form:label path="shipping_address"><b>shipping_address</b></form:label>
    <form:textarea path="shipping_address" class="form-control" placeholder="" name="shipping_address" required="true"/><br>
     <form:errors path="shipping_address"></form:errors>
</div>

<div class="form-group row">
    <form:label path="billing_address"><b>billing_address</b></form:label>
    <form:textarea path="billing_address" class="form-control" placeholder="" name="billing_address" required="true"/><br>
     <form:errors path="billing_address"></form:errors>
</div>

<div class="form-group row">
<form:hidden path="authorities.role" value="ROLE_USER"></form:hidden>
</div>

 <tr>
         <td colspan = "2">
         <button type="submit" class="btn btn-warning" >Submit</button>
          </td>
          </tr>

         <tr>
         <td colspan = "2">
         <a><button type="submit" class="btn btn-warning" >Cancel</button></a>
          </td>
          </tr>
</div>
    </form:form>





</body>
</html>