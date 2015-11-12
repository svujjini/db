	package OnlineBookstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MysqlDatabaseConnection d;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String redirect = null;
		
		String custName = request.getParameter("custName");
        String phone = request.getParameter("custPhone");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String accountID = request.getParameter("accountId");
        String password = request.getParameter("password");
       
        d = new MysqlDatabaseConnection();
		d.connectMeIn();
       
		try {
       /*     Class.forName("oracle.jdbc.driver.OracleDriver");    
        	
    		PreparedStatement preparedStatement = null;
            Connection con = DriverManager.getConnection(
            		"jdbc:oracle:thin:@localhost:1521/oracl","anju","Oracle12");
         */  
			
		HttpSession session = request.getSession(true); 
            String insertQuery="insert into customer (cust_id, cust_name, phone, street, city, state, zip, accountid, password) values "
            	//	+ "(,'','','','','','','',?)";
            		
            + "(cust_no.nextval,?,?,?,?,?,?,?,?)";
             
                        
            System.out.println("insertQuery"+insertQuery);
            Connection con = d.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
           
           // preparedStatement.setInt(0,40);
            preparedStatement.setString(1,custName);
            preparedStatement.setLong(2,new Long(phone));
            preparedStatement.setString(3,street);
            preparedStatement.setString(4,city);
            preparedStatement.setString(5,state);
            preparedStatement.setInt(6,new Integer(zip));
            preparedStatement.setString(7,accountID);
            preparedStatement.setString(8,password);

            ResultSet rset = preparedStatement.executeQuery();
            //preparedStatement.executeUpdate();
            preparedStatement.close();
            con.commit();
            
            redirect = "NewUserInsertionSuccess.jsp";
        
    } 
    catch (Exception e) {
        System.out.println("Exception occured: " + e.getMessage());
        e.printStackTrace();
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
