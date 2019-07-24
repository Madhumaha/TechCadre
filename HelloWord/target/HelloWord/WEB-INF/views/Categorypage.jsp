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
<c:url value="/admin/addcategory" var="caturl"></c:url>
<form:form  method="post" action="${caturl}" style="border:1px solid #ccc">
  <div class="container">
    <h1>Category Details</h1>
   
    
    

<div class="form-group row">
    <form:label path="categoryname"><b>Category Name</b></form:label>
    <form:input path="categoryname" type="text" class="form-control" placeholder="" name="Category Name" required="true"/><br>
    <form:errors path="categoryname"></form:errors>
</div>


<div class="form-group row">
     <form:hidden path="category_id"  class="form-control" placeholder="" name="Category Id" /><br>
</div>


<div class="form-group row">
    <form:label path="description"><b>Description</b></form:label>
    <form:input path="description" type="text" class="form-control" placeholder=" " name="Description" required="true"/><br>
     <form:errors path="description"></form:errors>
</div>
        <tr>
         <td colspan = "2">
          <input type = "submit" value = "Submit"/>
          </td>
          </tr>

         <tr>
         <td colspan = "2">
          <input type = "reset" value = "Reset"/>
          </td>
          </tr>
</div>
</form:form>


<h1>Category Details</h1>

<table class="table"  style="width:75%">
  <tr>
    <th>Category Id</th>
    <th>Category Name</th>
    <th>Description</th> 
    
    </tr>
    
    <c:forEach items="${categorylist}" var="c">
  <tr>
    <td>${c.category_id}</td>
    <td>${c.categoryname}</td>
    <td>${c.description}</td>
     <td><a href="updatecategory/${c.category_id}"><button type="button" class="btn btn-primary">Update</button></a></td>
    <td><a href="deletecategory/${c.category_id}"><button type="button" class="btn btn-danger">Delete</button></a></td>
    <tr>
    </c:forEach>
    
  
</table>
 </body>
</html>