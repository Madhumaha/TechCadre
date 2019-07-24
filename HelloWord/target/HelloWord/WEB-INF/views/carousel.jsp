<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
  
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="2" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="3" class="active"></li>
  </ol>

  
  <div class="carousel-inner">
    <div class="item active">
      <img src="D:/my java programs/Bootstrap/electronics.jpg" alt="Electronics" height="1000px" width="1500px">
    </div>

    <div class="item">
      <img src="D:/my java programs/Bootstrap/mobile.jpg" alt="Smart Phone" height="1000px" width="1500px">
    </div>

    <div class="item">
      <img src="D:/my java programs/Bootstrap/menclothing.jpg" alt="Men Clothing" height="1000px" width="1500px">
    </div>
  

    <div class="item">
      <img src="D:/my java programs/Bootstrap/womenclothing.jpg" alt="Women Clothing" height="1000px" width="1500px">
    </div>
  </div>

  
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
</body>
</html>>