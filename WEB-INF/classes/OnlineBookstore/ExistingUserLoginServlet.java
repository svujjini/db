package OnlineBookstore;

import java.sql.*;

import javax.servlet.http.HttpSession;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExistingUserLoginServlet
 */
@WebServlet("/ExistingUserLoginServlet")
public class ExistingUserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDatabaseConnection d;
	
	customer cust ;
	
    /**
     * Default constructor. 
     */
    public ExistingUserLoginServlet() {
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       HttpSession session = request.getSession(true);
        //cust=(customer) session.getAttribute("loginUser");
        String redirect = null;
	if(cust==null){
		
		 String userId = request.getParameter("userId");
	        String password = request.getParameter("pwd");
	        String searchQuery = "select * from Customer where accountid='" + userId
	                + "' AND password='" + password + "'";
	        
	        d = new MysqlDatabaseConnection();
			d.connectMeIn();
			
	        /*try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	        } 
	        catch (ClassNotFoundException e) {
	            System.out.println(e.getMessage());
	            
	        }*/
	        
	        try {
	            /*Connection con = DriverManager.getConnection(
	            		"jdbc:oracle:thin:@localhost:1521/oracl","anju","Oracle12");
	            Statement stmt = con.createStatement();
	            */ 
	        	ResultSet rs = d.execute(searchQuery);
	            boolean isEmpty = rs.next();
	            if (!isEmpty) {
	                // redirect to error page
	                //response.sendRedirect("LoginFailure.jsp");
	            	  redirect = "LoginFailure.jsp";
	            } 
	            else if (isEmpty) {
	                // fetch the session from request, create new session if session
	                // is not present in the request
	            	cust=new customer();
	                cust.setCustName(rs.getString("cust_name"));
	                cust.setPhone(rs.getString("phone"));
	                cust.setStreet(rs.getString("Street"));
	                cust.setCity(rs.getString("City"));
	                cust.setState(rs.getString("State"));
	                cust.setZip(rs.getString("Zip"));
	                cust.setAccountId(rs.getString("AccountId"));
	                cust.setPassword(rs.getString("Password"));
	                session.setAttribute("CustomerName", rs.getString("cust_name"));
	                
	                session.setAttribute("loginUser", cust);
	               
	                
	                // redirect to success page
	                redirect = "LoginSuccess.jsp";
	            }
	        } 
	        catch (Exception e) {
	            System.out.println("Exception occured: " + e.getMessage());
	            e.printStackTrace();
	        }
	        
	}
	
	response.sendRedirect(redirect);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
