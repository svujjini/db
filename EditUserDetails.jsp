<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="customer" class="OnlineBookstore.customer" scope="session" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=beige>
<div align ="right">
<font face= "Tahoma" size =2>
        
        Welcome, <%= session.getAttribute("CustomerName") %>        
</font>
</div>
<h1 style ="background-color:BurlyWood;">Books-a-Zillion
<div align ="right">
<font face= "Tahoma" size =2>
 <a href="/OnlineBookstore/EditUserDetails.jsp">My Profile</a>
  <button onclick = "window.location.href='LoginSuccess.jsp' ">Home</button>
</font>
</div>
</h1>
<h4 style ="background-color:BurlyWood;" ><br>The best online bookstore in town!!
 </h4>
 <center>
        <form action= NewUserServlet>
            <table border=1>
                <tr>
                    <th colspan="2">My Profile</th>
                </tr>
                <tr>
                    <td>Customer Name:</td>
                    <td><input type=text name =CustName value = <%= session.getAttribute("CustomerName") %>  >  </td>
                </tr>
                <tr>
                    <td>Customer Phone:</td>
                    <td><input type=text name =Phone value = <%= session.getAttribute("Phone") %>></td>
                </tr>
                 <tr>
                    <td>Address-Street:</td>
                    <td><input type=text name =Street value = <%= session.getAttribute("Street") %>></td>
                </tr>
                 <tr>
                    <td>City:</td>
                    <td><input type=text name =City value = <%= session.getAttribute("City") %>></td>
                </tr>
                 <tr>
                    <td>State:</td>
                    <td><input type=text name =State value = <%= session.getAttribute("State") %>></td>
                </tr>
                 <tr>
                    <td>Zip:</td>
                    <td><input type=text name =Zip value = <%= session.getAttribute("Zip") %>></td>
                </tr>
                 <tr>
                    <td>Account ID:</td>
                    <td><input type=text name =AccountId value = <%= session.getAttribute("AccountId") %>></td>
                </tr>
                 <tr>
                    <td>Password:</td>
                    <td><input type=text name =Password value = <%= session.getAttribute("Password") %> ></td>
                </tr>
                <tr>
                    <td><input type=reset value=refresh></td>
                    <td><input type=submit value=SaveChanges></td>
                    
                </tr>
            </table>
        </form>
    </center> 
</body>
</html>