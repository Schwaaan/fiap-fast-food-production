package com.fiapfastfood.groupfoursix.interfaces.impl;

import com.fiapfastfood.groupfoursix.domain.Order;
import com.fiapfastfood.groupfoursix.domain.OrderStatus;
import com.fiapfastfood.groupfoursix.domain.dto.OrderDTO;
import com.fiapfastfood.groupfoursix.domain.dto.StatusDTO;
import com.fiapfastfood.groupfoursix.domain.repository.OrderRepository;
import com.fiapfastfood.groupfoursix.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        return orderRepository.save(new Order(orderDTO.getId()));
    }

    @Override
    public Order updateOrder(StatusDTO statusDTO) {
        Optional<Order> order = orderRepository.findById(statusDTO.getOrderId());

        if (order.isPresent()) {
            order.get().setOrderStatus(OrderStatus.from(statusDTO.getStatusId()));
            return orderRepository.save(order.get());
        }

        return new Order();
    }

    @Override
    public Order cancelOrder(String id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            order.get().setOrderStatus(OrderStatus.CANCEL);
            return orderRepository.save(order.get());
        }

        return new Order();
    }
}
