package com.demichev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Exception button for retry
	private String mistake = "<br><br/><a href='/TPO3/'><input type='button' value='Retry' /></a>";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


  		try
  		{
  			//set response like html page
  			response.setContentType("text/html");

  			PrintWriter out= response.getWriter();

  			//Parsing integers
  			int a1= Integer.parseInt(request.getParameter("n1"));
  			int a2= Integer.parseInt(request.getParameter("n2"));

  			int res = a1 + a2;
  			
  			request.setAttribute("res",res);
  			

  			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
  			rd.forward(request, response);
  		}
  		catch(Exception e)
  		{
  			//if we catch not integer exception, show massage and button for retry
  			PrintWriter out= response.getWriter();
  			out.println("This is not an integer");
  			out.println(mistake);
  		}
  	}

  	/**
  	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		try
  		{
  			//set response like html page
  			response.setContentType("text/html");
  			PrintWriter out= response.getWriter();

  			//Parsing integers (adding to integers a1 and a2)
  			int a1= Integer.parseInt(request.getParameter("n3"));
  			int a2= Integer.parseInt(request.getParameter("n4"));

  			//out.println("<h1>Result</h1>"+(a1+a2));
  			
  			int res = a1 + a2;
  			
  			request.setAttribute("res2",res);
  			

  			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
  			rd.forward(request, response);
  		}
  		catch(Exception e)
  		{
  			//if we catch not integer exception, show massage and button for retry
  			PrintWriter out= response.getWriter();
  			out.println("This is not an integer");
  			out.println(mistake);
  		}
  	}

  }
