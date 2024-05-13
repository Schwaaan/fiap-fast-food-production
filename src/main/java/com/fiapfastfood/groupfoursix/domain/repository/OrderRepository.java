package com.fiapfastfood.groupfoursix.domain.repository;

import com.fiapfastfood.groupfoursix.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
}
