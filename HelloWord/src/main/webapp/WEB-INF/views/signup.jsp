<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>
<c:url value=/homepage var="signupurl"/>
 <form action="${signupurl}" style="border:1px solid #ccc" method="post">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

<div class="form-group row">
    <label for="First Name"><b>First Name</b></label>
    <input type="text" class="form-control" placeholder="Enter Your First Name" name="First Name" required><br>
</div>

<div class="form-group row">
    <label for="Last Name"><b>Last Name</b></label>
    <input type="text" class="form-control" placeholder="Enter Your Last Name" name="Last Name" required><br>
</div>

<div class="form-group row">
    <label for="email"><b>Email</b></label>
    <input type="text" class="form-control" placeholder="Enter Email" name="email" required><br>
</div>

<div class="form-group row">
    <label for="psw"><b>Password</b></label>
    <input type="password" class="form-control" placeholder="Enter Password" name="psw" required><br>
</div>

<div class="form-group row">
    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" class="form-control" placeholder="Repeat Password" name="psw-repeat" required><br>
</div>

<form:hidden path="user.authorities.role" value="ROLE_USER"></form:hidden>


<div class="form-group row">
    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label><br>
</div>

    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="btn btn-danger">Cancel</button>
      <button type="submit" class="btn btn-primary">Sign Up</button>
    </div>
  </div>
</form>
</body>
</html>