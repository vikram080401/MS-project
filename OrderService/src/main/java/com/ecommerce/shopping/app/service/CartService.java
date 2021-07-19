package com.ecommerce.shopping.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping.app.dao.CartItemRepository;
import com.ecommerce.shopping.app.dao.OrderNumberBuilderRepository;
import com.ecommerce.shopping.app.model.CartItem;
import com.ecommerce.shopping.app.model.Customer;
import com.ecommerce.shopping.app.model.Order;
import com.ecommerce.shopping.app.model.OrderNumberBuilder;
import com.ecommerce.shopping.app.model.OrderStatus;
import com.ecommerce.shopping.app.model.Product;

@Service
public class CartService {

	@Autowired
	private CartItemRepository cartItemRepos;
	
	@Autowired
	private OrderNumberBuilderRepository orderbuilderRepos;
	
	@Autowired
	private OrderService orderService;
	
	
	
	public Order ConvertCartItemsToOrder(CartItem cartitem) {
		CartItem listcartItem=cartitem;
		
		
		System.out.println("cartitem item quantity :"+ listcartItem.getItemquantity());
		Order ordered=new Order();
		Customer customer= new Customer();
		customer.setCustomerid(identifyCustomer());
		long ordernumber=BuildOrderNumber();
		
			ordered.setCartItem(listcartItem);
			ordered.setOrdernumber(ordernumber);
			ordered.setStatus(OrderStatus.CONFIRMED);
			ordered.setCustomerid(customer.getCustomerid());
	
		
		ordered.setStatus(OrderStatus.PLACED);
		
		
		
		return orderService.orderRepos.save(ordered);
		
	}
	public long BuildOrderNumber() {
		OrderNumberBuilder newOrdernumberObject= new OrderNumberBuilder();
		long ordrno= orderbuilderRepos.save(newOrdernumberObject).getOrdernumber();
		
		System.out.println("wait");
		return ordrno;
	}
	
	public CartItem AddItemstoCart(int quantity, Product product) {
		CartItem cartItem=new CartItem();
		cartItem.setProduct(product);
		cartItem.setItemquantity(quantity);
		CartItem ItemAddedtoCart=cartItemRepos.save(cartItem);
		return ItemAddedtoCart;
	}
	public List<CartItem> ViewItemsInCart() {
		return (List<CartItem>) cartItemRepos.findAll();
	}
	
	public long identifyCustomer() {
		return 100000;
		
	}


}
