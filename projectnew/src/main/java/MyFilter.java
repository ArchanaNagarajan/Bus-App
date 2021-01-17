import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{  
	  
public void init(FilterConfig arg0) throws ServletException {}  
      
public void doFilter(ServletRequest req, ServletResponse resp,  
        FilterChain chain) throws IOException, ServletException {  
          
    PrintWriter out=resp.getWriter();  
     
    String Id = req.getParameter("id");
    String password=req.getParameter("pwd");  
    if(Id.equals("Archana0801")&&(password.equals("admin@123"))){  
    chain.doFilter(req, resp);  
    }  
    else{  
    out.print("username or password incorrect!");  
    RequestDispatcher rd=req.getRequestDispatcher("Main.html");  
    rd.include(req, resp);  
    }  
          
}  
    public void destroy() {
    	
    }
	}  
   