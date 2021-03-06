package com.goods.spring.mvc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="tbl_customers")
public class Customers {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customerid", unique = true, nullable = false)
	private long customerid; // PK tbl_customers
	


	@Column(name="firstname", nullable = false)
	private String firstname;
	
	@Column(name="lasttname", nullable = false)
	private String lastname;
	
	@Column(name="dateofbirth", nullable = false)
	private String dateofbirth;
	
	@Column(name="contactnumber", nullable = false)
	private String contactnumber;
	
	@Column(name="addressline1", nullable = false)
	private String addressLine1;
	
	@Column(name="addressline2", nullable = true)
	private String addressLine2;
	
	@Column(name="zipcode", nullable = false)
	private String zipcode;
	
	
	private String state;
	private String city;
	
	@Column(name="secretquestion", nullable = true)
	private String secretquestion;
	
	@Column(name="Secretquestionanswer", nullable = true)
	private String secretquestionanswer;
    
	@Column(name="customeremailid", nullable = false, unique = true)
	private String customeremailid;
	
	@Column(name="status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status=Status.ACTIVE;

	public long getCustomerid() {
		return customerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getSecretquestion() {
		return secretquestion;
	}

	public String getSecretquestionanswer() {
		return secretquestionanswer;
	}

	public String getCustomeremailid() {
		return customeremailid;
	}

	public Status getStatus() {
		return status;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setSecretquestion(String secretquestion) {
		this.secretquestion = secretquestion;
	}

	public void setSecretquestionanswer(String secretquestionanswer) {
		this.secretquestionanswer = secretquestionanswer;
	}

	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Customers [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dateofbirth=" + dateofbirth + ", contactnumber=" + contactnumber + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", zipcode=" + zipcode + ", state=" + state + ", city=" + city
				+ ", secretquestion=" + secretquestion + ", secretquestionanswer=" + secretquestionanswer
				+ ", customeremailid=" + customeremailid + ", status=" + status + "]";
	}
	
	

}
