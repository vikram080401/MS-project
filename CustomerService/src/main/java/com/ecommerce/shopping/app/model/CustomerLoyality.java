package com.ecommerce.shopping.app.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customerloyality")
public class CustomerLoyality {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customerloyalityid", nullable = false)
	private long CustomerLoyalityid; //PK tbl_customerloyality
	
	@OneToOne
	@JoinColumn(name = "customerid")
	private Customers customer; //FK table tbl_customers
	
	@Column(name="goftcardbalance", nullable = false )
	private double GiftCardBalance=0.00;
}
