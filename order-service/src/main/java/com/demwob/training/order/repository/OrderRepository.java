package com.demwob.training.order.repository;

import com.demwob.training.order.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
