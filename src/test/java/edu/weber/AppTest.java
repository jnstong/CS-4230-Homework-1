package edu.weber;

import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.junit.runner.RunWith;
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
