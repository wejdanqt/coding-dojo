package com.codingdojo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GreatNumber
 */
@WebServlet("/GreatNumber")
public class GreatNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreatNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    int rand = (int) Math.floor( Math.random() * 100 + 1);

    
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   

	    
	   
		HttpSession session = request.getSession();
		  int guess = Integer.parseInt(request.getParameter("guess"));
		  session.setAttribute("rand", rand);
		  session.setAttribute("big", false);
		  session.setAttribute("small", false);
		  session.setAttribute("right", false);
		  
		  
		  
		  if(guess > rand ) {
			  System.out.println(rand);
			  System.out.println("Too big");
			  session.setAttribute("big", true);
			  
			  
		  }else if (guess < rand){
			  System.out.println(rand);
			  System.out.println("Too small");
			  session.setAttribute("small", true);
			  
		  }else {
			  System.out.println(rand);
			  System.out.println("Yessss!!");
			  session.setAttribute("right", true);
			  
		  }
		  
	
		  RequestDispatcher view = request.getRequestDispatcher("index.jsp");
	        view.forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
