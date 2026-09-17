package com.example;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SendCookiesDemo extends HttpServlet {
	 @Override
	    protected void doGet(HttpServletRequest request,
	                          HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");

	        PrintWriter out = response.getWriter();
	        Cookie ck1= new Cookie("username","MCAvit2026");
	        Cookie ck2= new Cookie("userID","TestGmail");
	        response.addCookie(ck1);
	        response.addCookie(ck2);
	        out.println("<h1>Cookies sent from Server</h1>");
	        out.println("<p>This Servlet is running using Maven and Tomcat.</p>");
	    }

}
