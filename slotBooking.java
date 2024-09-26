package Thar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class slotBooking
 */
@WebServlet("/slotBooking")
public class slotBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public slotBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String name=request.getParameter("name");
		System.out.println(name);
		String phoneno=request.getParameter("phoneno");
		String email=request.getParameter("email");
	
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String brand=request.getParameter("model");
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tharstdio","root","12345");
			Statement stmt=con.createStatement();
//			
//			String query="Select * from kachra where Email_Id='"+email +"' "; /*and Address='"+address+ "'*/
//			ResultSet rs=stmt.executeQuery(query);
//			if(rs.next()==true)
//			{
//				response.sendRedirect("already_Registered.html");
//			}
//			
//			
//			else
//			{
		
				String qry="insert into slotbooking values (?,?,?,?,?,?)";		
				PreparedStatement ps=con.prepareStatement(qry);
				
				ps.setString(1, name);
				ps.setString(2, phoneno);
				ps.setString(3, email);
				
				
				
				ps.setString(4, date);
				ps.setString(5, time);
				ps.setString(6,brand );				
				ps.executeUpdate();
				ps.close();
				con.close();
				
				response.sendRedirect("feedback_Error.html");
			
		} 
		catch (Exception e) {
			out.println(e);
		}

		
    }
}
