<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Navbar.jsp" />  

<form action="<c:url value="/cart/createorder" />" method="post">
<table align="center" width="40%" class="table table-bordered">
	<tr bgcolor="cyan"><td colspan="2">Payment Process </td></tr>
<tr>
		<td>Payment Mode </td>
		<td>
  		 <input type="radio" name="pmode" value="CC">Credit Card
		<input type="radio" name="pmode" value="CD">Cash On Delivery
		</td>
	</tr>
	
	
	<tr>
		<td>Credit Card</td>
		<td><input type="text"pattern="^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$" name="ccard"/></td>
	</tr>
	
	<tr>
		<td>Validity <input type="text"pattern="^((0[1-9])|(1[0-2]))\/((2009)|(20[1-2][0-9]))$" name="validity"/></td>
		<td>CVV <input type="text" pattern="[3-9]\d\d" name="cvv"/></td>
	</tr>
	
	<tr >
		<td> Name on Card</td>
		<td> <input type="text" pattern="[A-Z][a-zA-Z][^#&<>\"~;$^%{}?]{1,20}$" name="cname"/></td>
	</tr>
	<tr>
		<td colspan="2"><center><input type="submit" value="Payment Process"/></center></td>
	</tr>
	
</table>
</form>
</body>
</html>