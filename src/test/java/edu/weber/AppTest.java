package edu.weber;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import edu.weber.dao.ContactDAO;
import edu.weber.model.Address;
import edu.weber.model.Contact;
import edu.weber.service.ContactService;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest 
{
    
    @Test
    public void shouldReturnContactWithFirstNameOfJordan()
    {
    	ContactDAO contactDAO = Mockito.mock(ContactDAO.class);
    	Mockito.when(contactDAO.getContactByFirstName("")).thenReturn(createContact());
    	
    	ContactService contactService = new ContactService();
    	contactService.setContactDAO(contactDAO);
       
    	Contact contact = contactService.getContactByFirstName("");
       
    	assertTrue("Jordan".equalsIgnoreCase(contact.getFirstName()));
    }
    
    @Test
    public void testThatValidationCatchesWhenAFieldIsMission() {
    	MyFirstServlet servlet = new MyFirstServlet();
    	HashMap<String, String> missedForms = servlet.validateFormInformation("", "Test", "Test", new Address("","","","","",""), new Address("","","","","",""));
    	assertTrue(!missedForms.isEmpty());
    }
    
	/*
	 * @Test public void testThatPostAddsContact() throws ServletException,
	 * IOException { MyFirstServlet firstServlet = new MyFirstServlet();
	 * HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
	 * Mockito.when(mockedRequest.getParameter(ArgumentMatchers.anyString())).
	 * thenReturn("Test");
	 * 
	 * HttpServletResponse mockedResponse = Mockito.mock(HttpServletResponse.class);
	 * 
	 * firstServlet.doPost(mockedRequest, mockedResponse);
	 * 
	 * 
	 * 
	 * }
	 */
    
    private Contact createContact() {
    	return new Contact(
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
				
    }
}
