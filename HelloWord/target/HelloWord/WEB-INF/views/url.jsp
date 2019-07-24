<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Navbar.jsp" />

<div class="container">
<a href="<c:url value='/admin/Productpage'></c:url>" ><button type="button"class="btn btn-success" >Manage Products</button></a>
<a href="<c:url value='/admin/Categorypage'></c:url>" ><button type="button"class="btn btn-success" >Manage Categories</button></a>
<a href="<c:url value='/admin/Supplierpage'></c:url>" ><button type="button"class="btn btn-success" >Manage Suppliers</button></a>
</div>





</body>
</html>