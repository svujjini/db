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
 * Servlet implementation class TraceOrderServlet
 */
@WebServlet("/TraceOrderServlet")
public class TraceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MysqlDatabaseConnection d;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String cust_name = (String) session.getAttribute("CustomerName");
		Connection con = null;
		try{
			con = createConnection();
			if(con != null){
				Statement stmt = con.createStatement();
				String searchQuery;
				searchQuery = "Select * from Book_Order bo, Customer c where bo.cust_id = c.cust_id and c.cust_name='"+cust_name+"'";
				ResultSet rs = stmt.executeQuery(searchQuery);
				if((rs != null)	 && (rs.next())){
					}
					session.setAttribute("Order_ID", rs.getString("order_id"));
					session.setAttribute("Order_Status", rs.getString("order_status"));
					session.setAttribute("Order_Date", rs.getString("order_date"));
					//session.setAttribute("Year", rs.getString("year_published"));
					session.setAttribute("Total_Price", rs.getString("total_price"));
					//session.setAttribute("Quantity", rs.getString("quantity"));
					request.getRequestDispatcher("/TraceOrder.jsp").forward(request, response);

			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	public Connection createConnection() {
		System.out.println("Creating DataBase Connection");
		Connection connection = null;
		
		d = new MysqlDatabaseConnection();
		d.connectMeIn();

		connection = d.getConnection();
		
		if(connection != null){
			System.out.println("Connection created successfully....");
		}
		else
			System.out.println("Connection not done");
		return connection;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		System.out.println("Hello");
		System.out.println(session.getAttribute("CustomerName"));
	}

}
