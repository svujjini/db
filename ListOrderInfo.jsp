<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="orderlist" class="java.util.ArrayList" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Order Info</title>
</head>
<body bgcolor=beige>
<div align ="right">
<font face= "Tahoma" size =2>
        Login Success &nbsp;
                
</font>
</div>

<h1 style ="background-color:BurlyWood;">Books-a-Zillion 

</h1>
<h4 style ="background-color:BurlyWood;" ><br>The best online bookstore in town!!
 </h4>
 <center><form action=EmpListOrderInfoServlet>
            <table border=1>
                <tr>
                    <th colspan="7">List Order Info</th> 
                </tr>
                <tr>
                    <td>EMP_ID</td>
                    <td>ORDER_ID</td>
                    <td>ORDER_STATUS</td>
                    <td>TOTAL_PRICE</td>
                    <td>SHIPPING ADDRESS</td>
                    <td>ORDER_DATE</td>
                    <td>BILLING ADDRESS</td>
                   
                </tr>
               
  			<c:forEach items="${orderlist}" var="emporder">
   			 <tr>
      		<td><c:out value="${emporder.empId}" /></td>
      		<td><c:out value="${emporder.orderId}" /></td>
      		<td><c:out value="${emporder.orderStatus}" /></td>
      		<td><c:out value="${emporder.totalPrice}" /></td>
      		<td><c:out value="${emporder.shippingAddress}" /></td>
      		<td><c:out value="${emporder.orderDate}" /></td>
      		<td><c:out value="${emporder.billingAddress}" /></td>
    		</tr>
  			</c:forEach>
</table>                  
        </form>
        </center>
   


</body>
</html>