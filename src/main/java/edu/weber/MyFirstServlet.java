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
import edu.weber.service.ContactService;

@WebServlet(name="MyFirstServlet", urlPatterns="/")
public class MyFirstServlet extends HttpServlet
{

	private ContactService contactService;
	
	public MyFirstServlet() {
		this.contactService = new ContactService();
	}
	
	public MyFirstServlet(ContactService contactService) {
		this.contactService = contactService;
	}
	
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
		homeAddress.setType("Home");
	
		businessAddress = new Address(
				req.getParameter("businessAddressLine1"),
				req.getParameter("businessAddressLine2"),
				req.getParameter("businessCity"),
				req.getParameter("businessState"),
				req.getParameter("businessZipCode"),
				req.getParameter("businessCountry")
				);
		businessAddress.setType("Business");
		
		
	
		HashMap<String, String> missedForms = validateFormInformation(firstName, lastName, phoneNumber, homeAddress, businessAddress);
		
		if(missedForms.get("MissedAny").equals("false")) {
			List<Address> addresses = new ArrayList<Address>();
			if(!homeAddress.getCity().equals("")) {
				addresses.add(homeAddress);
			}
			if(!businessAddress.getCity().equals("")) {
				addresses.add(businessAddress);
			}
			Contact contact = new Contact(
					firstName,
					lastName,
					phoneNumber,
					addresses
					);
			
			List<Contact> contacts = contactService.getContacts();
			boolean containsContact = false;
			for(Contact c: contacts) {
				if(c.equals(contact))
					containsContact = true;
			}
			if(!containsContact) {
				contactService.recordContact(contact);
			}
			
			
		}else {
			req.setAttribute("missedForms", missedForms);
		}
		
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contact> contacts = contactService.getContacts();
		
		req.setAttribute("contacts", contacts);
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
	}
    
	protected HashMap<String, String> validateFormInformation(String firstName, String lastName, String phoneNumber, Address homeAddress, Address businessAddress) {
		HashMap<String, String> missedForms = new HashMap<String, String>();
		missedForms.put("MissedAny", "false");
		
		if(firstName.equals("")) {
			missedForms.put("firstName", "First Name is required");
			missedForms.put("MissedAny", "true");
		}
		if(lastName.equals("")) {
			missedForms.put("lastName", "Last Name is required");
			missedForms.put("MissedAny", "true");
		}
		if(phoneNumber.equals("")) {
			missedForms.put("phoneNumber", "Phone Number is required");
			missedForms.put("MissedAny", "true");
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
			missedForms.put("MissedAny", "true");
		}
		
		return missedForms;
	}
}
