

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

/**
 * Servlet implementation class ViewBus
 */
@WebServlet("/ViewBus")
public class ViewBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	static String From , To ,BusName,bus;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException,ClassCastException {
		
		PrintWriter out = response.getWriter();

		
		request.getRequestDispatcher("menu.html").include(request, response);
         bus =request.getParameter("bus");
        //String to = request.getParameter("to");

       Query q =new Query("bus").addFilter("BusName",FilterOperator.EQUAL, bus);
		//.addFilter("To", FilterOperator.EQUAL, to);
      PreparedQuery pq = data.datastore.prepare(q);
 

       for (Entity result : pq.asIterable()) {
    	   
      From = (String) result.getProperty("From");
        To = (String) result.getProperty("To");
       BusName = (String) result.getProperty("BusName");
      Object Seat= result.getProperty("Seats");
    
      out.println("Travels Name: "+BusName +"<br>");
      out.println("From: "+ From + " To: " + To + "<br>" );
      out.print("Seats: "+Seat+"<br><br/>");
      //request.getRequestDispatcher("Seat.html").include(request, response);
  }	
	
	
	}
}
