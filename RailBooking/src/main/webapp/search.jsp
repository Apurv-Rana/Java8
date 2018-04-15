<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ page import="java.util.List" %>
 <%@page import="java.util.ArrayList" %>
 <%@page import="com.apurv.entities.Train" %>

 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>


<body  Style="background-image:url('https://images7.alphacoders.com/661/661783.jpg');background-attachment:fixed; background-size:cover;">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">apurv Railway</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">book</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
  
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    
  </div>
</nav>
<c:forEach items="${train}" var="train1"> 


<div class="card"  style="background-color: rgba(255, 255, 255, .6); margin-bottom:30px;">
  <div class="card-header" Style="font-weight:bold; color:white;background-color: rgba(0, 0, 0, .6);">
  ( ${train1.trainno}) ${train1.trainname}
  </div>
  <div class="card-body row">
  <div class="col-8">
  <div class="row">
  <div class="col-6">
    <h4 class="card-title" Style="font-weight:none;"> ${train1.source } <i class="fa fa-arrow-right text">  ${train1.destination }</i></h5></div>
    
    <div class="col-2"></div>
    <div class="col-4"><p> FC :&#8377  ${firstAcFare}</p> <p>SL :&#8377 ${secondAcFare} </p></div>
    
    </div>
<p class="card-text text-success" Style="font-weight:bold;"> Monday tuesday wednsday thrusday friday saturday Sunday</p>
    </div>
        <form class="col-4" method="get" action="book.jsp">
       <input type="hidden"  name="number" value="${train1.trainno}">
           <input type="hidden"  name="name" value="${train1.trainname}">
       <input type="hidden"  name="source" value="${train1.source}">
       <input type="hidden"  name="destination" value="${train1.destination}">
         <input type="hidden"  name="date" value="${param.date}">
   <button type="submit" class="btn btn-primary">Book Now </button>
  </form>
  </div>
</div>


</c:forEach>  

</body>









</html>

