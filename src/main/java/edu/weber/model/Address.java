package edu.weber.model;

import java.io.Serializable;

public class Address implements Serializable{
	private String id;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String type;
	
	public Address() {
		this(null, null, null, null, null, null);
	}
	
	public Address(String addressLine1, String addressLine2, String city, String state, String zipCode, String country) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}
	
	public Address(String addressLine1, String city, String state, String postalCode, String country) {
		this(addressLine1, null, city, state, postalCode, country);
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	        Address a = (Address) o; 
	        // Compare the data members and return accordingly  
	        if(a.addressLine1.equals(this.addressLine1)
	        		&& a.addressLine2.equals(this.addressLine2)
	        		&& a.city.equals(this.city)
	        		&& a.state.equals(this.state)
	        		&& a.zipCode.equals(this.zipCode)
	        		&& a.country.equals(this.country)) {
	        	return true;
	        } else {
	        	return false;
	        }
	}
	
	
	
	
}
