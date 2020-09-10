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

	private List<Contact> contacts = new ArrayList<Contact>();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contact contact = new Contact(
				req.getParameter("firstName"),
				req.getParameter("lastName"),
				req.getParameter("phoneNumber"),
				new Address(
						req.getParameter("addressLine1"),
						req.getParameter("addressLine2"),
						req.getParameter("city"),
						req.getParameter("state"),
						req.getParameter("zipCode"),
						req.getParameter("country")
						),
				new Address(
						req.getParameter("addressLine1"),
						req.getParameter("addressLine2"),
						req.getParameter("city"),
						req.getParameter("state"),
						req.getParameter("zipCode"),
						req.getParameter("country")
						)
				);
		
		
		
		contacts.add(contact);
		
		
		
		//req.setAttribute("contacts", contacts);
		//req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("contacts", contacts);
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
	}
    
}
