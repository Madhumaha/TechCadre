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
<c:url value="/admin/addsupplier" var="supurl"></c:url>
<form:form  method="post" action="${supurl}" style="border:1px solid #ccc">
  <div class="container">
    <h1>Supplier Details</h1>
    
    

<div class="form-group row">
    <form:label path="suppliername"><b>Supplier Name</b></form:label>
    <form:input path="suppliername" type="text" class="form-control" placeholder="" name="Supplier Name" required="true"/><br>
     <form:errors path="suppliername"></form:errors>
</div>


<div class="form-group row">
     <form:hidden path="supplier_id"  class="form-control" placeholder="" name="Supplier Id" /><br>
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





<h1>Supplier Details</h1>

<table class="table"  style="width:75%">
  <tr>
    <th>Supplier Id</th>
    <th>Supplier Name</th>
     
   </tr>
   <c:forEach items="${supplierlist}" var="s">
   <tr>
    <td>${s.supplier_id}</td>
    <td>${s.suppliername}</td>
     <td><a href="updatesupplier/${s.supplier_id}"><button type="button" class="btn btn-primary">Update</button></a></td>
    <td><a href="deletesupplier/${s.supplier_id}"><button type="button" class="btn btn-danger">Delete</button></a></td>
    </tr>
    </c:forEach>
  
</table>
  

 
</body>
</html>