package OnlineBookstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmpListOrderInfoServlet
 */
@WebServlet("/EmpListOrderInfoServlet")
public class EmpListOrderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MysqlDatabaseConnection d;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpListOrderInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String EmpName= (String) session.getAttribute("CustomerName");
		 String redirect = null;
		 System.out.println("Inside servlet");
		  
		String EmpSearchQuery= "Select E.EMP_ID,O.Order_ID,O.Order_Status,O.Total_Price, O.Shipping_Address, O.Order_Date,O.Bill_Address "
				+ "FROM Employee E,book_Order O WHERE E.EMP_ID = O.EMP_ID AND E.NAME ='"+ EmpName + "'";
		 System.out.println("EmpSearchQuery==="+EmpSearchQuery);
		
		 d = new MysqlDatabaseConnection();
			d.connectMeIn();
		 
			        try {
	           // Connection con = DriverManager.getConnection(
	            //"jdbc:oracle:thin:@localhost:1521/oracl","anju","Oracle12");
	            //Statement stmt = con.createStatement();
	            
			        	ResultSet rs = d.execute(EmpSearchQuery);
	           
			        	//boolean isEmpty = rs.next();
	            System.out.println("In jdbc conn");
	            
	            if(rs != null){
	            	empOrder emporder=null;
	            	 ArrayList orderList = new ArrayList();
	            	 while(rs.next()){   
	            	 emporder = new empOrder();
	            	 emporder.setEmpId(rs.getString("EMP_ID"));
	            	 emporder.setOrderId(rs.getString("ORDER_ID"));
	            	 emporder.setOrderStatus(rs.getString("order_Status"));
	            	 emporder.setTotalPrice(rs.getString("total_Price"));
	            	 emporder.setShippingAddress(rs.getString("shipping_Address"));
	            	 emporder.setOrderDate(rs.getString("order_date"));
	                 emporder.setBillingAddress(rs.getString("bill_Address"));
	                 orderList.add(emporder);
	               // session.setAttribute("CustomerName", rs.getString("cust_name"));
	                
	               // session.setAttribute("loginUser", cust);
	               
	                System.out.println("at th end");
	                // redirect to success page
	                 
	            } 
				session.setAttribute("orderlist", orderList);
	        }
				
	        }
		        catch (Exception e) {
		            System.out.println("Exception occured: " + e.getMessage());
		            e.printStackTrace();
		        }	        
		
	        request.getRequestDispatcher("/ListOrderInfo.jsp").forward(request, response);
	        
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
