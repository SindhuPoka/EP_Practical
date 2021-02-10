

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginInsert
 */
public class LoginInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("pswd");
		PrintWriter pw=response.getWriter();
		
		try {
			Connection con=DBUtil.DBConnection();
			PreparedStatement ps=con.prepareStatement("select * from register where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			String email1,passwd1;
			
			if(rs.next()) {
				email1=rs.getString("email");
				passwd1 = rs.getString("password");
				if(email.equals(email1) && password.equals(passwd1)) {
					RequestDispatcher rd=request.getRequestDispatcher("feedback.html");
					rd.forward(request, response);
				}
				else {
					pw.write("Invalid Credentials");
				}
				con.close();
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    }
	}
	}

	
	


