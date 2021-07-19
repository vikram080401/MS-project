package com.ecommerce.shopping.app.service;

import java.util.List;

import com.ecommerce.shopping.app.model.Order;

public interface IOrderService {

	public List<Order> getAllorder();
	public Order getOneOrder(Long id);
	public Order SaveOrder(Order entity);
	public Order CancelOrder(long OrderID);
	public List<Order> getOrderbyOrderNumber(long ordrenumber);
}
