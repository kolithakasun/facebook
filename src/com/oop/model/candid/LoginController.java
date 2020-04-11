package com.oop.model.candid;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	String s1;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("email");
		String pw=request.getParameter("pass");
		System.out.println(un);
		System.out.println(pw);
		// Connect to mysql and verify username password
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/itp", "root", ""); // gets a new connection
		PreparedStatement ps2 = c.prepareStatement("create table login( userName varchar(50), pass varchar(50), primary key (userName))");
		PreparedStatement ps3 = c.prepareStatement("INSERT INTO login (userName, pass) VALUES (?,?)");
		ps3.setString(1, un);
		ps3.setString(2, pw);
		//PreparedStatement ps4 = c.prepareStatement("INSERT INTO login (userName, pass) VALUES ('dmkk', 'dmkk')");
		
		//ResultSet rs1 = ps2.executeQuery();
		//ResultSet rs2 = ps2.executeQuery();
		ResultSet rs3 = ps3.executeQuery();
		//ResultSet rs4 = ps4.executeQuery();
		response.sendRedirect("index.jsp");
		
		/*
		PreparedStatement ps = c.prepareStatement("select email,password,customerid from customer where email=? and password=?");
		PreparedStatement ps1 = c.prepareStatement("select customerid from customer where email=? and password=?");
		ps.setString(1, un);
		ps.setString(2, pw);
		ps1.setString(1, un);
		ps1.setString(2, pw);
		Customer customer = new Customer();
		ResultSet rs = ps.executeQuery();
		ResultSet rs1 = ps1.executeQuery();
	
		
		while (rs1.next()) {
			System.out.println(rs1.getString(1));
			customer.setCustomerID(rs1.getString(1));
			s1 = rs1.getString(1);
			continue;
		}
 
		
		while (rs.next()) {
			request.setAttribute("customer", customer);
			request.setAttribute("s1", s1);
			//response.sendRedirect("MyProfile.jsp");
			if(!un.equalsIgnoreCase("admin")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			else
			request.getRequestDispatcher("adminview.jsp").forward(request, response);	
			return;
		}*/
		
		
		//response.sendRedirect("/index.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
