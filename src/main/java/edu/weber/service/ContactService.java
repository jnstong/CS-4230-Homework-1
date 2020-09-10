package edu.weber.service;

import java.util.List;

import edu.weber.dao.ContactDAO;
import edu.weber.model.Contact;

public class ContactService {
	private ContactDAO contactDAO = null;
	
	public ContactService() {
		this.contactDAO = new ContactDAO();
	}

	public List<Contact> getContacts(){
		return null;
	}
	
	public Contact getContactByFirstName(String firstName) {
		
		return contactDAO.getContactByFirstName(firstName);
	}
	
	public ContactDAO getContactDAO() {
		return contactDAO;
	}

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
}
