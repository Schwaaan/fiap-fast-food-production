package com.fiapfastfood.groupfoursix.interfaces.impl;

import com.fiapfastfood.groupfoursix.domain.Order;
import com.fiapfastfood.groupfoursix.domain.OrderStatus;
import com.fiapfastfood.groupfoursix.domain.dto.OrderDTO;
import com.fiapfastfood.groupfoursix.domain.dto.StatusDTO;
import com.fiapfastfood.groupfoursix.domain.repository.OrderRepository;
import com.fiapfastfood.groupfoursix.interfaces.OrderService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Or;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void createOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("1");
        Mockito.when(orderRepository.save(new Order("1"))).thenReturn(new Order("1"));
        Order order = orderService.createOrder(orderDTO);
        assertNotNull(order);
        assertEquals(order.getId(), orderDTO.getId());
        assertEquals(order.getOrderStatus(), OrderStatus.PROGRESS);
    }

    @Test
    void findOrderAfterCreateOrderReturnOrderCreated() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("2");
        orderService.createOrder(orderDTO);
        Mockito.when(orderRepository.findById("2")).thenReturn(Optional.of(new Order("2")));
        Order order = orderRepository.findById("2").get();
        assertNotNull(order);
        assertEquals(order.getId(), orderDTO.getId());
        assertEquals(order.getOrderStatus(), OrderStatus.PROGRESS);
    }

    @Test
    void updateOrder() {
        Mockito.when(orderRepository.findById("3")).thenReturn(Optional.of(new Order("3")));
        Mockito.when(orderRepository.save(new Order("3", OrderStatus.DONE))).thenReturn(new Order("3", OrderStatus.DONE));

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("3");

        Order order = orderService.updateOrder(new StatusDTO("3", 2L));

        assertNotNull(order);
        assertEquals(order.getId(), orderDTO.getId());
        assertEquals(order.getOrderStatus(), OrderStatus.DONE);
    }

    @Test
    void notUpdateOrderBecauseNotFound() {
        Mockito.when(orderRepository.findById("3")).thenReturn(Optional.of(new Order("3")));
        Mockito.when(orderRepository.save(new Order("3", OrderStatus.DONE))).thenReturn(new Order("3", OrderStatus.DONE));

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("4");

        Order order = orderService.updateOrder(new StatusDTO("4", 2L));

        assertNull(order.getId());
        assertNull(order.getOrderStatus());
    }

    @Test
    void notCancelOrderBecauseNotFound() {
        Mockito.when(orderRepository.findById("3")).thenReturn(Optional.of(new Order("3")));
        Mockito.when(orderRepository.save(new Order("3", OrderStatus.DONE))).thenReturn(new Order("3", OrderStatus.DONE));
        Order order = orderService.cancelOrder("5");

        assertNull(order.getId());
        assertNull(order.getOrderStatus());
    }

    @Test
    void cancelOrder() {
        Mockito.when(orderRepository.findById("4")).thenReturn(Optional.of(new Order("4")));
        Mockito.when(orderRepository.save(new Order("4", OrderStatus.CANCEL))).thenReturn(new Order("4", OrderStatus.CANCEL));
        orderService.cancelOrder("4");
    }
}