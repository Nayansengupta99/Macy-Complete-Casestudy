package com.cts.OrderUserstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.OrderUserstory.DTO.ProfileModel;
import com.cts.OrderUserstory.client.ProfileClient;
import com.cts.OrderUserstory.exception.OrderNotFoundException;
import com.cts.OrderUserstory.exception.ProfileNotFoundException;
import com.cts.OrderUserstory.model.Order;
import com.cts.OrderUserstory.repo.OrderRepository;

import lombok.extern.java.Log;

@Service
@Log
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProfileClient client;
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public long stampProfileWithOrder(Order order) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		Order bookedOrder = null;
		List<ProfileModel> modelList = client.getAllProfileDetails();
		long profileId = 0l;
		for (ProfileModel m : modelList) {
			if (m.getCriteriaValue().equals(order.getOrderType())) {
				bookedOrder = new Order(order.getOrderId(), order.getOrderNumber(), order.getOrderType(),
						m.getProfileType());
				profileId = m.getProfileId();
				log.info("Order saved successfully");
				orderRepo.save(bookedOrder);
				return profileId;

				
			}
			
		}
		throw new ProfileNotFoundException(order.getOrderType());
	}

	@Override
	public String deleteProfile(long orderId) {
		if (orderRepo.findById(orderId).isPresent()) {
			log.info("Order deleted successfully");

			orderRepo.deleteById(orderId);
			return "Order id " + Long.toString(orderId) + " deleted successfully";
		} else {
			throw new OrderNotFoundException(orderId);
		}
	}

	@Override
	public List<Order> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

}
