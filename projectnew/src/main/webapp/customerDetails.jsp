<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
<h3>Enter your details</h3>
 
<%  int i =0;
    int num ;
    String number = request.getParameter("seat");
    
    num = Integer.parseInt(number);
   // out.print(num);
   
    session.setAttribute("seat",num);
    
    for( i=1;i<=num;i++){
    	out.print("Passenger "+i+"<br><br/>");
    	%>
	
	<form action="Details">
	Name <input type="text" name="name"><br><br/>
	Age <input type="text" name="age"><br><br/>
	<input type="submit" value="Submit"> 
    <input type="reset" value="Reset">
	<% } %>
	
	</form>
</body>
</html>