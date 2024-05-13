package com.fiapfastfood.groupfoursix.interfaces.impl;

import com.fiapfastfood.groupfoursix.domain.Order;
import com.fiapfastfood.groupfoursix.domain.dto.OrderDTO;
import com.fiapfastfood.groupfoursix.domain.dto.StatusDTO;
import com.fiapfastfood.groupfoursix.domain.repository.OrderRepository;
import com.fiapfastfood.groupfoursix.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        return orderRepository.save(new Order(orderDTO.getId()));
    }

    // Atualizar o DTO
    @Override
    public Order updateOrder(StatusDTO statusDTO) {
     /*   Order order = orderRepository.findById(statusDTO.getOrderId()).orElseGet(x -> new Order());
        if(order.isPresent()) {
            order = orderRepository.save(order);
        }*/

        return new Order();
    }

    @Override
    public Order cancelOrder(String id) {
      /*  Order order = orderRepository.findById(id);
        order.setOrderStatus(OrderStatus.CANCEL);*/
        return new Order();
    }
}
