package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Delete;
import com.model.Login;
import com.model.Register;

public class RegisterDao 
{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public RegisterDao() 
	{
		
	}
	public Connection getConnection()
	{
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	public int Savedata(List<Register> lst)
	{
		con=getConnection();
		int cnt=0;
		Register r=lst.get(0);
		int i=0;
		
		try {
			ps=con.prepareStatement("insert into BusReservation values(?,?,?,?,?)");
			ps.setInt(1, r.getRno());
			ps.setString(2, r.getFname());
			ps.setString(3,r.getLname());
			ps.setString(4, r.getUname());
			ps.setString(5, r.getPass());
			i=ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if(i>0)
		{
			cnt=1;
		}
		return cnt;
		
	}
	public int Validatedata(List<Login> lst)
	{
		con=getConnection();
		int cnt=0;
		Login l=lst.get(0);
		int i=0;
		
		try {
			ps=con.prepareStatement("select * from BusReservation where username=? and password=?");
			ps.setString(1, l.getUname());
			ps.setString(2, l.getPass());
			rs=ps.executeQuery();
			if(rs.next())
			{
				i=1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0)
		{
			cnt=1;
		}
		return cnt;
		
	}
	public int Deletedata(List<Delete> lst)
	{
		con=getConnection();
		int cnt=0;
		Delete d=lst.get(0);
		int i=0;
		
		try 
		{
			ps=con.prepareStatement("delete from BusReservation where regno=? and password=?");
			ps.setInt(1, d.getRno());
			ps.setString(2, d.getPass());
			i=ps.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if(i>0)
		{
			cnt=1;
		}
		return cnt;	
	}
	public List<Register> getAllData()
	{
		List<Register> lst=new ArrayList<Register>();
		con=getConnection();
		try
		{
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from BusReservation");
			while(rs.next())
			{
				Register a=new Register();
				a.setRno(rs.getInt(1));
				a.setFname(rs.getString(2));
				a.setLname(rs.getString(3));
			    a.setUname(rs.getString(4));
			    a.setPass(rs.getString(5));
				lst.add(a);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	public List<Register> search(int rno,String pass)
	{
		List<Register> lst=new ArrayList<Register>();
		con=getConnection();
		try
		{
			ps=con.prepareStatement("select * from BusReservation where regno=? and password=?");
			ps.setInt(1, rno);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			Register a=new Register();
			if(rs.next())
			{	
				a.setRno(rs.getInt(1));
				a.setFname(rs.getString(2));
				a.setLname(rs.getString(3));
			    a.setUname(rs.getString(4));
			    a.setPass(rs.getString(5));
			}    
			lst.add(a);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
}
