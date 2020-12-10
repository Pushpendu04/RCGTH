package com.cognizant.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.order.entity.Orders;
import com.cognizant.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Orders saveOrders(Orders orders) {
		return orderRepository.save(orders);
	}

}
