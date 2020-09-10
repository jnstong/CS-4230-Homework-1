package edu.weber.dao;

import edu.weber.model.Address;
import edu.weber.model.Contact;
import java.util.*;

public class ContactDAO {
	public List<Contact> getContacts(){
		return null;
	}
	
	public Contact getContactByFirstName(String firstName) {
		Contact response = null;
		if(firstName.equalsIgnoreCase("jordan")) {
			response = new Contact(
					"Jordan",
					"Stong",
					"555-123-4567",
					new Address(
							"123",
							"Main Street",
							"Clearfield",
							"Utah",
							"84015",
							"USA"
							),
					new Address()
					);
		}else {
			response = new Contact(
					"Bob",
					"Loblaw",
					"555-123-4567",
					new Address(
							"123",
							"Main Street",
							"Clearfield",
							"Utah",
							"84015",
							"USA"
							),
					new Address()
					);
		}
		
		return response;
	}
	
}
