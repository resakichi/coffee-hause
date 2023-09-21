package com.coffeehause.web.repository;

import com.coffeehause.web.entity.Order;
import com.coffeehause.web.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.client_id = ?1")
    List<Order> findByClientId(int param);
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Order o SET o.stage = ?1 where o.order_id = ?2")
    void updateOrderStage(Stage stage, int orderId);
}