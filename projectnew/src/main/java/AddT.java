

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;

@WebServlet("/AddT")
public class AddT extends HttpServlet {
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
		 String seats=request.getParameter("seat");
		// String bus=request.getParameter("bus");
   
		 Entity ent = new Entity("bus");
		 ent.setProperty("BusName", Travel.bus);
		 ent.setProperty("From", from);
		 ent.setProperty("To" , to);
		 ent.setProperty("Seats", seats);
		 data.datastore.put(ent);
		 
		 out.println("Travels Name: "+Travel.bus +"<br>");
	        out.println("From: "+ from + " To " + to + "<br>" );
	        out.print("Seats: "+seats+"<br><br/>");
	}

}
