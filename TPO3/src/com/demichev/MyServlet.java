package com.demichev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String mistake = "<br><br/><a href='/TPO3/'><input type='button' value='Retry' /></a>";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
        {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        int a1= Integer.parseInt(request.getParameter("n1"));
        int a2= Integer.parseInt(request.getParameter("n2"));
        
            out.println("<h1>Result</h1>"+(a1+a2));
        }
        catch(Exception e)
        {
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
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        int a1= Integer.parseInt(request.getParameter("n3"));
        int a2= Integer.parseInt(request.getParameter("n4"));
        
            out.println("<h1>Result</h1>"+(a1+a2));
        }
        catch(Exception e)
        {
        	PrintWriter out= response.getWriter();
        	out.println("This is not an integer");
            out.println(mistake);
        }
	}

}
