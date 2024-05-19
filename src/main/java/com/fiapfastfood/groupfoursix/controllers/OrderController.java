package com.fiapfastfood.groupfoursix.controllers;

import com.fiapfastfood.groupfoursix.domain.Order;
import com.fiapfastfood.groupfoursix.domain.dto.OrderDTO;
import com.fiapfastfood.groupfoursix.domain.dto.StatusDTO;
import com.fiapfastfood.groupfoursix.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/create")
    public Order createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    @PutMapping(value = "/update")
    public Order updateOrder(@RequestBody StatusDTO statusDTO){
        return orderService.updateOrder(statusDTO);
    }

    @DeleteMapping(value = "/cancel")
    public Order cancelOrder(@RequestBody OrderDTO orderDTO){
        return orderService.cancelOrder(orderDTO.getId());
    }
}
