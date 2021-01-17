

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

@WebServlet("/ViewC")
public class ViewC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String From , To ,BusName,Seat =" ";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException,ClassCastException {
		
          PrintWriter out = response.getWriter();
		
		//request.getRequestDispatcher("menu.html").include(request, response);
          out.print("<h1 style=\"color:red;font-family:verdana;text-align:center;\">BUS APPLICATION</h1><hr>");
		String from =request.getParameter("from");
		String to = request.getParameter("to");
		
		Query q =new Query("bus").addFilter("From",FilterOperator.EQUAL, from)
				.addFilter("To", FilterOperator.EQUAL, to);
		 PreparedQuery pq = data.datastore.prepare(q);
		 

	      for (Entity result : pq.asIterable()) {
	         From = (String) result.getProperty("From");
	         To = (String) result.getProperty("To");
	         BusName = (String) result.getProperty("BusName");
	        Object Seat = result.getProperty("Seats");
	        
	        out.println("<br>Travels Name: "+BusName +"<br>");
	        out.println("From: "+ From + " To " + To + "<br>" );
	        out.print("Seats: "+Seat+"<br>");
	        out.print("<form action =\"/Book.html\"><input type=\"submit\" value=\"Book Ticket\"></form>" );
	        out.print("<br><br/>");
	      }	
	}

}
