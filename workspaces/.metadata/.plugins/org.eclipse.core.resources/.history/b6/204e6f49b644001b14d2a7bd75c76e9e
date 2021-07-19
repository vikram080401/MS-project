package com.ecommerce.shopping.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Users {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="customeremailid", nullable = false, unique = true) //1
	private String customeremailid;
	
	@Column(name="customrusername", nullable = false) //2
	private String customerusername;
	
	@Column(name="password", nullable = false) //3
	private String password;
	
	@Column(name="contactnumber", nullable = false) //4
	private String contactnumber;

	@Column(name="firstname", nullable = false) //5
	private String firstname;
	
	@Column(name="lasttname", nullable = false) //6
	private String lastname;
	
	@Column(name="dateofbirth", nullable = false) //7
	private String dateofbirth;
	
	
	
	@Column(name="addressline1", nullable = false) //8
	private String addressLine1;
	
	@Column(name="addressline2", nullable = true) //9
	private String addressLine2;
	
	@Column(name="zipcode", nullable = false) //10
	private String zipcode;
	
	private String city; //11
	
	private String state; //12
	
	
	@Column(name="secretquestion", nullable = true) //13
	private String secretquestion;
	
	@Column(name="Secretquestionanswer", nullable = true) //14
	private String secretquestionanswer;

	public String getCustomeremailid() {
		return customeremailid;
	}

	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}

	public String getCustomerusername() {
		return customerusername;
	}

	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

	public String getSecretquestion() {
		return secretquestion;
	}

	public void setSecretquestion(String secretquestion) {
		this.secretquestion = secretquestion;
	}

	public String getSecretquestionanswer() {
		return secretquestionanswer;
	}

	public void setSecretquestionanswer(String secretquestionanswer) {
		this.secretquestionanswer = secretquestionanswer;
	}

	@Override
	public String toString() {
		return "Users [customeremailid=" + customeremailid + ", customerusername=" + customerusername + ", password="
				+ password + ", contactnumber=" + contactnumber + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dateofbirth=" + dateofbirth + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", zipcode=" + zipcode + ", city=" + city + ", state=" + state + ", secretquestion=" + secretquestion
				+ ", secretquestionanswer=" + secretquestionanswer + "]";
	}
    
	

}
