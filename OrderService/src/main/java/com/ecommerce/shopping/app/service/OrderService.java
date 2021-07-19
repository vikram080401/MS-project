package com.ecommerce.shopping.app.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping.app.dao.OrderRepository;
import com.ecommerce.shopping.app.model.Order;
import com.ecommerce.shopping.app.model.OrderStatus;

@Service
public class OrderService implements IOrderService {

	Logger logger = LoggerFactory.getLogger(OrderService.class);
	@Autowired
	OrderRepository orderRepos;

	public List<Order> getAllorder() {
		return (List<Order>) orderRepos.findAll();
	}

	public Order getOneOrder(Long id) {
		return orderRepos.findById(id).orElse(null);
	}

	public List<Order> getOrderbyOrderNumber(long ordernumber) {
		List<Order> ord =Collections.emptyList();
		try {
			ord = orderRepos.findByOrdernumber(ordernumber); 
		} catch (Exception e) {
			logger.error("Order-Service: " + e.getMessage());
		}
		return ord;
	}

	public Order SaveOrder(Order entity) {
		return orderRepos.save(entity);
	}

	public Order CancelOrder(long OrderID) {
		Order order = new Order();
		try {
			order = orderRepos.findById(OrderID).orElse(null);
			if (order != null) {
				Order updateOrder = new Order();
				updateOrder.setCartItem(order.getCartItem());
				updateOrder.setOrderid(order.getOrderid());
				updateOrder.setOrdernumber(order.getOrdernumber());
				updateOrder.setStatus(OrderStatus.CANCELLED);
				updateOrder.setCustomerid(order.getCustomerid());
				order = orderRepos.save(updateOrder);
			} else {
				logger.error("Order-Service: " + OrderID + " is invalid.");
			}
		} catch (Exception e) {
			logger.error("Order-Service: " + e.getMessage());
		}
		return order;
	}

	// **************************//
	// This method returns the list orders placed by a customers with any status//
	// **************************//
	public List<Order> getOrderbyCustomerID(long id) {
		List<Order> orderbyCustomerID = Collections.emptyList();

		try {
			orderbyCustomerID = orderRepos.findByCustomerid(id);

		} catch (Exception e) {
			logger.error("Order-Service: " + e.getMessage());
		}
		return orderbyCustomerID;
	}

	// *****************************//
	// Update Order Status for a OrderID//
	public Order UpdateOrderStatus(long OrderID, String status) {
		Order order = new Order();
		String sta = status.toUpperCase();
		System.out.println(sta);
		try {
			order = orderRepos.findById(OrderID).orElse(null);
			logger.info("2");
			if (order != null) {
				Order updateOrder = new Order();
				long ordernumber=order.getCustomerid();
				if (sta.matches("PLACED")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.PLACED);
				} else if (sta.matches("PREPARING")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.PREPARING);
				} else if (sta.matches("CANCELLED")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.CANCELLED);
				} else if (sta.matches("SHIPPING")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.SHIPPING);
				} else if (sta.matches("SHIPPED")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.SHIPPED);
				} else if (sta.matches("DELIVERED")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.DELIVERED);
				} else if (sta.matches("RETURNED")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.RETURNED);
				} else if (sta.matches("PAUSED")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.PAUSED);
				} else if (sta.matches("PENDING")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.PENDING);
				} else if (sta.matches("CONFIRMED")) {
					logger.info("Order-Service: Setting the order status to " + sta +" for order number :"+ordernumber);
					updateOrder.setStatus(OrderStatus.CONFIRMED);
				} else logger.error("Order-Service: Invalid status "+sta +"! Order status update unsuccesful for order number "+ordernumber);

				updateOrder.setCartItem(order.getCartItem());

				updateOrder.setOrderid(order.getOrderid());

				updateOrder.setOrdernumber(order.getOrdernumber());

				updateOrder.setCustomerid(order.getCustomerid());

				logger.info(updateOrder.toString());
				order = orderRepos.save(updateOrder);
			} else {
				logger.error("Order-Service: " + OrderID + " is invalid.");
			}
		} catch (Exception e) {
			logger.error("Order-Service: "+"Order Number: "+order.getOrdernumber()+" :" + e.getMessage());
		}
		return order;
	}

}
