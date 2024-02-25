package com.Bank_Property_Evaluation.PropertyManagement;

public class Borrower {
	private String customerNumber;
    private String customerName;
    private String contactNumber;
    private String email;
    private String address;
	@Override
	public String toString() {
		return "Borrower [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", email=" + email + ", address=" + address + "]";
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Borrower(String customerNumber, String customerName, String contactNumber, String email, String address) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
	}
	public Borrower() {}
    
}
