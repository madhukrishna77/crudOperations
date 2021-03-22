<%@taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<c:if test="${employees eq null }">
<c:out value="${noData }"></c:out>
</c:if>
<form  action="search"  method="get"  style="border: 2px solid red;">
       DeptNo : <input  type="text"   name="deptno">
       &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
       <input  type="submit"  value="search"> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
       
       
       
</form>
<a href="listEmployees" class="btn btn-success"> List Employees Data </a>&nbsp;&nbsp; &nbsp;&nbsp;
              <a href="addEmployee" class="btn btn-primary"> Add New Employee Data </a>
       &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="show" class="btn btn-danger"> Home Page</a><br/>

<hr  color="red">
<body>
<div class="container">

<table class="table table-dark" >
   <tr class="info">
       <th>EMPNO</th>
       <th>ENAME</th>
       <th>SALARY</th>
       <th>DEPTNO</th>
       <th>ACTIONS ON ROW</th>
   </tr>
   <c:if  test="${!empty  employees }">
   
        <c:forEach   items="${employees}"   var="emp">
              <tr class="success">
                    <td><c:out  value="${emp.empno}"/></td>
                    <td><c:out  value="${emp.ename}"/></td>
                    <td><c:out  value="${emp.salary}"/></td>
                    <td><c:out  value="${emp.deptNo}"/></td>
                    <td>
                            <a href="editEmployee?empno=${emp.empno}"><img  src="images/edit.png"  width="50" height="30"></a>
                            &nbsp; &nbsp; &nbsp;
                            <a href="deleteEmployee?empno=${emp.empno}"><img  src="images/delete.png"  width="50"  height="30"></a>
                    </td>
              </tr>          
        </c:forEach>
   
   </c:if>
</table>
</div>
</body>
