package edu.weber;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
public class AppTest {


	@Test
	public void testThatPostAddsContact() throws ServletException, IOException{
		ContactService contactService = Mockito.mock(ContactService.class);
		
		MyFirstServlet firstServlet = new MyFirstServlet(contactService);
		
		HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
		RequestDispatcher mockedDispatcher = Mockito.mock(RequestDispatcher.class);
		HttpServletResponse mockedResponse = Mockito.mock(HttpServletResponse.class);
		
		Mockito.when(mockedRequest.getParameter("firstName")).thenReturn("Jordan");
		Mockito.when(mockedRequest.getParameter("lastName")).thenReturn("Stong");
		Mockito.when(mockedRequest.getParameter("phoneNumber")).thenReturn("555-555-5555");
		Mockito.when(mockedRequest.getParameter("homeAddressLine1")).thenReturn("123");
		Mockito.when(mockedRequest.getParameter("homeAddressLine2")).thenReturn("Fake st.");
		Mockito.when(mockedRequest.getParameter("homeCity")).thenReturn("Faketown");
		Mockito.when(mockedRequest.getParameter("homeState")).thenReturn("Minnesota");
		Mockito.when(mockedRequest.getParameter("homeZipCode")).thenReturn("12345");
		Mockito.when(mockedRequest.getParameter("homeCountry")).thenReturn("USA"); 
		Mockito.when(mockedRequest.getParameter("businessAddressLine1")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessAddressLine2")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessCity")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessState")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessZipCode")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessCountry")).thenReturn(""); 
		
		Mockito.when(mockedRequest.getRequestDispatcher(ArgumentMatchers.anyString())).thenReturn(mockedDispatcher);
		
		ArgumentCaptor<Contact> captor = ArgumentCaptor.forClass(Contact.class);
		
		firstServlet.doPost(mockedRequest,  mockedResponse);
		
