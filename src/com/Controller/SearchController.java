package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.RegisterDao;
import com.model.Register;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int regno=Integer.parseInt(request.getParameter("rno"));
		String pass=request.getParameter("pass");
		
		RegisterDao db=new RegisterDao();
		List<Register> lst=db.search(regno,pass);
		
		PrintWriter pw=response.getWriter();
		
		Register r=lst.get(0);
		pw.println("<h2>Details of Search User</h2>");
		pw.println("<table border="+3+"align :"+"center"+"+>");
		pw.println("<tr><td>"+"Regno"+"</td><td>"+"First Name"+"</td><td>"
				+"Last Name"+"</td><td>"+"Username"+"</td><td>"+"Password"+"</td><tr>");
		pw.println("<tr><td>"+r.getRno()+"</td><td>"+r.getFname()+"</td><td>"
				+r.getLname()+"</td><td>"+r.getUname()+"</td><td>"+r.getPass()+"</td><tr>");
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
