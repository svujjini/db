package OnlineBookstore;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;




public class MysqlDatabaseConnection {
	String connName;
	String userName;
	String password;
	String hostName;
	int port;
	String SID;
	Connection connection;
    Statement stat;


	public void connectMeIn()
	{
		try{
			Class.forName(StringUtility.mysql_driver);
			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			connection = DriverManager.getConnection(StringUtility.mysql_url, StringUtility.mysql_username,StringUtility.mysql_password);
			stat = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet execute(String SQL)
	{
	    ResultSet rs;
		try {
			rs = stat.executeQuery(SQL);
		    return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void insert(String SQL)
	{
	    Statement stat;
		try {
			stat = connection.createStatement();
			stat.executeUpdate(SQL);
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}   
	}
	public Connection getConnection(){
		return connection;
	}
	public PreparedStatement prepare(String query){
		try {
			return (PreparedStatement) connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	public void closeConnection()
	{
		try {
			stat.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


