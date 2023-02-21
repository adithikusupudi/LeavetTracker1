import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@WebServlet("/home")
public class Home extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String title = "Home";
		req.setAttribute("title", title );
		DatabaseService db = new DatabaseService();
		
		try {
			
			//getting all Emp details
			req.setAttribute("empsDetails", db.getEmployeNames() );
			
			//check if requesting for specific emp details
			if(req.getParameter("selectEmp")!=null)  
			{
				String signum = req.getParameter("selectEmp");
				Employee e = db.getEmployeDetails(signum);
				req.setAttribute("sname", e.getName());
				req.setAttribute("signum", e.getSignum());
				req.setAttribute("empLeaves", db.getEmployeeLeaves(signum));
				
			}
			//check for adding a leave
			else if(req.getParameter("date")!=null) {
				String signum = req.getParameter("signum");
				Employee e = db.getEmployeDetails(signum);
				req.setAttribute("sname", e.getName());
				req.setAttribute("ssignum", e.getSignum());
				
				String date = req.getParameter("date");
				String type = req.getParameter("type");
				String name = req.getParameter("name");
				Leave l = new Leave(signum,date,type,name);
				
				Leave[] leaves = db.addLeave(l);
				req.setAttribute("empLeaves", leaves);
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, res);
	}

}