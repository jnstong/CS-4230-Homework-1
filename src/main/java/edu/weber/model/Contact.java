package edu.weber.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact implements Serializable{
	//@JsonProperty("fn") //changes what the variable is called 
	private String firstName;
	private String lastName;
	private Address homeAddress;
	private Address businessAddress;
	private String phoneNumber;
	
	public Contact() {
		this(null, null, null, null, null);
	}
	
	public Contact(String firstName, String lastName, String phoneNumber, Address homeAddress, Address businessAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeAddress = homeAddress;
		this.businessAddress = businessAddress;
		this.phoneNumber = phoneNumber;
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

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Address getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(Address businessAddress) {
		this.businessAddress = businessAddress;
	}

	
	
}
