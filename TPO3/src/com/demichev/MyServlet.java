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


	//Constructor
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


			//Parsing integers and adding them
			int a1= Integer.parseInt(request.getParameter("n1"));
			int a2= Integer.parseInt(request.getParameter("n2"));
			int res = a1 + a2;

			//creating request for passing to servlet
			request.setAttribute("res",res);

			//where to pass request
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			//passing request
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


			//Parsing integers and adding them
			int a1= Integer.parseInt(request.getParameter("n3"));
			int a2= Integer.parseInt(request.getParameter("n4"));
			int res = a1 + a2;

			//creating request for passing to servlet
			request.setAttribute("res2",res);

			//where to pass request
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			
			//passing request
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
