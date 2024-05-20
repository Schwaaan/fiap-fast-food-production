package com.fiapfastfood.groupfoursix.interfaces.impl;

import com.fiapfastfood.groupfoursix.domain.Order;
import com.fiapfastfood.groupfoursix.domain.OrderStatus;
import com.fiapfastfood.groupfoursix.domain.dto.OrderDTO;
import com.fiapfastfood.groupfoursix.domain.dto.StatusDTO;
import com.fiapfastfood.groupfoursix.domain.repository.OrderRepository;
import com.fiapfastfood.groupfoursix.interfaces.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Value(("${order.url}"))
    @Getter
    private String orderUrl;

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        return orderRepository.save(new Order(orderDTO.getId()));
    }

    @Override
    public Order updateOrder(StatusDTO statusDTO) {
        Optional<Order> order = orderRepository.findById(statusDTO.getOrderId());

        if (order.isPresent()) {
            order.get().setOrderStatus(OrderStatus.from(statusDTO.getStatusId()));
            Order orderSaved = orderRepository.save(order.get());
            if (OrderStatus.DONE.equals(orderSaved.getOrderStatus())) {
                request(orderSaved.getId());
            }

            return orderSaved;
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

    private void request(String pedidoId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = orderUrl + "/pedidos/" + pedidoId + "/status/" + 5;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        System.out.println("Response: " + response);
    }
}
