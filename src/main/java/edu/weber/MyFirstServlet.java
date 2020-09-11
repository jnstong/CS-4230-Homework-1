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

	private static List<Contact> contacts = new ArrayList<Contact>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Address homeAddress = new Address();
		Address businessAddress = new Address();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String phoneNumber = req.getParameter("phoneNumber");
		
	
		homeAddress = new Address(
				req.getParameter("homeAddressLine1"),
				req.getParameter("homeAddressLine2"),
				req.getParameter("homeCity"),
				req.getParameter("homeState"),
				req.getParameter("homeZipCode"),
				req.getParameter("homeCountry")
				);
	
		businessAddress = new Address(
				req.getParameter("businessAddressLine1"),
				req.getParameter("businessAddressLine2"),
				req.getParameter("businessCity"),
				req.getParameter("businessState"),
				req.getParameter("businessZipCode"),
				req.getParameter("businessCountry")
				);
	
		HashMap<String, String> missedForms = validateFormInformation(firstName, lastName, phoneNumber, homeAddress, businessAddress);
		
		if(missedForms.isEmpty()) {
			Contact contact = new Contact(
					firstName,
					lastName,
					phoneNumber,
					homeAddress,
					businessAddress
					);
			
			contacts.add(contact);
		}else {
			req.setAttribute("missedForms", missedForms);
		}
		
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("contacts", contacts);
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
	}
    
	protected HashMap<String, String> validateFormInformation(String firstName, String lastName, String phoneNumber, Address homeAddress, Address businessAddress) {
		HashMap<String, String> missedForms = new HashMap();
		if(firstName.contentEquals("")) {
			missedForms.put("firstName", "First Name is required");
		}
		if(lastName.equals("")) {
			missedForms.put("lastName", "Last Name is required");
		}
		if(phoneNumber.equals("")) {
			missedForms.put("phoneNumber", "Phone Number is required");
		}
		if((homeAddress.getAddressLine1().equals("") ||
				homeAddress.getCity().equals("") ||
				homeAddress.getState().equals("") ||
				homeAddress.getCountry().equals("")
			)&&
			(businessAddress.getAddressLine1().equals("") ||
					businessAddress.getCity().equals("") ||
					businessAddress.getState().equals("") ||
					businessAddress.getCountry().equals(""))) 
		{
			missedForms.put("address", "At least one complete address is required");
		}
		
		return missedForms;
	}
}
