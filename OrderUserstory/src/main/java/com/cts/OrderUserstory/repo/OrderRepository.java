package com.cts.OrderUserstory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.OrderUserstory.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{





}
