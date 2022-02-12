/**
 * 
 */
package com.assignment2;

import java.util.List;

/**
 * @author Abhinav
 * 
 * Date: Feb 12, 2022
 * 
 * Description: It is POJO class with the fields to store all the information from the json files
 * and it stores the other 2 objects as well, i.e., Address and Score
 *
 */
public class StudentDetails {

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private List<Address> addressList;

	private List<Scores> scoresList;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the addressList
	 */
	public List<Address> getAddressList() {
		return addressList;
	}

	/**
	 * @param addressList the addressList to set
	 */
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	/**
	 * @return the scoresList
	 */
	public List<Scores> getScoresList() {
		return scoresList;
	}

	/**
	 * @param scoresList the scoresList to set
	 */
	public void setScoresList(List<Scores> scoresList) {
		this.scoresList = scoresList;
	}

}
