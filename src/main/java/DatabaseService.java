

import java.sql.*;

public class DatabaseService {
	
	
	String url = "jdbc:mysql://localhost:3307/leaves";
	String user = "root";
	String pass = "Chitti2001";
	
	
	public void load() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
	}
	
	public Employee[] getEmployeNames() throws SQLException, ClassNotFoundException {
		//Connection to Db
		load();
		Connection con = DriverManager.getConnection(url, user, pass);
		
		//Creating statement
		Statement stmt = con.createStatement();
		
		//getting the number of Rows
	    String query = "select count(*) from employee";
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		int numberOfRows = rs.getInt(1);
		System.out.println("numberOfRows");
	    System.out.println(numberOfRows);
		Employee[] employees = new Employee[numberOfRows];
		
		//getting full employees details
		query = "select * from employee";
		rs = stmt.executeQuery(query);
		
		//mapping employee table to employee class
		int index = 0;
		while(rs.next()) {

			String name = rs.getString(1);
			String signum = rs.getString(2);
			Employee e = new Employee(name,signum);
			employees[index] = e;
			index++;
		}
		
		con.close();
		return employees;

	}
	
	
	public Leave[] getEmployeeLeaves(String signum) throws ClassNotFoundException, SQLException {
		//Connection to Db
		load();
		Connection con = DriverManager.getConnection(url, user, pass);
		
		//Creating statement
		Statement stmt = con.createStatement();
		
		//getting the number of Rows
	    String query = "select count(*) from emp_leaves where signum in (\""+signum+"\")";
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		int numberOfRows = rs.getInt(1);
		
		//getting the empName
		query = "select name from employee where signumid in (\""+signum+"\")";
		 rs = stmt.executeQuery(query);
		 rs.next();
		 String name = rs.getString(1);
		
		//getting the emp leaves list
		 query = "select * from emp_leaves where signum in (\""+signum+"\")";
		 rs = stmt.executeQuery(query);
		 
		 //creating the leaveslist
		 Leave[] empLeaves = new Leave[numberOfRows];
		 int index = 0;
		 while(rs.next()) {
			  empLeaves[index] = new Leave(rs.getString(1),rs.getDate(2).toString(),rs.getString(3),name);
			  index++;
		 }
		 con.close();
		return empLeaves;
		
	}
	
	public Leave[] addLeave(Leave leave) throws ClassNotFoundException, SQLException {
		load();
		Connection con = DriverManager.getConnection(url, user, pass);
		
		//Creating statement
		String query = "insert into emp_leaves values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, leave.signum);
		ps.setDate(2,Date.valueOf(leave.date));
		ps.setString(3, leave.type);
		
		ps.executeUpdate();
		
		return getEmployeeLeaves(leave.signum);
		
		
	}
	
	public Employee getEmployeDetails(String signum) throws ClassNotFoundException, SQLException {
		load();
		Connection con = DriverManager.getConnection(url, user, pass);
		//Creating statement
		Statement stmt = con.createStatement();
		
		//getting the number of Rows
		String query = "select * from employee where signumid in (\""+signum+"\")";
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		return new Employee(rs.getString(2),rs.getString(1));
	}
	
	

}
