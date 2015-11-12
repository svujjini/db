<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Orders</title>
</head>
<body bgcolor=beige>
	<div align="right">
		<font face="Tahoma" size=2> <%= session.getAttribute("CustomerName") %>
		</font>
	</div>

	<h1 style="background-color: BurlyWood;">
		Books-a-Zillion
		<div align="right">
			<font face="Tahoma" size=2> <a
				href="/OnlineBookstore/EditUserDetailsServlet">My Profile</a> <a
				href="/OnlineBookstore/Search.jsp">Search</a> <a
				href="/OnlineBookstore/TraceOrderServlet">My Orders</a>
			</font>
		</div>
	</h1>
	<h4 style="background-color: BurlyWood;">
	
		The best online bookstore in town!!
		<div align="right">
	<button onclick = "window.location.href='LoginSuccess.jsp'">Home</button>
	</div>
	</h4>
	<center>
		<form action=SearchServlet>
			<table border=1>
				<tr>
					<th colspan="7">Your Orders</th>
				</tr>
				<tr>
					<td>Order ID</td>
					<td>Status</td>
					<td>Order Date</td>
					<td>Total Price</td>
				</tr>
				<tr>
					<td><%= session.getAttribute("Order_ID")%></td>
					<td><%= session.getAttribute("Order_Status") %></td>
					<td><%= session.getAttribute("Order_Date") %></td>
					<td><%= session.getAttribute("Total_Price") %></td>
				</tr>

			</table>
		</form>
	</center>

</body>
</html>