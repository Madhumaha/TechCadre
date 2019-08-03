<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

</head>

<body>
<jsp:include page="Navbar.jsp" />
<script type="text/javascript">
function checkqty
{
	if()
	}
</script>  
<div class="container">
<b>Product Details</b>
<pre>
<img src="<c:url value="/resources/images/${product.product_id }.jpg"></c:url>" height="200px" width="100px" class="img-rounded">
<b>Product Name  :</b> ${product.productname}
<b>Description   :</b>${product.description }
<b>Price         :</b>${product.price }
<b>In Stock      :</b>${product.quantity }
<security:authorize access="hasRole('ROLE_USER')">
<form action="<c:url value='/cart/addtocart/${product.product_id}'></c:url>" >
Enter required units<br>
<input  type="number" name="requestedQuantity" min="1" >

<security:authorize access="hasRole('ROLE_USER')">
<c:if test="${product.quantity==0}">
<input type="button" disabled class="btn btn-lg btn-danger" value="Out of stock">
</c:if>
<c:if test="${product.quantity!=0}">
<input type="submit"  class="btn btn-lg btn-primary" value="Add To Cart">
</c:if>
</security:authorize>


</form> 
</security:authorize>
</pre>

</div>
</body>
</html>

