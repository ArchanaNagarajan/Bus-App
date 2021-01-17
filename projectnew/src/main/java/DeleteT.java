

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

@WebServlet("/DeleteT")
public class DeleteT extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	     
		 try {
				request.getRequestDispatcher("Busmenu.html").include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		 
		 String from=request.getParameter("from");
		 String to=request.getParameter("to");
		
		Query q =new Query("bus").addFilter("From",FilterOperator.EQUAL, from)
				.addFilter("To",FilterOperator.EQUAL, to)
				.addFilter("BusName",FilterOperator.EQUAL, Travel.bus);
		 PreparedQuery pq = data.datastore.prepare(q);

		   for (Entity result : pq.asIterable()) {
		    	
			   Key key = result.getKey();
			   //out.print(key);
			   if(key!=null) {   
		      data.datastore.delete(key);
		   out.print("Bus route is deleted");
		   
		   }	
			   else {
				   
			   out.print("Bus route is not present");
		   }
	}
	}

}
