package com.ecommerce.shopping.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.shopping.app.model.CartItem;
import com.ecommerce.shopping.app.model.Order;
import com.ecommerce.shopping.app.service.CartService;
import com.ecommerce.shopping.app.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private CartService cartService;

	//**************************
	//Returns all Orders all status as list of Order Objects
	//******************************
	@GetMapping("/viewall")
	public List<Order> ViewAllOrder() {
		return orderService.getAllorder();
	}

	//***************************
	//View order by passing Order ID. Returns each item ordered which may be subset of complete Order
	//***************************
	@GetMapping("/viewone/{id}")
	public Order ViewOneOrder(@PathVariable long id) {
		return orderService.getOneOrder(id);
	}
	//*******************************
	//Saves an order
	//Returns saved order object
	//********************************
	@PostMapping("/place")
	public Order PlaceNewOrder(Order entity) {
		return orderService.SaveOrder(entity);
	}

	//*******************************
	//Cancel the OrderID by passing order ID as parameter
	//Returns cancelled order object
	//********************************
	@PostMapping("/cancel/{orderid}")
	public Order CancelOrder(@PathVariable long orderid) {
		return orderService.CancelOrder(orderid);
	}
	//*************************************
	//View Items in cart which is not converted to order
	//returns list of items in cart
	//*************************************
	@GetMapping("/viewCartItem")
	public List<CartItem> ViewAllCartItem() {
		return cartService.ViewItemsInCart();
	}
	
	//******************************
	//Create new Order by adding items from cart to final order
	//******************************
	@PostMapping("/create")
	public Order CreateNewOrder(@RequestBody CartItem cartitem) {

		return cartService.ConvertCartItemsToOrder(cartitem);

	}
	
	//******************************
	//View new Order by order number as input parameter
	//******************************
	@GetMapping("/ViewOrderNumber/{id}")
	public List<Order> ViewYourOrder(@PathVariable long id) {
		return orderService.getOrderbyOrderNumber(id);

	}
	//******************************
	//View new Order by Customer ID number as input parameter
	//******************************
	@GetMapping("/ViewOrderByCustomer/{id}")
	public List<Order> ViewOrderByCustomerID(@PathVariable long id) {
		return orderService.getOrderbyCustomerID(id);

	}
	//**********************************************************
	//Every Order contains multiple sub-order called orderID
	//Update status of one OrderID inside a Order number by passing 
	//Order ID and new status as parameter to be updated
	//Returns the updated Order object i.e a Order
	//***********************************************************

	@PostMapping("/UpdateOneOrderIDStatus")
	public Order UpdateOneOrderIDStatus(@RequestParam(value = "orderid") long orderid, @RequestParam String status) {
		return orderService.UpdateOrderStatus(orderid, status);
	}
	//*************************************************************************************
	//Every Order contains multiple sub-order called orderID
	//Update status of All OrderIDs inside a Order number by passing 
	//Order number( which is collection of orderIDs) and new status as parameter to be updated
	//Returns the updated collections of order IDs i.e complete Order 
	//****************************************************************************************
	@PostMapping("/UpdateAllOrderIDStatus")
	public List<Order> UpdateAllOrderIDStatus(@RequestParam(value = "orderno") long orderno, @RequestParam String status) {
		List<Order> newList=Collections.emptyList();
		List<Order> updatedList=new ArrayList<>();
		newList=orderService.getOrderbyOrderNumber(orderno);
		if(newList!=null) {
		for (Order order : newList) {
			long order_id=order.getOrderid();
			Order custorder= new Order();
			try {
				custorder = orderService.UpdateOrderStatus(order_id, status);
				System.out.println("orderid: "+custorder.getOrderid());
				updatedList.add(custorder);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}}
		
		return updatedList;
	}

}
