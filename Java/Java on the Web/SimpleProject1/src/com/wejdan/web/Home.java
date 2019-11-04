package com.wejdan.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String fav = request.getParameter("fav");
		String town = request.getParameter("town");
		
		if(town == null) {
			town = "unknown";
		}
		if(firstName == null) {
			firstName = "unknown";
			
		}
		if(lastName == null) {
			lastName = "unknown";
			
		}
		if(fav == null) {
			fav = "unknown";
			
		}
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>Welcome, " + firstName +" " +lastName+ "</h1>");
        out.write("<p>Your favorite language is:"+ fav+ "</p>");
        out.write("<p>Your hometown is:"+ town+ "</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
