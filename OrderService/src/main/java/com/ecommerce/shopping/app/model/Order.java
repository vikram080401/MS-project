package com.ecommerce.shopping.app.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class Order  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderid;

	@Column(name="ordernumber", nullable = true, unique = false)
	private long ordernumber;
	
	@Column(name="customerid", nullable = false, unique = false)
	private long customerid;

	@ManyToOne
	@JoinColumn(name = "cartitemid")
	private CartItem cartItem;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 10, nullable = false)
	private OrderStatus status;

	public long getOrderid() {
		return orderid;
	}

	public long getOrdernumber() {
		return ordernumber;
	}

	public long getCustomerid() {
		return customerid;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public void setOrdernumber(long ordernumber) {
		this.ordernumber = ordernumber;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", ordernumber=" + ordernumber + ", customerid=" + customerid
				+ ", cartItem=" + cartItem + ", status=" + status + "]";
	}

}
	
