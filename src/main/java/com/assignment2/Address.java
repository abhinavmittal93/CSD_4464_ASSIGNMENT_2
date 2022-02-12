/**
 * 
 */
package com.assignment2;

/**
 * @author Abhinav
 * 
 * Date: Feb 12, 2022
 * 
 * Description: It is POJO class with the fields to store the information from the json files related to the address.
 *
 */
public class Address {
	
	private String street;
	
	private String city;
	
	private String state;

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	

}
