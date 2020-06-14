package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.RegisterDao;
import com.model.Register;

/**
 * Servlet implementation class DisplayController
 */
@WebServlet("/DisplayController")
public class DisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterDao db=new RegisterDao();
		List<Register> lst=db.getAllData();
		PrintWriter pw=response.getWriter();
		
		pw.println("<h2>Details of All User</h2>");
		pw.print("<table border="+3+"+>");
		pw.println("<tr><td>"+"Regno"+"</td><td>"+"First Name"+"</td><td>"+
				"Last Name"+"</td><td>"+"Username"+"</td><td>"+"Password"+"</td><tr>");
		for(Register r:lst)
		{
			pw.print("<tr><td>"+r.getRno()+"</td><td>"+r.getFname()+"</td><td>"+
					r.getLname()+"</td><td>"+r.getUname()+"</td><td>"+r.getPass()+"</td><tr>");
		}
		pw.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
