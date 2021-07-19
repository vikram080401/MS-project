package com.ecommerce.shopping.oauth2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userinfoid;
	
	@Column(nullable = true)
	private String id;
	
	@Column(nullable = true)
	private String email;
	
	@Column(name = "imageurl" , nullable = true)
	private String imageUrl;
	
	@Column(nullable = true)
	private String name;
	
	public int getUserinfoid() {
		return userinfoid;
	}
	public void setUserinfoid(int userinfoid) {
		this.userinfoid = userinfoid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
