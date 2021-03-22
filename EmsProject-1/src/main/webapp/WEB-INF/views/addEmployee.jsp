<%@taglib  uri="http://www.springframework.org/tags/form"   prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<c:if test="${employee eq null }">
<c:out value="${message }"></c:out>
</c:if>
<body>
<div class="container p-3 my-3 bg-dark text-white">
<div class="jumborton text-center">
<h2>Employee Registration Page </h2>
<div >
<form:form  action="save"  method="post"  modelAttribute="employee">
  <table >
     <tr class="success">
<!--      <label name="empno"></label>
 -->         
  <td>Empno : </td> <td> <form:input  path="empno"/> </td>
     </tr>
     <tr class="info">
          <td>Ename : </td> <td> <form:input  path="ename"/> </td>
     </tr>
     <tr class="danger">
          <td>Salary : </td> <td> <form:input  path="salary"/> </td>
     </tr>
     <tr class="active">
          <td>Deptno : </td> <td> <form:input  path="deptNo"/> </td>
     </tr>
     <tr>
               <td  colspan="2"  align="center">
                <input  type="submit"   value="SAVE Employee">
          </td>
     </tr>     
  </table>

</form:form>
   <a href="listEmployees" class="btn btn-primary">List Employees</a>
   <hr/>
   
</div></div>
</div>
</body>