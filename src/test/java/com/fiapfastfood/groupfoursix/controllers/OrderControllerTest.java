package com.fiapfastfood.groupfoursix.controllers;

import com.fiapfastfood.groupfoursix.domain.Order;
import com.fiapfastfood.groupfoursix.domain.OrderStatus;
import com.fiapfastfood.groupfoursix.domain.dto.OrderDTO;
import com.fiapfastfood.groupfoursix.domain.dto.StatusDTO;
import com.fiapfastfood.groupfoursix.interfaces.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class OrderControllerTest {

    @Spy
    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderServiceImpl orderServiceimpl;

    @Test
    void createOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("2");
        Mockito.when(orderServiceimpl.createOrder(orderDTO)).thenReturn(new Order("2"));

        Order order = orderController.createOrder(orderDTO);

        assertEquals(orderDTO.getId(), order.getId());
        assertEquals(OrderStatus.PROGRESS, order.getOrderStatus());
    }

    @Test
    void updateOrder() {
        StatusDTO statusDTO = new StatusDTO("1", 2L);
        Mockito.when(orderServiceimpl.updateOrder(statusDTO)).thenReturn(new Order("1", OrderStatus.DONE));

        Order order = orderController.updateOrder(statusDTO);

        assertEquals(statusDTO.getOrderId(), order.getId());
        assertEquals(OrderStatus.DONE, order.getOrderStatus());
    }

    @Test
    void cancelOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("2");

        Mockito.when(orderServiceimpl.cancelOrder(orderDTO.getId())).thenReturn(new Order("2", OrderStatus.CANCEL));

        Order order = orderController.cancelOrder(orderDTO);

        assertEquals(orderDTO.getId(), order.getId());
        assertEquals(OrderStatus.CANCEL, order.getOrderStatus());
    }
}