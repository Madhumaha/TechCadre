<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



 <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
    width: 70%;
    margin: auto;
  }
 
  </style>

</head>
<body>
<div>
 <jsp:include page="Navbar.jsp" /> 
</div>
<div class="container">


  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
      <li data-target="#myCarousel" data-slide-to="5"></li>
      <li data-target="#myCarousel" data-slide-to="6"></li>
      <li data-target="#myCarousel" data-slide-to="7"></li>
      <li data-target="#myCarousel" data-slide-to="8"></li>
      <li data-target="#myCarousel" data-slide-to="9"></li>
     
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src=<c:url value="/resources/images/sale.jpg"/> alt="" >
        <div class="carousel-caption">
        </div>
      </div>

      <div class="item">
        <img src=<c:url value="/resources/images/veggi.jpg"/> alt="" >
        <div class="carousel-caption">
        <p>Shop now...2 days moree</p>
          </div>
      </div>
    
      <div class="item">
        <img src=<c:url value="/resources/images/menu-banner-4.jpg"/> alt="" width="450" height="350">
        <div class="carousel-caption">
          <h3>Offers</h3>
          <p>Mega offers online in different categories.</p>
        </div>
        </div>
        
        <div class="item">
        <img src=<c:url value="/resources/images/tim.png"/> alt="" width="450" height="350">
        <div class="carousel-caption">
        <p>Shop now...2 days moree</p>
          </div>
      </div>
      
      <div class="item">
        <img src=<c:url value="/resources/images/winter.jpg"/> alt="" width="450" height="350">
        <div class="carousel-caption">
        <p>Shop now...2 days moree</p>
          </div>
      </div>
      
      <div class="item">
        <img src=<c:url value="/resources/images/elec.jpg"/> alt="" width="343" height="147">
        <div class="carousel-caption">
        <p>Shop now...2 days moree</p>
          </div>
      </div>
      
      <div class="item">
        <img src=<c:url value="/resources/images/decor.jpg"/> alt="" width="343" height="147">
        <div class="carousel-caption">
        <p>Shop now...2 days moree</p>
          </div>
      </div>
      
      <div class="item">
        <img src=<c:url value="/resources/images/men.jpg"/> alt="" width="343" height="147">
        <div class="carousel-caption">
        <p>Shop now...2 days moree</p>
          </div>
      </div>
      
      <div class="item">
        <img src=<c:url value="/resources/images/cloth.jpg"/> alt="" width="343" height="147">
        <div class="carousel-caption">
        <p>Shop now...2 days moree</p>
          </div>
      </div>
      
      <div class="item">
        <img src=<c:url value="/resources/images/ear.jpg"/> alt="" width="343" height="147">
        <div class="carousel-caption">
        <p>Shop now...2 days moree</p>
          </div>
      </div>
      
      </div>


<!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
   
  
    </div>

    
  </div>


<div class="container" style="margin-top:50px;">
<div class="row" >
 <c:forEach items="${productlist}" var="p">
 <div class="col-md-4" style="margin-top:50px;">
 <security:authorize access="hasRole('ROLE_USER')">
<form action="<c:url value='/viewproduct/${p.product_id}'></c:url>" >
  <a href="<c:url value='/viewproduct/${p.product_id}'></c:url>">  <img src="<c:url value="/resources/images/${p.product_id}.jpg"></c:url>" />
    <br/>
   <center>
    ${p.productname}
    <br/>
    Stock:${p.quantity}
    <br/>
    Price:Rs. ${p.price}/-
    <br/>
    </a>
    <button type="submit" class="btn btn-warning">View Product</button>
    </center>
    
 
</form>
</security:authorize>
   </div>
 </c:forEach>
</div>
</div>


</body>
</html>