import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin")
public class Admin extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    PrintWriter out = response.getWriter();
    
    request.getRequestDispatcher("menu.html").include(request, response);
    
    out.print("<h2>Welcome to the page ADMIN!!!</h2>");

   
  }
}