

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Travel")
public class Travel extends HttpServlet {
	static String bus;
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();
	     
		 try {
				request.getRequestDispatcher("Busmenu.html").include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		  bus=request.getParameter("travels");
		 out.println("<h3>Welcome "+bus+" !!!</h3>");
	}
	
}
