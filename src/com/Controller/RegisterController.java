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
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("save 1");
		String s1=request.getParameter("rno");
		int no =Integer.parseInt(s1);
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		System.out.println("save 2");
		Register r=new Register();
		r.setRno(no);
		r.setFname(fname);
		r.setLname(lname);
		r.setUname(uname);
		r.setPass(pass);
		System.out.println("save 3");
		List<Register> lst=new ArrayList<Register>();
		lst.add(r);
		System.out.println("save 4");
		RegisterDao rd= new RegisterDao();
		int i=rd.Savedata(lst);

		PrintWriter pw=response.getWriter();

		if(i>0)
		{
			response.sendRedirect("welcome.html");
		}	
		else
		{	
			response.sendRedirect("Register.html");
			pw.print("Registration number already exist!!");
		}	
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
