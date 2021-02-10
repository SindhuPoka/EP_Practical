

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackDisplay
 */
public class FeedbackDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FeedbackBean fb=(FeedbackBean)request.getAttribute("feedbackbean");
		PrintWriter pw=response.getWriter();
		pw.print("Your Feedback is : "+"\nQ1: "+fb.getQ1()+"\nQ2: "+fb.getQ2()+"\nQ3: "+fb.getQ3()+"\nQ4: "+fb.getQ4()+"\nQ5: "+fb.getQ5());
	}

}
