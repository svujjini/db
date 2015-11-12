package OnlineBookstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class EmployeeLoginServlet
 */
@WebServlet("/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlDatabaseConnection d;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession(true);
	        
	        String redirect = null;
	
			
			 String userId = request.getParameter("userId");
		        String password = request.getParameter("pwd");
		        String searchQuery = "select * from Customer where accountid='" + userId
			                + "' AND password='" + password + "'";
		        
		        		        
		        
		   //     try {
		     //       Class.forName("oracle.jdbc.driver.OracleDriver");
		       // } 
		     //   catch (ClassNotFoundException e) {
		       //     System.out.println(e.getMessage());
		            
		     //   }
		        
		        
		    	d = new MysqlDatabaseConnection();
				d.connectMeIn();
		         
		        try {
		        
		       
		        
		            //Connection con = DriverManager.getConnection(
		            	//	"jdbc:oracle:thin:@localhost:1521/oracl","anju","Oracle12");
		           // Statement stmt = con.createStatement();
		            ResultSet rs = d.execute(searchQuery);
		            boolean isEmpty = rs.next();
		            if (!isEmpty) {
		                // redirect to error page
		               response.sendRedirect("EmpLoginFailure.jsp");
		            	 // redirect = "LoginFailure.jsp";
		            } 
		            else if (isEmpty) {
		                // fetch the session from request, create new session if session
		                // is not present in the request
		            	
		                session.setAttribute("CustomerName", rs.getString("cust_name"));
		                
		               // session.setAttribute("loginUser", cust);
		               
		                
		                // redirect to success page
		                response.sendRedirect("EmployeeSuccessLogin.jsp");
		            }
		        } 
		        catch (Exception e) {
		            System.out.println("Exception occured: " + e.getMessage());
		            e.printStackTrace();
		        }
		        
		        
		        
		        
		        
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
						Statement stmt  = con.createStatement();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
		        
			}
		        
		        
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
