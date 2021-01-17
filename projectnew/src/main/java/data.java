

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@WebServlet("/data")
public class data extends HttpServlet {
	
	static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	public static void Data() {
		
		Entity e= new Entity("bus",1);
		e.setProperty("BusName", "SRM travels");
		e.setProperty("From", "Chennai");
		e.setProperty("To","Salem");
		e.setProperty("Seats", "25");
		datastore.put(e);
		
		Entity e2 = new Entity("customer",2);
		e2.setProperty("BusName", "SRM travels");
		e2.setProperty("From", "Chennai");
		e2.setProperty("To","Salem");
		e2.setProperty("Name", "Archana");
		e2.setProperty("Age", "22");
		datastore.put(e2);
	}
	}


