
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

@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
   int values;
   int value;
   String BusName,From,To;
  static String name, age;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException,NumberFormatException {
		
		  PrintWriter out = response.getWriter();
		 
		  out.print("<h3 style=\"text-align:center\">TICKET INFORMATION</h3>");

		  Entity enti = new Entity("customer");
		  enti.setProperty("BusName", ViewC.BusName);
			enti.setProperty("From", ViewC.From);
			enti.setProperty("To",ViewC.To);
			
		  values =  (int) request.getSession().getAttribute("seat");
		 
		  int seat = values;
		 
				name = request.getParameter("name");
				 age=request.getParameter("age");
			 
			 enti.setProperty("Name", name);
			  enti.setProperty("Age", age);
		     data.datastore.put(enti);
		 
		     Query q =new Query("customer").addFilter("Name",FilterOperator.EQUAL, name)
		    		 .addFilter("Age",FilterOperator.EQUAL, age);
			 PreparedQuery pq = data.datastore.prepare(q);

		      for (Entity result : pq.asIterable()) {
		         BusName = (String) result.getProperty("BusName");
		         From = (String) result.getProperty("From");
		         To = (String) result.getProperty("To");
		     
		        out.println("Travels Name: "+BusName +"<br>");
		        out.println("From: "+ From + "<br> To : " + To + "<br>" );
		       
		        String Name  = (String)result.getProperty("Name");
		        String Age = (String)result.getProperty("Age");
		      
		        out.print("NAME : "+Name+"<br>");
		        out.print("AGE : "+Age+"<br>");
		       		      
}
		        Query q1 =new Query("bus").addFilter("BusName", FilterOperator.EQUAL, BusName)
		        		.addFilter("From",FilterOperator.EQUAL, From)
						.addFilter("To", FilterOperator.EQUAL, To);
				 PreparedQuery pq1 = data.datastore.prepare(q1);
		        
				 for(Entity seats : pq1.asIterable()) {
					
					 Object seatVal =  seats.getProperty("Seats");
					 String seatss =  seatVal.toString();
					 value = Integer.parseInt(seatss);
				 value = value - seat;
					
					 seats.setProperty("Seats", value);
					 data.datastore.put(seats);
					 
				 }
				 out.print("<form action =\"/main.html\"><input type=\"submit\" value=\"Logout\"></form>" );
		      }
	}