		Mockito.verify(contactService).recordContact(captor.capture());
		Contact contact = captor.getValue();
		Assert.assertEquals("Jordan", contact.getFirstName());
		
	}
	
	@Test 
	public void testThatPostWontAddDuplicateContact() throws ServletException, IOException {
		ContactService contactService = Mockito.mock(ContactService.class);
		
		MyFirstServlet firstServlet = new MyFirstServlet(contactService);
		
		HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
		RequestDispatcher mockedDispatcher = Mockito.mock(RequestDispatcher.class);
		HttpServletResponse mockedResponse = Mockito.mock(HttpServletResponse.class);
		
		Mockito.when(mockedRequest.getParameter("firstName")).thenReturn("Jordan");
		Mockito.when(mockedRequest.getParameter("lastName")).thenReturn("Stong");
		Mockito.when(mockedRequest.getParameter("phoneNumber")).thenReturn("555-555-5555");
		Mockito.when(mockedRequest.getParameter("homeAddressLine1")).thenReturn("123");
		Mockito.when(mockedRequest.getParameter("homeAddressLine2")).thenReturn("Fake st.");
		Mockito.when(mockedRequest.getParameter("homeCity")).thenReturn("Faketown");
		Mockito.when(mockedRequest.getParameter("homeState")).thenReturn("Minnesota");
		Mockito.when(mockedRequest.getParameter("homeZipCode")).thenReturn("12345");
		Mockito.when(mockedRequest.getParameter("homeCountry")).thenReturn("USA"); 
		Mockito.when(mockedRequest.getParameter("businessAddressLine1")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessAddressLine2")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessCity")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessState")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessZipCode")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessCountry")).thenReturn(""); 
		
		Mockito.when(mockedRequest.getRequestDispatcher(ArgumentMatchers.anyString())).thenReturn(mockedDispatcher);
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(createContact());
		Mockito.when(contactService.getContacts()).thenReturn(contacts);
		
		firstServlet.doPost(mockedRequest,  mockedResponse);
		
		Mockito.verify(contactService, Mockito.never()).recordContact(ArgumentMatchers.notNull());
	}
	
	@Test
	public void testThatPostCorrectlyValidatedFormSubmission() throws ServletException, IOException {
		ContactService contactService = Mockito.mock(ContactService.class);
		
		MyFirstServlet firstServlet = new MyFirstServlet(contactService);
		
		HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
		RequestDispatcher mockedDispatcher = Mockito.mock(RequestDispatcher.class);
		HttpServletResponse mockedResponse = Mockito.mock(HttpServletResponse.class);
		
		Mockito.when(mockedRequest.getParameter("firstName")).thenReturn("");  //First Name was left blank
		Mockito.when(mockedRequest.getParameter("lastName")).thenReturn("Stong");
		Mockito.when(mockedRequest.getParameter("phoneNumber")).thenReturn("555-555-5555");
		Mockito.when(mockedRequest.getParameter("homeAddressLine1")).thenReturn("123");
		Mockito.when(mockedRequest.getParameter("homeAddressLine2")).thenReturn("Fake st.");
		Mockito.when(mockedRequest.getParameter("homeCity")).thenReturn("Faketown");
		Mockito.when(mockedRequest.getParameter("homeState")).thenReturn("Minnesota");
		Mockito.when(mockedRequest.getParameter("homeZipCode")).thenReturn("12345");
		Mockito.when(mockedRequest.getParameter("homeCountry")).thenReturn("USA"); 
		Mockito.when(mockedRequest.getParameter("businessAddressLine1")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessAddressLine2")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessCity")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessState")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessZipCode")).thenReturn("");
		Mockito.when(mockedRequest.getParameter("businessCountry")).thenReturn(""); 
		
		Mockito.when(mockedRequest.getRequestDispatcher(ArgumentMatchers.anyString())).thenReturn(mockedDispatcher);
		
		ArgumentCaptor<HashMap> captor = ArgumentCaptor.forClass(HashMap.class);
		
		firstServlet.doPost(mockedRequest,  mockedResponse);
		
		Mockito.verify(mockedRequest).setAttribute(Mockito.eq("missedForms"), captor.capture());;
		HashMap <String, String> missedForms = captor.getValue();
		Assert.assertEquals("true", missedForms.get("MissedAny"));
	}
	
	@Test
	public void testThatGetSetsContactsAttribute() throws ServletException, IOException {
		ContactService contactService = Mockito.mock(ContactService.class);
		
		MyFirstServlet firstServlet = new MyFirstServlet(contactService);
		
		HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
		RequestDispatcher mockedDispatcher = Mockito.mock(RequestDispatcher.class);
		HttpServletResponse mockedResponse = Mockito.mock(HttpServletResponse.class);
		Mockito.when(mockedRequest.getRequestDispatcher(ArgumentMatchers.anyString())).thenReturn(mockedDispatcher);
		
		List<Contact> contacts = new ArrayList<Contact>();
		for(int i=0; i<5; i++) {
			contacts.add(createContact());
		}
		Mockito.when(contactService.getContacts()).thenReturn(contacts);
		
		firstServlet.doGet(mockedRequest, mockedResponse);
		
		ArgumentCaptor<List> captor = ArgumentCaptor.forClass(List.class);
		
		Mockito.verify(mockedRequest).setAttribute(Mockito.eq("contacts"), captor.capture());
		List setContacts = captor.getValue();
		Assert.assertTrue(setContacts.size() == 5);
	}
	 

	@Test
	public void TestThatNewContactIsAddedByDAO() throws SQLException {
		Connection mockDb = Mockito.mock(Connection.class);
		ContactDAO contactDAO = new ContactDAO(mockDb);
		PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
		
		Mockito.when(mockDb.prepareStatement(ArgumentMatchers.anyString())).thenReturn(mockPreparedStatement);
		Contact contact = contactDAO.recordContact(createContact());
		
		Mockito.verify(mockPreparedStatement).executeUpdate();
		Assert.assertNotNull(contact.getId());
	}
	
	@Test
	public void TestThat2AddressCanBeAddedByDAO() throws SQLException {
		Connection mockDb = Mockito.mock(Connection.class);
		ContactDAO contactDAO = new ContactDAO(mockDb);
		PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
		
		Mockito.when(mockDb.prepareStatement(ArgumentMatchers.anyString())).thenReturn(mockPreparedStatement);
		Contact contact = createContact();
		Address address = new Address("456", "Not Real st.", "Faketown", "Minnesota", "12345", "USA");
		address.setType("Business");
		contact.addAddress(address);
		contactDAO.recordContact(contact);
		
		Mockito.verify(mockPreparedStatement, Mockito.times(2)).addBatch();
	}
	
	@Test
	public void TestThatContactsAreReturnedfromContactDAOGetContacts() throws SQLException {
		Connection mockDb = Mockito.mock(Connection.class);
		ContactDAO contactDAO = new ContactDAO(mockDb);
		PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
		ResultSet mockResultSet = Mockito.mock(ResultSet.class);
		
		Mockito.when(mockDb.prepareStatement(ArgumentMatchers.anyString())).thenReturn(mockPreparedStatement);
		Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
		Mockito.when(mockResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
		
		Mockito.when(mockResultSet.getString("contactId")).thenReturn("1");
		Mockito.when(mockResultSet.getString("firstName")).thenReturn("Jordan");
		Mockito.when(mockResultSet.getString("lastName")).thenReturn("Stong");
		Mockito.when(mockResultSet.getString("phoneNumber")).thenReturn("555-555-5555");
		Mockito.when(mockResultSet.getString("addressId")).thenReturn("1")
			.thenReturn("2");
		Mockito.when(mockResultSet.getString("addressLine1")).thenReturn("123")
			.thenReturn("456");
		Mockito.when(mockResultSet.getString("addressLine2")).thenReturn("Fake St.")
			.thenReturn("Other St.");
		Mockito.when(mockResultSet.getString("city")).thenReturn("Faketown");
		Mockito.when(mockResultSet.getString("state")).thenReturn("Minnesota");
		Mockito.when(mockResultSet.getString("zipCode")).thenReturn("12345");
		Mockito.when(mockResultSet.getString("country")).thenReturn("USA");
		Mockito.when(mockResultSet.getString("addressType")).thenReturn("Home");
		
		List<Contact> contacts = contactDAO.getContacts();
		
		Assert.assertTrue(contacts.size() == 1);
		Assert.assertTrue(contacts.get(0).getFirstName().equals("Jordan"));
		Assert.assertTrue(contacts.get(0).getAddresses().size() == 2);
	}

	 

	private Contact createContact() {
		List<Address> addresses = new ArrayList<Address>();
		Address home = new Address("123", "Fake st.", "Faketown", "Minnesota", "12345", "USA");
		home.setType("Home");
		addresses.add(home);
		return new Contact("Jordan", "Stong", "555-555-5555", addresses);

	}
}
