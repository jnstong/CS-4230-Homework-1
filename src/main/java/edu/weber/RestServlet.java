package edu.weber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.weber.model.Address;
import edu.weber.model.Contact;

@WebServlet(name="RestServlet", urlPatterns="/rest")
public class RestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		Contact contact = new Contact(
				"Jordan", 
				"Stong", 
				new Address("1000", "Main St.", "Town", "State", "5555", "USA"), 
				"555-123-4567");
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(contact));
        out.flush();
	}
	
	
	

}
