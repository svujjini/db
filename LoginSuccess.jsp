<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
</head>
<body bgcolor=beige>
<div align ="right">
<font face= "Tahoma" size =2>
        Login Success &nbsp;
        Welcome, <%= session.getAttribute("CustomerName") %>        
</font>
</div>
<h1 style ="background-color:BurlyWood;">Books-a-Zillion
<div align ="right">
<font face= "Tahoma" size =2>
 <a href="/OnlineBookstore/EditUserDetailsServlet" >My Profile</a>
  <a href="/OnlineBookstore/Search.jsp">Search</a>
 <a href="/OnlineBookstore/TraceOrder.jsp">My Orders</a>
 
</font>
</div>
</h1>
<h4 style ="background-color:BurlyWood;" ><br>The best online bookstore in town!!


 </h4>
</body>
</html>