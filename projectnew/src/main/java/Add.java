

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	     
		 try {
				request.getRequestDispatcher("menu.html").include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		 String from=request.getParameter("from");
		 String to=request.getParameter("to");
		 String seats=request.getParameter("seat");
		 String bus=request.getParameter("bus");
    
		 Entity ent = new Entity("bus");
		 ent.setProperty("BusName", bus);
		 ent.setProperty("From", from);
		 ent.setProperty("To" , to);
		 ent.setProperty("Seats", seats);
		 data.datastore.put(ent);
		 
		 out.println("Travels Name: "+bus +"<br>");
	        out.println("From: "+ from + " To " + to + "<br>" );
	        out.print("Seats: "+seats+"<br><br/>");
       // out.println("Name: "+ n + "<br> Number: " + number + "<br>State: " + state +"<br><br/>" );
  
	}
	}


