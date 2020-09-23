package edu.weber.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact implements Serializable{
	
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private List<Address> addresses;
	
	public Contact() {
		this(null, null, null, null);
	}
	
	public Contact(String firstName, String lastName, String phoneNumber, List<Address> addresses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.addresses = addresses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void addAddress(Address address) {
        if(addresses == null) {
            addresses = new ArrayList<>();
        }
        addresses.add(address);
    }
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public boolean equals(Object o) {
		 if (o == this) { 
	            return true; 
	        } 
	  
	        /* Check if o is an instance of Complex or not 
	          "null instanceof [type]" also returns false */
	        if (!(o instanceof Contact)) { 
	            return false; 
	        } 
	          
	        // typecast o to Complex so that we can compare data members  
	        Contact c = (Contact) o; 
	          
	        // Compare the data members and return accordingly  
	        if(c.firstName.equals(this.firstName) 
	        		&& c.lastName.equals(this.lastName)
	        		&& c.phoneNumber.equals(this.phoneNumber)) {
	        	Iterator<Address> i = this.addresses.iterator();
	        	for(Address a: c.addresses) {
	        		if(i.hasNext() && !a.equals(i.next())) {
	        			return false;
	        		}
	        	}
	        	return true;
	        } else {
	        	return false;
	        }
	}
	
	
}
