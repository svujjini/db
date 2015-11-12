package OnlineBookstore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MysqlDatabaseConnection d;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String year = request.getParameter("year_published");
		Connection con = null;
		try{
			con = createConnection();
			if(con != null){
				Statement stmt = con.createStatement();
				String searchQuery;
				//System.out.println("Title"+title);
				//System.out.println(year);
				//System.out.println(category);
				if(author !="")
					searchQuery = "select * from Book where author='"+author+"'";
				
				else {
					if(title != "")
						searchQuery = "select * from Book where title='"+title+"'";
				
				else {
					if(category != "")
						searchQuery = "select * from Book where category ='"+category+"'";
					
					else 
						searchQuery = "select * from Book where year_published ='"+year+"'";
					}
				}
				
												
				ResultSet rs = stmt.executeQuery(searchQuery);
				if(rs != null){
					Book book = null;
					 ArrayList bookList = new ArrayList();
					
					while(rs.next()){
						book = new Book();
						book.setTitle(rs.getString("title"));
						book.setAuthor(rs.getString("author"));
						book.setCategory(rs.getString("category"));
						book.setYear(rs.getString("year_published"));
						book.setPrice( rs.getString("price"));
						bookList.add(book);
			
				/*	session.setAttribute("Title", rs.getString("title"));
					session.setAttribute("Author", rs.getString("author"));
					session.setAttribute("Category", rs.getString("category"));
					session.setAttribute("Year", rs.getString("year_published"));
					session.setAttribute("Price", rs.getString("price"));
					session.setAttribute("Quantity", rs.getString("quantity"));*/
						
					}
					
					session.setAttribute("booklist", bookList);
				}
				request.getRequestDispatcher("/SearchResults.jsp").forward(request, response);

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
		
	}

}

