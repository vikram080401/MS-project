package com.ecommerce.shopping.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_ordernumberbuilder")
@TableGenerator(name="tab", initialValue=500000, allocationSize=1)
public class OrderNumberBuilder {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Column(name = "ordernumber", unique = true, nullable = false)
	private long Ordernumber;

	public long getOrdernumber() {
		return Ordernumber;
	}

	public void setOrdernumber(long ordernumber) {
		Ordernumber = ordernumber;
	}
	
}
