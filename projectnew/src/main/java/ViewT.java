

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


@WebServlet("/ViewT")
public class ViewT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
       PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("Busmenu.html").include(request, response);
		String from =request.getParameter("from");
		String to = request.getParameter("to");
		
		Query q =new Query("bus").addFilter("From",FilterOperator.EQUAL, from)
				.addFilter("To", FilterOperator.EQUAL, to)
				.addFilter("BusName", FilterOperator.EQUAL, Travel.bus);
		 PreparedQuery pq = data.datastore.prepare(q);
		 

	      for (Entity result : pq.asIterable()) {
	        String From = (String) result.getProperty("From");
	        String To = (String) result.getProperty("To");
	        String BusName = (String) result.getProperty("BusName");
	        Object Seat= result.getProperty("Seats");
	        
	        out.println("Travels Name: "+BusName +"<br>");
	        out.println("From: "+ From + " To " + To + "<br>" );
	        out.print("Seats: "+Seat+"<br>");
	        
	        out.print("<br><br/>");
	      }	
		
	}

}
