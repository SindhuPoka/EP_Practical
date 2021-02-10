

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterInsert
 */
public class RegisterInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regno=Integer.parseInt(request.getParameter("regno"));//string
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password= request.getParameter("pswd");
		 RegisterBean sb= new RegisterBean();
		 sb.setRegno(regno);
		 sb.setName(name);
		 sb.setEmail(email);
		 sb.setPassword(password);
		// PrintWriter pw=response.getWriter();
		 //pw.print( "Welcome "+ regno+"  "+name+" "+email+" "+password);
		 RegisterDAO dao= new RegisterDAO();
			try {
				 int i=dao.RegisterInsert(sb);
				 if(i>0) {
					 RequestDispatcher rd=request.getRequestDispatcher("RegisterDisplay");
				     request.setAttribute("registerbean", sb);
				     rd.forward(request, response);
				 }
				 else {
					 RequestDispatcher rd=request.getRequestDispatcher("error.html");
				     rd.include(request, response);
				 }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(NumberFormatException ex){ 
				ex.printStackTrace();
			}
		
	}

}
