

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackInsert
 */
public class FeedbackInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackInsert() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Q1=request.getParameter("user1");
		String Q2=request.getParameter("user2");
		String Q3=request.getParameter("user3");
		String Q4=request.getParameter("user4");
		String Q5=request.getParameter("user5");
		FeedbackBean fb=new FeedbackBean();
		fb.setQ1(Q1);
		fb.setQ2(Q2);
		fb.setQ3(Q3);
		fb.setQ4(Q4);
		fb.setQ5(Q5);
		FeedbackDAO dao=new FeedbackDAO();
		try {
			 int i=dao.FeedbackInsert(fb);
			 if(i>0) {
				 RequestDispatcher rd=request.getRequestDispatcher("FeedbackDisplay");
			     request.setAttribute("feedbackbean", fb);
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
	}

}
