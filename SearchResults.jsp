<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="booklist" class="java.util.ArrayList" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body bgcolor=beige>
<div align ="right">
<font face= "Tahoma" size =2>
        Login Success &nbsp;
                
</font>
</div>

<h1 style ="background-color:BurlyWood;">Books-a-Zillion 
<div align ="right">
<font face= "Tahoma" size =2>
 <a href="/OnlineBookstore/EditUserDetailsServlet">My Profile</a>
 <a href="/OnlineBookstore/Search.jsp">Search</a>
 <a href="/OnlineBookstore/Order.jsp">My Orders</a>
 </font>
 </div>
</h1>
<h4 style ="background-color:BurlyWood;" ><br>The best online bookstore in town!!
 </h4>
 <center><form action=SearchServlet>
            <table border=1>
                <tr>
                    <th colspan="7">Search Results</th> 
                </tr>
                <tr>
                    <td>TITLE</td>
                    <td>AUTHOR</td>
                    <td>CATEGORY</td>
                    <td>YEAR_OF_PUBLISH</td>
                    <td>PRICE</td>
                   
                </tr>
               
  			<c:forEach items="${booklist}" var="book">
   			 <tr>
      		<td><c:out value="${book.title}" /></td>
      		<td><c:out value="${book.author}" /></td>
      		<td><c:out value="${book.category}" /></td>
      		<td><c:out value="${book.year}" /></td>
      		<td><c:out value="${book.price}" /></td>
    		</tr>
  			</c:forEach>
</table>                  
        </form>
        </center>
   
</body>
</html>