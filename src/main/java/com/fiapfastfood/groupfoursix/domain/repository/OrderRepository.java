package com.fiapfastfood.groupfoursix.domain.repository;

import com.fiapfastfood.groupfoursix.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
