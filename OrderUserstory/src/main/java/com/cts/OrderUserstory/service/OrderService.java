package com.cts.OrderUserstory.service;

import java.util.List;

import com.cts.OrderUserstory.model.Order;

public interface OrderService {
	public long stampProfileWithOrder(Order order);
	public List<Order> getAllOrderDetails();

	public String deleteProfile(long orderId);
}
