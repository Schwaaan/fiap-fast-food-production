package com.fiapfastfood.groupfoursix.interfaces;

import com.fiapfastfood.groupfoursix.domain.Order;
import com.fiapfastfood.groupfoursix.domain.dto.OrderDTO;
import com.fiapfastfood.groupfoursix.domain.dto.StatusDTO;

public interface OrderService {


    Order createOrder(OrderDTO orderDTO);

    Order cancelOrder(String id);

    Order updateOrder(StatusDTO statusDTO);
}
