


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
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
		//getting input values from jsp page
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String author = request.getParameter("author");


		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/library"; //MySQL URL and followed by the database name
 		String username = "root"; //MySQL username
 		String password = "om123"; //MySQL password
		
 		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);
 		
 		//Check if book id already exists
 		PreparedStatement st0 = con.prepareStatement("select * from book where book_id=?");
 		st0.setString(1,id);
 		ResultSet rset = st0.executeQuery();
		int count=0;
		while(rset.next()) {
			++count;
		}

		if(count==0)
		{
			//Inserting values into the table
			PreparedStatement st = con.prepareStatement("insert into book values(?,?,?,?)");
			st.setString(1,id);
			st.setString(2,title);
			st.setString(3,category);
			st.setString(4,author);
			int i = st.executeUpdate();
			if(i>0)
			{
				System.out.println("Book is added successfully");
				RequestDispatcher rd = request.getRequestDispatcher("AddResult.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Book could not be added");
				RequestDispatcher rd = request.getRequestDispatcher("AddFailure.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			System.out.println("Book id already exists");
			RequestDispatcher rd = request.getRequestDispatcher("AddFailure.jsp");
			rd.forward(request, response);
		}
		}
		catch(Exception se)
		{
			se.printStackTrace();
		}
	}
}


