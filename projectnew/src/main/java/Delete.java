

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
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			Entity e1= new Entity("bus",1);
			e1.setProperty("BusName", "SRM travels");
			e1.setProperty("From", "Chennai");
			e1.setProperty("To","Salem");
			e1.setProperty("Seats", "24");
			datastore.put(e1);
		PrintWriter out = response.getWriter();
	     
		 try {
				request.getRequestDispatcher("menu.html").include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		 
		 String from=request.getParameter("from");
		 String to=request.getParameter("to");
		 String bus=request.getParameter("bus");
		
		Query q =new Query("bus").addFilter("From",FilterOperator.EQUAL, from)
				.addFilter("To",FilterOperator.EQUAL, to)
				.addFilter("BusName",FilterOperator.EQUAL, bus);
		 PreparedQuery pq = datastore.prepare(q);

		   for (Entity result : pq.asIterable()) {
		    	
			   Key key = result.getKey();
			   //out.print(key);
			   if(key!=null) {   
		      datastore.delete(key);
		   out.print("Bus is deleted");
		   
		   }	
			   else {
				   
			   out.print("Bus not present");
		   }
	}
		 //  out.print("Bus not present");
	}
}
