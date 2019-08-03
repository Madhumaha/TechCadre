<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%> 
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="container">
<nav class="navbar navbar-inverse" id="navcolour">
<div class="navbar-header">
<a class="navbar-brand"><img src="<c:url value="/resources/images/logo1.png"/>" height="30px" width="60px"></a>
</div>

<ul class="nav navbar-nav" id="links">
   <li><a href="<c:url value="/homepage" />">Home</a></li>
  
   <li class="dropdown">
   <a class="dropdown-toggle" data-toggle="dropdown" href="#">All Categories
   <span class="caret"></span></a>
   <ul class="dropdown-menu">
     
      <c:forEach items="${categorylist}" var="c">
       <li><a href="<c:url value="/categorydisplay/${c.category_id}" />">${c.categoryname}</a></li>
       
      </c:forEach>
      
      
  </ul>

  </li>
 
  </ul>



<ul class="nav navbar-nav navbar-right">
<c:if test="${pageContext.request.userPrincipal.name != null }">
<li><a href="#">Welcome, ${ufname}</a></li>
</c:if>
<security:authorize access="hasRole('ROLE_ADMIN')">
<%-- <c:if test="${pageContext.request.userPrincipal.name == 'maha@gmail.com'}"> --%>
      <li><a href="<c:url value="/admin/adminpage" />" >ADMIN</a></li>
<%--       </c:if> --%>
</security:authorize>
      <c:if test="${pageContext.request.userPrincipal.name == null }">
      <li><a href="<c:url value="/Userpage" />" ><span class="glyphicon glyphicon-user">SignUp</span></a></li>
      <li><a href="<c:url value="/signin" />" ><span class="glyphicon glyphicon-log-in"> </span> Sign In</a></li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name != null }">
      <li><a href="<c:url value="/j_spring_security_logout" />" ><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name != null }">
      <security:authorize access="hasRole('ROLE_USER')">
      <li><a href="<c:url value="/cart/getcartitems" />" ><span class="glyphicon glyphicon-shopping-cart"></span>My Cart</a></li>
      <li><a href="<c:url value="/cart/orderdisplay" />" ></span>My Orders</a></li>
      </security:authorize>
      </c:if>
      </ul>
    </nav>
</div>
</body>
</html>