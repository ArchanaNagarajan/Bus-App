
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
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String from,to;
	//static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("menu.html").include(request, response);
		 from =request.getParameter("from");
		 to = request.getParameter("to");
		
		Query q =new Query("bus").addFilter("From",FilterOperator.EQUAL, from)
				.addFilter("To", FilterOperator.EQUAL, to);
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
	      //out.println("Travels Name: ");  
}
}