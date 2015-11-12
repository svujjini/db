<%@page import="OnlineBookstore.SearchServlet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advanced Search</title>
<script>  
 function CheckAndSubmit(){  
   
 var author=document.frm1.author.value;  
 var lena= author.length;
 var title=document.frm1.title.value;  
 var lent= title.length;
 var category=document.frm1.category.value;  
 var lenc= category.length;
 var year=document.frm1.year_published.value;  
 var leny= year.length;
   
 if(lena==0 && lent==0 && lenc==0 && leny==0){  
 alert("Enter input in one of the fields Please!");  
 return false;  
 }  
 
 }  
 </script> 

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
 <button onclick = "window.location.href='LoginSuccess.jsp' ">Home</button>
 </font>
 </div>
</h1>
<h4 style ="background-color:BurlyWood;" ><br>The best online bookstore in town!!
 </h4>
<form name=frm1 onsubmit= "return CheckAndSubmit();" action=SearchServlet>
            <table border=2>
                <tr>
                    <td>Author:</td>
                    <td><input type=text name=author></td>
                </tr>
                <tr>
                    <td>Title:</td>
                    <td><input type=text name=title></td>
                </tr>
                <tr>
                    <td>Category:</td>
                    <td><input type=text name=category></td>
                </tr>
                <tr>
                    <td>Year of publishing:</td>
                    <td><input type=text name=year_published></td>
                </tr>
                <tr>
                    <td><input type=submit value=Search></td>
                    <td><input type=reset value=Refresh></td>
                </tr>
            </table>
        </form>
</body>
</html>