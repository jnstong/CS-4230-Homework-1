package edu.weber;



import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.weber.model.Address;
import edu.weber.model.Contact;

@WebServlet(name="MyFirstServlet", urlPatterns="/")
public class MyFirstServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contact contact = new Contact(
				"Jordan", 
				"Stong", 
				new Address("1000", "Main St.", "Town", "State", "5555", "USA"), 
				"555-123-4567");
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact);
		
		contact = new Contact(
				"Bob", 
				"Loblaw", 
				new Address("1000", "Main St.", "Town", "State", "5555", "USA"), 
				"555-123-4567");
		contacts.add(contact);
		
		
		req.setAttribute("contacts", contacts);
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
	}
    
}
