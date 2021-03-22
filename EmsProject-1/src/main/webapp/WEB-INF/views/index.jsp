
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<!-- <h3 style="border: 2px solid  cyan; color: blue;">
 -->  <c:if  test="${message ne null }">
      <c:out  value="${message }"/>
      
  </c:if>
<!-- </h3>

 -->
 
 
 <body>
<div class="container p-3 my-3 bg-dark text-white">
<div class="jumborton text-center">
<h2 style="text-color: red">Welcome to Employee Page</h2>
<marquee> Welcome to Employee PAge </marquee>
<hr>
 <img  src="images/emp.png" width="300px" height="180px" border="3px">
<br><br>
 <a href="addEmployee" class="btn btn-primary"> Add Employee </a> &nbsp;&nbsp;&nbsp; 
 <a href="deleteEmployee" class="btn btn-danger"><em> Delete Employee </em></a> 
 <br><br>
  <a href="update" class="btn btn-danger"><em> Update Employee </em></a> 
 
    &nbsp;&nbsp;&nbsp;
<a href="listEmployees" class="btn btn-primary"> List Employees </a><br/>

     </div>
     </div>
</body>


   

