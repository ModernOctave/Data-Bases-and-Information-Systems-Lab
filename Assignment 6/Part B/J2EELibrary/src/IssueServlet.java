


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public IssueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
		//getting input values from jsp page
		String student_id = request.getParameter("student_id");
		String book_id = request.getParameter("book_id");
		String issue_date = request.getParameter("issue_date");

		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/library"; //MySQL URL and followed by the database name
 		String username = "root"; //MySQL username
 		String password = "om123"; //MySQL password
		
 		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);
 		
 		//Check if book id already exists
 		PreparedStatement st0 = con.prepareStatement("select * from student where student_id=?");
 		st0.setString(1,student_id);
 		ResultSet rset = st0.executeQuery();
		int count=0;
		while(rset.next()) {
			++count;
		}

		if(count>0)
		{
			//Inserting values into the table
			PreparedStatement st = con.prepareStatement("insert into issue values(?,?,?,?)");
			st.setString(1,student_id);
			st.setString(2,book_id);
			st.setString(3,issue_date);
			st.setNull(4,java.sql.Types.DATE);
			int i = st.executeUpdate();
			if(i>0)
			{
				System.out.println("Book is issued successfully");
				RequestDispatcher rd = request.getRequestDispatcher("IssueResult.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Could not issue book");
				RequestDispatcher rd = request.getRequestDispatcher("IssueFailure.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			System.out.println("Student ID does not exists");
			RequestDispatcher rd = request.getRequestDispatcher("IssueFailure.jsp");
			rd.forward(request, response);
		}
		}
		catch(Exception se)
		{
			se.printStackTrace();
		}
	}
}


