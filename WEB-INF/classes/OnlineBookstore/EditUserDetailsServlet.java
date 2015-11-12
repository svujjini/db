package OnlineBookstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditUserDetailsServlet
 */
@WebServlet("/EditUserDetailsServlet")
public class EditUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDatabaseConnection d;
	customer cust ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession(true);
		 
	        //cust=(customer) session.getAttribute("loginUser");
	        String redirect = null;
	        String EmpName= (String) session.getAttribute("CustomerName");
		if(cust==null){
			
			  String editQuery = "select * from Customer where cust_name='" + EmpName + "'" ;
		     
			  /* try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		        } 
		        catch (ClassNotFoundException e) {
		            System.out.println(e.getMessage());
		            
		        }*/
			  
			  d = new MysqlDatabaseConnection();
				d.connectMeIn();
		         
			  
		        try {
		           // Connection con = DriverManager.getConnection(
		             //       "jdbc:oracle:thin:@localhost:1521/oracl","anju","Oracle12");
		            //Statement stmt = con.createStatement();
		        	
		            ResultSet rs = d.execute(editQuery);
		           boolean isEmpty = rs.next();
		            if (!isEmpty) {
		                // redirect to error page
		                //response.sendRedirect("LoginFailure.jsp");
		            	  redirect = "LoginFailure.jsp";
		            } 
		            else if (isEmpty) {
		                // fetch the session from request, create new session if session
		                // is not present in the request
		            	/*cust=new customer();
		                cust.setCustName(rs.getString("cust_name"));
		                cust.setPhone(rs.getString("phone"));
		                cust.setStreet(rs.getString("Street"));
		                cust.setCity(rs.getString("City"));
		                cust.setState(rs.getString("State"));
		                cust.setZip(rs.getString("Zip"));
		                cust.setAccountId(rs.getString("AccountId"));
		                cust.setPassword(rs.getString("Password"));*/
		                session.setAttribute("custName", rs.getString("cust_name"));
		                session.setAttribute("Phone", rs.getString("phone"));
		                session.setAttribute("Street", rs.getString("street"));
		                session.setAttribute("City", rs.getString("city"));
		                session.setAttribute("State", rs.getString("state"));
		                session.setAttribute("Zip", rs.getString("zip"));
		                session.setAttribute("AccountId", rs.getString("accountid"));
		                session.setAttribute("Password", rs.getString("password"));
		                
		                session.setAttribute("loginUser", cust);
		               
		                
		                // redirect to success page
		                redirect = "EditUserDetails.jsp";
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
