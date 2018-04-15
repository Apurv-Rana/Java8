<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ page import="java.util.List" %>
 <%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title value="Booking"></title>

</head>
<body Style="background-image:url('https://images7.alphacoders.com/661/661783.jpg');background-attachment:fixed; background-size:cover;">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">apurv Railway</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
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
<div class ="row  mt-4" >
<div class="col-2"></div>
<div class="col-8">
<form method="get" action="tick" style="color:white; background-color: rgba(0, 0, 0, .6); padding:20px;">
<div class="card" style="margin-bottom:20px;background-color: rgba(255,255,255, .6);">
  <div class="card-header" style="color:black;">
    ${param.name } (${param.number })
  </div>
  <div class="card-body"  style="color:black;">
    <h5 class="card-title"><i class="fa fa-subway"></i>  Your Journey date is ${param.date }</h5>
   
  </div>
</div>
<input type="hidden"  name="number" value="${param.number}">
<input type="hidden"  name="source" value="${param.source}">
<input type="hidden"  name="destination" value="${param.destination}">
           <input type="hidden"  name="trainname" value="${param.name}">
       
         <input type="hidden"  name="date" value="${param.date}">

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Name</label>
    <div class="col-sm-10">
      <input type="text" name = "name" class="form-control" id="inputEmail3" placeholder="Full name ">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="email" name="email" class="form-control" id="inputPassword3" placeholder="email">
    </div>
  </div>
  <fieldset class="form-group">
    <div class="row" style="margin-bottom:5px;">
      <legend class="col-form-label col-sm-2 pt-0">Radios</legend>
      <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" value="male" type="radio" name="gender" id="gridRadios1" value="option1" checked>
          <label class="form-check-label" for="gridRadios1">
            Male 
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input"  value="female" type="radio" name="gender" id="gridRadios2" value="option2">
          <label class="form-check-label" for="gridRadios2">
            Female 
          </label>
        </div>
       
      </div>
    </div>
    <div class="form-group row">
    <div class="col-2">
      <label for="inputState">State</label>
      </div>
      <select name="clas" class="col-6 form-control" id="inputState" >
        <option value="FC" selected>First Class</option>
        <option value="SL">Sleeper Class</option>
      </select>
    </div>
  </fieldset>
  <div class="form-group row">
    <div class="col-sm-2">Non cancallable </div>
    <div class="col-sm-10">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="gridCheck1">
        <label class="form-check-label" for="gridCheck1">
          Agree that this is Non cancallabe ticket
        </label>
      </div>
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-success">Book</button>
    </div>
  </div>
  <div class="col-2"></div>
  </div>
</form>
 <div>
</body>
</html>