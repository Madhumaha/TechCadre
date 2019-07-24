<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>
 <jsp:include page="Navbar.jsp" /> 
<c:url value="/j_spring_security_check" var="loginurl"/>
 <form action="${loginurl}" style="border:1px solid #ccc" method="post">
 

 
 
 
  <div class="container">
  <h1>Sign In</h1>
    
    

<div class="form-group row">
    <label ><b>Email</b></label>
    <input type="text" class="form-control" placeholder="Enter Email" name="j_username" required><br>
</div>

<div class="form-group row">
    <label><b>Password</b></label>
    <input type="password" class="form-control" placeholder="Enter Password" name="j_password" required><br>
</div>

 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

<div class="clearfix">
      
      <button type="submit" class="btn btn-primary">Sign In</button></a>
      <button type="button" class="btn btn-danger">Cancel</button>
       <span class="psw" class="pull-right">Forgot <a href="#">password?</a></span>
</div>
</div>
</form>
</body>
</html>
