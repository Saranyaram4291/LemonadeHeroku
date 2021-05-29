package com.att.lemonade.test.data.objects;
public class Address{
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	public Address(String streetAddress, String city, String state, String zipcode) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public Address(String addressData){
		//StringTokenizer details=new StringTokenizer(addressData,"|");
		String details[]=addressData.split("\\|");
		if(details.length!=4){
			//return null;
		}else{
			this.streetAddress = details[0];
			this.city = details[1];
			this.state = details[2];
			this.zipcode = details[3];
		}
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
