<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=beige>
<h1 style ="background-color:BurlyWood;">Books-a-Zillion<br></h1>
<h4 style ="background-color:BurlyWood;" ><br>The best online bookstore in town!!</h4>
<center>
        <form action=EmployeeLoginServlet>
            <table border=1>
                <tr>
                    <th colspan="2">Login Form</th>
                </tr>
                <tr>
                    <td>Enter your Employee User Id:</td>
                    <td><input type=text name=userId></td>
                </tr>
                <tr>
                    <td>Enter your Password:</td>
                    <td><input type=password name=pwd></td>
                </tr>
                <tr>
                    <td><input type=submit value=submit></td>
                    <td><input type=reset value=refresh></td>
                </tr>
            </table>
        </form>
    </center> 


</body>
</html>