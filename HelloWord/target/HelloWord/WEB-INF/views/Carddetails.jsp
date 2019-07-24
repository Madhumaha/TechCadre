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

 <div class="container">
            <h3>Payment</h3>
            
            <div class="row">
            <div class="container">
                <label for="cname">Account holder name</label>
                <input type="text" id="cname" name="cardname" placeholder="">
             </div>   
            
            <div class="container">
                <label for="ccnum">Credit card number</label>
                <input type="text" id="ccnum" name="cardnumber" placeholder="">
            </div>
            
           <div class="container">
                 <label for="expmonth">Expiry Month</label>
                 <input type="text" id="expmonth" name="expmonth" placeholder="">
             </div>
              <div class="container">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="">
              </div>
            </div>
            
              <a class="btn btn-success" href="<c:url value='/cart/createorder'></c:url>">proceed to checkout</a>
          </div>
</body>
</html>