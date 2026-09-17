package com.example;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RequestCookiesDemo extends HttpServlet {
	 @Override
	    protected void doGet(HttpServletRequest request,
	                          HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");

	        PrintWriter out = response.getWriter();
	        Cookie ck[]=request.getCookies();
	        for(Cookie c:ck) {
	        	out.println("<h1>"+c.getName()+"</h1>"+":"+"<h1>"+c.getValue()+"</h1>");
	        }
	        
	        
	        
	    }

}
