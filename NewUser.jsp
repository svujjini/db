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
        <form action=NewUserServlet>
            <table border=1>
                <tr>
                    <th colspan="2">My Profile</th>
                </tr>
                <tr>
                    <td>Customer Name:</td>
                    <td><input type=text name=custName></td>
                </tr>
                <tr>
                    <td>Customer Phone:</td>
                    <td><input type=text name=custPhone></td>
                </tr>
                 <tr>
                    <td>Address-Street:</td>
                    <td><input type=text name=street></td>
                </tr>
                 <tr>
                    <td>City:</td>
                    <td><input type=text name=city></td>
                </tr>
                 <tr>
                    <td>State:</td>
                    <td><input type=text name=state></td>
                </tr>
                 <tr>
                    <td>Zip:</td>
                    <td><input type=text name=zip></td>
                </tr>
                 <tr>
                    <td>Account ID:</td>
                    <td><input type=text name=accountId></td>
                </tr>
                 <tr>
                    <td>Password:</td>
                    <td><input type=text name=password></td>
                </tr>
                <tr>
                    <td><input type=submit value=SaveChanges></td>
                    <td> <input type=button name=back value=Back Page onClick="history.go(-1);" />
               		
                </tr>
            </table>
        </form>
    </center> 
    
</body>
</html>